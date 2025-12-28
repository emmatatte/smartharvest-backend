package pe.edu.upc.smartharvest.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@RestController
@RequestMapping("/ia")
@CrossOrigin(origins = "https://smartharvest-frontend.onrender.com")
public class IAController {

    // Esta variable leerá la llave desde Render (Environment Variables)
    @Value("${OPENROUTER_API_KEY}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/consultar")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR','DUEÑO_DE_MERCADO')")
    public ResponseEntity<Object> preguntar(@RequestBody Map<String, String> request) {
        String url = "https://openrouter.ai/api/v1/chat/completions";

        // Configurar Headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("HTTP-Referer", "https://smartharvest-frontend.onrender.com");

        // Construir el cuerpo de la petición para OpenRouter
        Map<String, Object> body = new HashMap<>();
        body.put("model", "google/gemini-2.0-flash-exp:free");

        List<Map<String, String>> messages = new ArrayList<>();
        messages.add(Map.of("role", "system", "content", "Eres un experto en agricultura de precisión. Solo respondes temas agrícolas. Máximo 300 caracteres."));
        messages.add(Map.of("role", "user", "content", request.get("pregunta")));

        body.put("messages", messages);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        try {
            return restTemplate.postForEntity(url, entity, Object.class);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error al conectar con la IA: " + e.getMessage()));
        }
    }
}

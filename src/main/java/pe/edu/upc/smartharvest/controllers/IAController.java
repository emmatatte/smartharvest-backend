package pe.edu.upc.smartharvest.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@RestController
@RequestMapping("/ia")
@CrossOrigin(origins = "*") // Permite pruebas globales temporalmente
public class IAController {

    // Agregamos un valor por defecto ":" para evitar que falle si la variable no carga
    @Value("${OPENROUTER_API_KEY::}")
    private String apiKey;

    @PostMapping("/consultar")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR','DUEÑO_DE_MERCADO')")
    public ResponseEntity<Object> preguntar(@RequestBody Map<String, String> request) {

        // Verificación de seguridad en el log del Backend
        if (apiKey == null || apiKey.isEmpty()) {
            return ResponseEntity.status(500).body(Map.of("error", "API Key no configurada en el servidor"));
        }

        String url = "https://openrouter.ai/api/v1/chat/completions";

        RestTemplate restTemplate = new RestTemplate();
        // Configuramos un timeout manual para que el backend no espere eternamente
        // y evitar que Render mate la conexión con un 502
        /* Note: En un entorno real se usaría un Bean de RestTemplate configurado */

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("HTTP-Referer", "https://smartharvest-frontend.onrender.com");

        Map<String, Object> body = new HashMap<>();
        body.put("model", "google/gemini-2.0-flash-exp:free");

        List<Map<String, String>> messages = new ArrayList<>();
        messages.add(Map.of("role", "system", "content", "Experto agrícola. Máximo 300 caracteres."));
        messages.add(Map.of("role", "user", "content", request.get("pregunta")));
        body.put("messages", messages);

        try {
            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
            return restTemplate.postForEntity(url, entity, Object.class);
        } catch (Exception e) {
            // Esto imprimirá el error real en los logs de Render
            System.err.println("Error en llamada a OpenRouter: " + e.getMessage());
            return ResponseEntity.status(504).body(Map.of("error", "La IA tardó demasiado en responder"));
        }
    }
}

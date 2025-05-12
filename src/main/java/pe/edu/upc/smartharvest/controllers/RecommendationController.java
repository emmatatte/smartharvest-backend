package pe.edu.upc.smartharvest.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.RecommendationDTO;
import pe.edu.upc.smartharvest.entities.Crop;
import pe.edu.upc.smartharvest.entities.Recommendation;
import pe.edu.upc.smartharvest.servicesinterfaces.IRecommendationService;

import java.util.List;
import java.util.stream.Collectors;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/recommendations")
public class RecommendationController {
    @Autowired
    private IRecommendationService rS;

    public RecommendationController() {
    }

    @GetMapping
    public List<RecommendationDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecommendationDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void register(@RequestBody RecommendationDTO rDTO) {
        ModelMapper m = new ModelMapper();
        Recommendation recommendation = m.map(rDTO, Recommendation.class);

        Crop c = new Crop();
        c.setIdCrop(rDTO.getCropId());
        recommendation.setCrop(c);

        rS.insert(recommendation);
    }

    @PutMapping
    public void modificar(@RequestBody RecommendationDTO rDTO) {
        ModelMapper m = new ModelMapper();
        Recommendation recommendation = m.map(rDTO, Recommendation.class);

        Crop c = new Crop();
        c.setIdCrop(rDTO.getCropId());
        recommendation.setCrop(c);
        rS.update(recommendation);
    }

    @DeleteMapping("/{idRecomendation}")
    public void eliminar(@PathVariable int idRecomendation) {
        rS.delete(idRecomendation);
    }

    @GetMapping("/by-crop/{cropId}")
    public List<RecommendationDTO> getByCrop(@PathVariable("cropId") Integer cropId) {
        return rS.findByCropId(cropId).stream()
                .map(x -> new ModelMapper().map(x, RecommendationDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/by-user/{userId}")
    public List<RecommendationDTO> getByUser(@PathVariable("userId") Integer userId) {
        return rS.findByUserId(userId).stream()
                .map(x -> new ModelMapper().map(x, RecommendationDTO.class))
                .collect(Collectors.toList());
    }


    @GetMapping("/recomendaciones/sensores-humedad-baja")
    @PreAuthorize("hasAnyAuthority('USER')")
    public ResponseEntity<List<Recommendation>> getRecommendationsBySensorHumidity(@RequestParam Double threshold) {
        return ResponseEntity.ok(rS.findByLowHumiditySensors(threshold));
    }

    @GetMapping("/ranking-recomendaciones-por-parcela")
    @PreAuthorize("hasAnyAuthority('TECHNICIAN')")
    public ResponseEntity<List<String[]>> getRecommendationRankingByParcel() {
        return ResponseEntity.ok(rS.findRecommendationCountByParcel());
    }


}

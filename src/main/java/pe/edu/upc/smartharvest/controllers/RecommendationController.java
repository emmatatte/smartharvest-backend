package pe.edu.upc.smartharvest.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.RecommendationDTO;
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
        Recommendation r = m.map(rDTO, Recommendation.class);
        rS.insert(r);
    }

    @PutMapping
    public void modificar(@RequestBody Recommendation rDTO) {
        ModelMapper m = new ModelMapper();
        Recommendation r = m.map(rDTO, Recommendation.class);
        rS.update(r);
    }

    @DeleteMapping("/{idRecomendation}")
    public void eliminar(@PathVariable int idRecomendation) {
        rS.delete(idRecomendation);
    }
}

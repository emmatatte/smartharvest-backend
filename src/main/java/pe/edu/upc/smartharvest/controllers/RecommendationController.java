package pe.edu.upc.smartharvest.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.*;
import pe.edu.upc.smartharvest.entities.Crop;
import pe.edu.upc.smartharvest.entities.Recommendation;
import pe.edu.upc.smartharvest.servicesinterfaces.IRecommendationService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recommendations")
@SecurityRequirement(name = "bearerAuth")
public class RecommendationController {
    @Autowired
    private IRecommendationService rS;

    public RecommendationController() {
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<RecommendationDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecommendationDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void register(@RequestBody RecommendationDTOforRegister rDTO) {
        ModelMapper m = new ModelMapper();
        Recommendation recommendation = m.map(rDTO, Recommendation.class);
        rS.insert(recommendation);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void modificar(@RequestBody RecommendationDTOforRegister rDTO) {
        ModelMapper m = new ModelMapper();
        Recommendation recommendation = m.map(rDTO, Recommendation.class);
        rS.update(recommendation);
    }

    @DeleteMapping("/{idRecomendation}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void eliminar(@PathVariable int idRecomendation) {
        rS.delete(idRecomendation);
    }

    @GetMapping("/by-crop/{cropId}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<RecommendationDTO> getByCrop(@PathVariable("cropId") Integer cropId) {
        return rS.findByCropId(cropId).stream()
                .map(x -> new ModelMapper().map(x, RecommendationDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/by-user/{userId}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<RecommendationDTO> getByUser(@PathVariable("userId") Integer userId) {
        return rS.findByUserId(userId).stream()
                .map(x -> new ModelMapper().map(x, RecommendationDTO.class))
                .collect(Collectors.toList());
    }


    @GetMapping("/recomendaciones/sensores-humedad-baja")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public ResponseEntity<List<Recommendation>> getRecommendationsBySensorHumidity(@RequestParam Double threshold) {
        return ResponseEntity.ok(rS.findByLowHumiditySensors(threshold));
    }

    @GetMapping("/ranking-recomendaciones-por-parcela")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public ResponseEntity<List<String[]>> getRecommendationRankingByParcel() {
        return ResponseEntity.ok(rS.findRecommendationCountByParcel());
    }

    @GetMapping("/findRecommendations")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<findRecommendationsDTO> findRecommendations(){
        List<findRecommendationsDTO> dtoList = new ArrayList<>();
        List<String[]> RowList=rS.findRecommendations();
        for(String[] column:RowList){
            findRecommendationsDTO dto = new findRecommendationsDTO();
            dto.setIdRecommendation(Integer.parseInt(column[0]));
            dto.setDescription(column[1]);
            dto.setIDROP(Integer.parseInt(column[2]));
            dto.setType(column[3]);
            dto.setState(column[4]);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @GetMapping("/recommendationsbymonth/{year}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<RecommendationsByMonthInYearDTO> parcelsByMonth(@PathVariable("year") int year){
        List<RecommendationsByMonthInYearDTO> dtoList = new ArrayList<>();
        List<String[]> RowList=rS.recommendationsByMonth(year);
        for(String[] column:RowList){
            RecommendationsByMonthInYearDTO dto = new RecommendationsByMonthInYearDTO();
            dto.setMes(column[0]);
            dto.setQuantity(Integer.parseInt(column[1]));
            dtoList.add(dto);
        }
        return dtoList;
    }

    @GetMapping("/{idRecommendation}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public RecommendationDTO listarId(@PathVariable("idRecommendation") int idRecommendation) {
        ModelMapper m = new ModelMapper();
        RecommendationDTO dto = m.map(rS.listId(idRecommendation), RecommendationDTO.class);
        return dto;
    }
}

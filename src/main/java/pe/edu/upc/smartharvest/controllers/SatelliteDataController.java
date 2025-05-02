package pe.edu.upc.smartharvest.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.SatelliteDataDTO;
import pe.edu.upc.smartharvest.entities.SatelliteData;
import pe.edu.upc.smartharvest.servicesinterfaces.ISatelliteDataService;

import java.util.List;
import java.util.stream.Collectors;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/satellite-data")
public class SatelliteDataController {

    @Autowired
    private ISatelliteDataService service;

    @GetMapping
    public List<SatelliteDataDTO> list() {
        return service.list().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SatelliteDataDTO findById(@PathVariable Long id) {
        return convertToDTO(service.findById(id));
    }

    @PostMapping
    public void create(@RequestBody SatelliteDataDTO dto) {
        service.insert(convertToEntity(dto));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody SatelliteDataDTO dto) {
        SatelliteData existingData = service.findById(id);
        if (existingData != null) {
            service.update(convertToEntity(dto));
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/crop/{cropId}")
    public List<SatelliteDataDTO> getSatelliteDataByCropId(@PathVariable int cropId) {
        return service.findByCropId(cropId).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private SatelliteDataDTO convertToDTO(SatelliteData entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, SatelliteDataDTO.class);
    }

    private SatelliteData convertToEntity(SatelliteDataDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, SatelliteData.class);
    }

    @GetMapping("/by-zone") // US14 - El usuario puede obtener datos satelitales dentro de una zona geográfica específica.
    public List<SatelliteDataDTO> getByZone(@RequestParam double minLat,
                                            @RequestParam double maxLat,
                                            @RequestParam double minLon,
                                            @RequestParam double maxLon) {
        return service.findByLatLongRange(minLat, maxLat, minLon, maxLon)
                .stream()
                .map(x -> new ModelMapper().map(x, SatelliteDataDTO.class))
                .collect(Collectors.toList());
    }

}
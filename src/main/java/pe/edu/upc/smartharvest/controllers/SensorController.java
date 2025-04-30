package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.SensorDTO;
import pe.edu.upc.smartharvest.entities.Sensor;
import pe.edu.upc.smartharvest.servicesinterfaces.ISensorService;

import java.util.List;
import java.util.stream.Collectors;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/sensors")
public class SensorController {
    @Autowired
    private ISensorService sS;

    public SensorController() {
    }

    @GetMapping
    public List<SensorDTO> listar() {
        return sS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SensorDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody SensorDTO sDTO) {
        ModelMapper m = new ModelMapper();
        Sensor s = m.map(sDTO, Sensor.class);
        sS.insert(s);
    }

    @PutMapping
    public void modificar(@RequestBody SensorDTO sDTO) {
        ModelMapper m = new ModelMapper();
        Sensor s = m.map(sDTO, Sensor.class);
        sS.update(s);
    }

    @DeleteMapping("/{idSensor}")
    public void eliminar(@PathVariable int idSensor) {
        sS.delete(idSensor);
    }

    @GetMapping("/satellite-data")
    public ResponseEntity<List<SensorDTO>> getSatelliteData(
            @RequestParam Long parcelId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(sensorService.getSatelliteData(parcelId, startDate, endDate));
    }
}

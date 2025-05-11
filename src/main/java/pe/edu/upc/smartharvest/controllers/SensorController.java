package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/DeleteByID/{idSensor}")
    public SensorDTO listarId(@PathVariable("idSensor") int idSensor) {
        ModelMapper m = new ModelMapper();
        SensorDTO dto = m.map(sS.listId(idSensor), SensorDTO.class);
        return dto;
    }

    @GetMapping("/daily-summary")
    public ResponseEntity<List<SensorDTO>> getDailySummary(@RequestParam Long parcelId) {
        List<SensorDTO> summary = sS.getDailySummary(parcelId);
        return new ResponseEntity<>(summary, HttpStatus.OK);
    }

    @GetMapping("/battery-low/{threshold}")
    public List<SensorDTO> getLowBatterySensors(@PathVariable("threshold") double threshold) {
        return sS.findByBatteryLevelLessThan(threshold).stream()
                .map(x -> new ModelMapper().map(x, SensorDTO.class))
                .collect(Collectors.toList());
    }


}

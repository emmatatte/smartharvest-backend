package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.SensorIotDTO;
import pe.edu.upc.smartharvest.entities.SensorIot;
import pe.edu.upc.smartharvest.servicesinterfaces.ISensorIotService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sensorIot")
public class SensorIotController {
    @Autowired
    private ISensorIotService sS;

    public SensorIotController() {
    }

    @GetMapping
    public List<SensorIotDTO> listar() {
        return sS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();;
            return m.map(x,SensorIotDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody SensorIotDTO sDTO) {
        ModelMapper m = new ModelMapper();
        SensorIot s = m.map(sDTO, SensorIot.class);
        sS.insert(s);
    }

    @PutMapping
    public void modificar(@RequestBody SensorIotDTO sDTO) {
        ModelMapper m = new ModelMapper();
        SensorIot s = m.map(sDTO, SensorIot.class);
        sS.update(s);
    }

    @DeleteMapping("/{idSensor}")
    public void eliminar(@PathVariable("idSensor") int idSensor){
        sS.delete(idSensor);
    }
}

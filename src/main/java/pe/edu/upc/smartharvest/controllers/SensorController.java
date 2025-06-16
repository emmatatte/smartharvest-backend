package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.*;
import pe.edu.upc.smartharvest.entities.Sensor;
import pe.edu.upc.smartharvest.servicesinterfaces.ISensorService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/sensors")
//@SecurityRequirement(name = "bearerAuth")
public class SensorController {
    @Autowired
    private ISensorService sS;

    public SensorController() {
    }

    @GetMapping
    //@PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<SensorDTO> listar() {
        return sS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SensorDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    //@PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void registrar(@RequestBody SensorDTOforRegister sDTO) {
        ModelMapper m = new ModelMapper();
        Sensor s = m.map(sDTO, Sensor.class);
        sS.insert(s);
    }

    @PutMapping
    //@PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void modificar(@RequestBody SensorDTOforRegister sDTO) {
        ModelMapper m = new ModelMapper();
        Sensor s = m.map(sDTO, Sensor.class);
        sS.update(s);
    }

    @DeleteMapping("/{idSensor}")
    //@PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void eliminar(@PathVariable int idSensor) {
        sS.delete(idSensor);
    }

    @GetMapping("/ListByID/{idSensor}")
    //@PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public SensorDTO listarId(@PathVariable("idSensor") int idSensor) {
        ModelMapper m = new ModelMapper();
        SensorDTO dto = m.map(sS.listId(idSensor), SensorDTO.class);
        return dto;
    }

    @GetMapping("/daily-summary")
    //@PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public ResponseEntity<List<SensorDTO>> getDailySummary() {
        List<SensorDTO> summary = sS.getDailySummary();
        return new ResponseEntity<>(summary, HttpStatus.OK);
    }

    @GetMapping("/battery-low/{threshold}")
    //@PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<SensorDTO> getLowBatterySensors(@PathVariable("threshold") double threshold) {
        return sS.findByBatteryLevelLessThan(threshold).stream()
                .map(x -> new ModelMapper().map(x, SensorDTO.class))
                .collect(Collectors.toList());
    }
    @GetMapping("/findSensorsWithMaintenance")
    //@PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<FindActiveSensorsDTO> findSensorsWithMaintenance() {
        List<FindActiveSensorsDTO> dtoList = new ArrayList<>();
        List<String[]> RowList=sS.findSensorsWithMaintenance();
        for(String[] column:RowList){
            FindActiveSensorsDTO dto = new FindActiveSensorsDTO();
            dto.setIdSensor(Integer.parseInt(column[0]));
            dto.setName(column[1]);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @GetMapping("/FindActiveSensors")
    //@PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<FindActiveSensorsDTO> FindActiveSensors(){
        List<FindActiveSensorsDTO> dtoList = new ArrayList<>();
        List<String[]> RowList=sS.FindActiveSensors();
        for(String[] column:RowList){
            FindActiveSensorsDTO dto = new FindActiveSensorsDTO();
            dto.setIdSensor(Integer.parseInt(column[0]));
            dto.setName(column[1]);
            dtoList.add(dto);
        }
        return dtoList;
    }

}

package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.MaintenanceDTO;
import pe.edu.upc.smartharvest.entities.Maintenance;
import pe.edu.upc.smartharvest.servicesinterfaces.IMaintenanceService;

import java.util.List;
import java.util.stream.Collectors;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/maintenances")
public class MaintenanceController {
    @Autowired
    private IMaintenanceService mS;

    public MaintenanceController() {
    }

    @GetMapping
    public List<MaintenanceDTO> listar(){
        return mS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MaintenanceDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody MaintenanceDTO mDTO) {
        ModelMapper m = new ModelMapper();
        Maintenance ma = m.map(mDTO, Maintenance.class);
        mS.insert(ma);
    }

    @PutMapping
    public void modificar(@RequestBody MaintenanceDTO mDTO) {
        ModelMapper m = new ModelMapper();
        Maintenance ma = m.map(mDTO, Maintenance.class);
        mS.update(ma);
    }

    @DeleteMapping("/{idMantenimiento}")
    public void eliminiar(@PathVariable int idMantenimiento) {
        mS.delete(idMantenimiento);
    }

    @GetMapping("/by-sensor/{sensorId}") // US28 - El usuario puede consultar el historial de mantenimiento de un sensor específico.
    public List<MaintenanceDTO> getBySensor(@PathVariable("sensorId") int sensorId) {
        return mS.findBySensorId(sensorId).stream()
                .map(x -> new ModelMapper().map(x, MaintenanceDTO.class))
                .collect(Collectors.toList());
    }


}

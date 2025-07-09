package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.*;
import pe.edu.upc.smartharvest.entities.Maintenance;
import pe.edu.upc.smartharvest.servicesinterfaces.IMaintenanceService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/maintenances")
@SecurityRequirement(name = "bearerAuth")
public class MaintenanceController {
    @Autowired
    private IMaintenanceService mS;

    public MaintenanceController() {
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<MaintenanceDTO> listar(){
        return mS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MaintenanceDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void registrar(@RequestBody MaintenanceDTOforRegister mDTO) {
        ModelMapper m = new ModelMapper();
        Maintenance ma = m.map(mDTO, Maintenance.class);
        mS.insert(ma);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void modificar(@RequestBody MaintenanceDTOforRegister mDTO) {
        ModelMapper m = new ModelMapper();
        Maintenance ma = m.map(mDTO, Maintenance.class);
        mS.update(ma);
    }

    @DeleteMapping("/{idMantenimiento}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void eliminiar(@PathVariable int idMantenimiento) {
        mS.delete(idMantenimiento);
    }

    @GetMapping("/by-sensor/{sensorId}")
    public List<MaintenanceDTO> getBySensor(@PathVariable("sensorId") int sensorId) {
        return mS.findBySensorId(sensorId).stream()
                .map(x -> new ModelMapper().map(x, MaintenanceDTO.class))
                .collect(Collectors.toList());
    }

    //REPORTE1
    @GetMapping("/top-cultivos-mantenimientos")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<TopCropsByMaintenanceDTO> getTopCropsByMaintenance() {
        List<TopCropsByMaintenanceDTO> dtoList = new ArrayList<>();
        List<String[]> RowList = mS.findTopCropsByMaintenanceCount();
        for (String[] column : RowList) {
            TopCropsByMaintenanceDTO dto = new TopCropsByMaintenanceDTO();
            dto.setType_crop(column[0]);
            dto.setQuant_maintenance(Integer.parseInt(column[1]));
            dtoList.add(dto);
        }
        return dtoList;
    }
    @GetMapping("/{idMaintenance}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public MaintenanceDTO listId(@PathVariable("idMaintenance") int idMaintenance) {
        ModelMapper m = new ModelMapper();
        MaintenanceDTO dto = m.map(mS.listId(idMaintenance), MaintenanceDTO.class);
        return dto;
    }

    @GetMapping("/listarporiduser/{idUser}")
    @PreAuthorize("hasAuthority('AGRICULTOR')")
    public List<MaintenanceDTO> listbyiduser(@PathVariable("idUser") Long idUser) {
        return mS.findMaintenancesBySensor_Parcel_Users_Id(idUser).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, MaintenanceDTO.class);
        }).collect(Collectors.toList());
    }
}

package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.ParcelDTO;
import pe.edu.upc.smartharvest.dtos.ParcelDTOforRegister;
import pe.edu.upc.smartharvest.entities.Parcel;
import pe.edu.upc.smartharvest.servicesinterfaces.IParcelService;

import java.util.List;
import java.util.stream.Collectors;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
@RestController
@RequestMapping("/parcels")
@SecurityRequirement(name = "bearerAuth")
public class ParcelController {
    @Autowired
    private IParcelService pS;

    public ParcelController() {
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<ParcelDTO> listar() {
        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ParcelDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void registrar(@RequestBody ParcelDTOforRegister pDTO) {
        ModelMapper m = new ModelMapper();
        Parcel p = m.map(pDTO, Parcel.class);
        pS.insert(p);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void modificar(@RequestBody ParcelDTOforRegister pDTO) {
        ModelMapper m = new ModelMapper();
        Parcel p = m.map(pDTO, Parcel.class);
        pS.update(p);
    }

    @DeleteMapping("/{idParcela}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void eliminar(@PathVariable int idParcela) {
        pS.delete(idParcela);
    }

    @GetMapping("/by-user/{userId}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<ParcelDTO> getParcelsByUser(@PathVariable("userId") Long userId) {
        return pS.findByUserId(userId).stream()
                .map(x -> new ModelMapper().map(x, ParcelDTO.class))
                .collect(Collectors.toList());
    }
}

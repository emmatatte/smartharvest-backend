package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.InputDTO;
import pe.edu.upc.smartharvest.entities.Input;
import pe.edu.upc.smartharvest.entities.Parcel;
import pe.edu.upc.smartharvest.servicesinterfaces.IInputService;

import java.util.List;
import java.util.stream.Collectors;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/inputs")
@SecurityRequirement(name = "bearerAuth")
public class InputController {
    @Autowired
    private IInputService iS;

    public InputController() {
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<InputDTO> listar() {
        return iS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, InputDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void register(@RequestBody InputDTO inputDTO) {
        ModelMapper m = new ModelMapper();
        Input input = m.map(inputDTO, Input.class);
        iS.insert(input);
    }


    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void update(@RequestBody InputDTO inputDTO) {
        ModelMapper m = new ModelMapper();
        Input input = m.map(inputDTO, Input.class);
        iS.insert(input);
    }


    @DeleteMapping("/{idInsumo}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void eliminar(@PathVariable int idInsumo) {
        iS.delete(idInsumo);
    }
}

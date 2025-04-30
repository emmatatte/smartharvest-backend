package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.InputDTO;
import pe.edu.upc.smartharvest.entities.Input;
import pe.edu.upc.smartharvest.servicesinterfaces.IInputService;

import java.util.List;
import java.util.stream.Collectors;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/inputs")
public class InputController {
    @Autowired
    private IInputService iS;

    public InputController() {
    }

    @GetMapping
    public List<InputDTO> listar() {
        return iS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, InputDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody InputDTO iDTO) {
        ModelMapper m = new ModelMapper();
        Input i = m.map(iDTO, Input.class);
        iS.insert(i);
    }

    @PutMapping
    public void modificar(@RequestBody InputDTO iDTO) {
        ModelMapper m = new ModelMapper();
        Input i = m.map(iDTO, Input.class);
        iS.update(i);
    }

    @DeleteMapping("/{idInsumo}")
    public void eliminar(@PathVariable int idInsumo) {
        iS.delete(idInsumo);
    }

}

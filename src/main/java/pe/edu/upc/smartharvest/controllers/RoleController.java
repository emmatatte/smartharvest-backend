package pe.edu.upc.smartharvest.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.RoleDTO;
import pe.edu.upc.smartharvest.entities.Role;
import pe.edu.upc.smartharvest.servicesinterfaces.IRoleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
@SecurityRequirement(name = "bearerAuth")
public class RoleController {
    @Autowired
    private IRoleService rS;

    public RoleController() {
    }

    @GetMapping
    public List<RoleDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RoleDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody RoleDTO rDTO) {
        ModelMapper m = new ModelMapper();
        Role r = m.map(rDTO, Role.class);
        rS.insert(r);
    }

    @PutMapping
    public void modificar(@RequestBody RoleDTO rDTO) {
        ModelMapper m = new ModelMapper();
        Role r = m.map(rDTO, Role.class);
        rS.update(r);
    }

    @DeleteMapping("/{idSensor}")
    public void eliminar(@PathVariable int idRol) {
        rS.delete(idRol);
    }
}

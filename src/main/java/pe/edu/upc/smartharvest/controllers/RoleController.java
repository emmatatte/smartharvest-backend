package pe.edu.upc.smartharvest.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.ParcelDTO;
import pe.edu.upc.smartharvest.dtos.RoleDTO;
import pe.edu.upc.smartharvest.dtos.RoleDTOforRegister;
import pe.edu.upc.smartharvest.dtos.UsersDTO;
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
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<RoleDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            RoleDTO dto = m.map(x, RoleDTO.class);
            if (x.getUser() != null) {
                dto.setUsers(m.map(x.getUser(), UsersDTO.class));
            }
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody RoleDTOforRegister rDTO) {
        ModelMapper m = new ModelMapper();
        Role r = m.map(rDTO, Role.class);
        rS.insert(r);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody RoleDTOforRegister rDTO) {
        ModelMapper m = new ModelMapper();
        Role r = m.map(rDTO, Role.class);
        rS.update(r);
    }

    @DeleteMapping("/{idRol}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable int idRol) {
        rS.delete(idRol);
    }

    @GetMapping("/{idRole}")
    public RoleDTOforRegister listarId(@PathVariable("idRole") int idRole) {
        ModelMapper m = new ModelMapper();
        RoleDTOforRegister dto = m.map(rS.listId(idRole), RoleDTOforRegister.class);
        return dto;
    }
}

package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.RolDTO;
import pe.edu.upc.smartharvest.entities.Rol;
import pe.edu.upc.smartharvest.servicesinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping({"/roles"})
public class RolController {
    @Autowired
    private IRolService rS;

    public RolController() {
    }

    @GetMapping
    public List<RolDTO> listar() {
        return rS.list().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x,RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody RolDTO rDTO) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(rDTO,Rol.class);
        rS.insert(r);
    }

    @PutMapping
    public void modificar(@RequestBody RolDTO rDTO) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(rDTO,Rol.class);
        rS.update(r);
    }

    @DeleteMapping("/{idRol}")
    public void eliminar(@PathVariable("idRol") int idRol) {
        rS.delete(idRol);
    }
}

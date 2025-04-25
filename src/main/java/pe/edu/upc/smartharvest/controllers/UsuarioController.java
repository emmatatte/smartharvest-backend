package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.UsuarioDTO;
import pe.edu.upc.smartharvest.entities.Usuario;
import pe.edu.upc.smartharvest.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService uS;

    public UsuarioController() {
    }

    @GetMapping
    public List<UsuarioDTO> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody UsuarioDTO uDTO) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(uDTO, Usuario.class);
        uS.insert(u);
    }

    @PutMapping
    public void modificar(@RequestBody UsuarioDTO uDTO) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(uDTO, Usuario.class);
        uS.update(u);
    }

    @DeleteMapping("/{idUsuario}")
    public void eliminar(@PathVariable int idUsuario) {
        uS.delete(idUsuario);
    }
}

package pe.edu.upc.smartharvest.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.UsersDTO;
import pe.edu.upc.smartharvest.entities.Users;
import pe.edu.upc.smartharvest.servicesinterfaces.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersControllers {
    @Autowired
    private IUserService uS;

    public UsersControllers() {
    }

    @GetMapping
    private List<UsersDTO> listarusuarios() {
        return uS.list().stream().map(x-> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x,UsersDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody UsersDTO uDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Users user = modelMapper.map(uDTO, Users.class);
        uS.insert(user);
    }

    @PutMapping
    public void modificar(@RequestBody UsersDTO uDTO) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(uDTO, Users.class);
        uS.update(u);
    }

    @DeleteMapping("/{idSensor}")
    public void eliminar(@PathVariable Long idUser) {
        uS.delete(idUser);
    }
}

package pe.edu.upc.smartharvest.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.FindActiveParcelsDTO;
import pe.edu.upc.smartharvest.dtos.GetUsersQuantityDTO;
import pe.edu.upc.smartharvest.dtos.UsersDTO;
import pe.edu.upc.smartharvest.entities.Users;
import pe.edu.upc.smartharvest.servicesinterfaces.IUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersControllers {
    @Autowired
    private IUserService uS;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsersControllers() {
    }

    @GetMapping
    private List<Users> listarusuarios() {
        return uS.list().stream().map(x-> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x,Users.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody UsersDTO uDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Users user = modelMapper.map(uDTO, Users.class);

        // 3. Encriptar contraseña y activar usuario
        user.setPassword(passwordEncoder.encode(uDTO.getPassword()));
        user.setEnabled(true);

        // 4. Guardar usuario (el servicio asigna el rol)
        uS.insert(user, uDTO.getRol());
    }

    @PutMapping
    public void modificar(@RequestBody UsersDTO uDTO) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(uDTO, Users.class);
        uS.update(u);
    }

    @DeleteMapping("/{idSensor}")
    public void eliminar(@PathVariable int idUser) {
        uS.delete(idUser);
    }

    @GetMapping("/getUsersQuantity")
    public List<GetUsersQuantityDTO> getUsersQuantity(){
        List<GetUsersQuantityDTO> dtoList = new ArrayList<>();
        List<String[]> RowList=uS.getUsersQuantity();
        for(String[] column:RowList){
            GetUsersQuantityDTO dto = new GetUsersQuantityDTO();
            dto.setQuantity(Integer.parseInt(column[0]));
            dtoList.add(dto);
        }
        return dtoList;
    }
}

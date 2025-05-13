package pe.edu.upc.smartharvest.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
//@SecurityRequirement(name = "bearerAuth")
public class UsersControllers {
    @Autowired
    private IUserService uS;

    public UsersControllers() {
    }

    @GetMapping
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    private List<UsersDTO> listarusuarios() {
        return uS.list().stream().map(x-> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x,UsersDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public void registrar(@RequestBody UsersDTO uDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Users user = modelMapper.map(uDTO, Users.class);
        uS.insert(user);
    }

    @PutMapping
    //@PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR','DUEÑO_DE_MERCADO')")
    public void modificar(@RequestBody UsersDTO uDTO) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(uDTO, Users.class);
        uS.update(u);
    }

    @DeleteMapping("/{idUser}")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public void eliminar(@PathVariable Long idUser) {
        uS.delete(idUser);
    }

    @GetMapping("/getUsersQuantity")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
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

package pe.edu.upc.smartharvest.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.GetUsersQuantityDTO;
import pe.edu.upc.smartharvest.dtos.RoleDTOforRegister;
import pe.edu.upc.smartharvest.dtos.UsersDTO;
import pe.edu.upc.smartharvest.dtos.UsersDTOforRegister;
import pe.edu.upc.smartharvest.entities.Users;
import pe.edu.upc.smartharvest.servicesinterfaces.IUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@SecurityRequirement(name = "bearerAuth")
public class UsersControllers {
    @Autowired
    private IUserService uS;

    public UsersControllers() {
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<UsersDTO> listarusuarios() {
        return uS.list().stream().map(x-> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x,UsersDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/register")
    public void registrar(@RequestBody UsersDTOforRegister uDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Users user = modelMapper.map(uDTO, Users.class);
        uS.insert(user);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR','DUEÑO_DE_MERCADO')")
    public void modificar(@RequestBody UsersDTOforRegister uDTO) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(uDTO, Users.class);
        uS.update(u);
    }

    @DeleteMapping("/{idUser}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable Long idUser) {
        uS.delete(idUser);
    }

    @GetMapping("/getUsersQuantity")
    @PreAuthorize("hasAuthority('ADMIN')")
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

    @GetMapping("/{idUser}")
    public UsersDTOforRegister listarId(@PathVariable("idUser") long idUser) {
        ModelMapper m = new ModelMapper();
        UsersDTOforRegister dto = m.map(uS.listId(idUser), UsersDTOforRegister.class);
        return dto;
    }

    @GetMapping("/getIdByUsername/{username}")
    public Long getIdbyUsername(@PathVariable("username") String username) {
        ModelMapper m = new ModelMapper();
        UsersDTOforRegister dto = m.map(uS.findbyUsername(username), UsersDTOforRegister.class);
        Long id = dto.getId();
        return id;
    }

    @GetMapping("/existsbyUsername/{username}")
    public boolean existsbyUsername(@PathVariable("username") String username) {
        return uS.existsByUsername(username);
    }
}
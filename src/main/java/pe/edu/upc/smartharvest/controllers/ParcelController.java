package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.ParcelDTO;
import pe.edu.upc.smartharvest.entities.Parcel;
import pe.edu.upc.smartharvest.servicesinterfaces.IParcelService;

import java.util.List;
import java.util.stream.Collectors;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/parcels")
public class ParcelController {
    @Autowired
    private IParcelService pS;

    public ParcelController() {
    }

    @GetMapping
    public List<ParcelDTO> listar() {
        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ParcelDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody ParcelDTO pDTO) {
        ModelMapper m = new ModelMapper();
        Parcel p = m.map(pDTO, Parcel.class);
        pS.insert(p);
    }

    @PutMapping
    public void modificar(@RequestBody ParcelDTO pDTO) {
        ModelMapper m = new ModelMapper();
        Parcel p = m.map(pDTO, Parcel.class);
        pS.update(p);
    }

    @DeleteMapping("/{idParcela}")
    public void eliminar(@PathVariable int idParcela) {
        pS.delete(idParcela);
    }

    @GetMapping("/by-user/{userId}")
    public List<ParcelDTO> getParcelsByUser(@PathVariable("userId") Integer userId) {
        return pS.findByUserId(userId).stream()
                .map(x -> new ModelMapper().map(x, ParcelDTO.class))
                .collect(Collectors.toList());
    }

}

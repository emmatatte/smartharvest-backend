package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.InputDTO;
import pe.edu.upc.smartharvest.entities.Input;
import pe.edu.upc.smartharvest.entities.Parcel;
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
    public void register(@RequestBody InputDTO inputDTO) {
        ModelMapper m = new ModelMapper();
        Input input = m.map(inputDTO, Input.class);
        Parcel p = new Parcel();
        p.setIdParcel(inputDTO.getParcelId());
        input.setParcel(p);
        iS.insert(input);
    }


    @PutMapping
    public void update(@RequestBody InputDTO inputDTO) {
        ModelMapper m = new ModelMapper();
        Input input = m.map(inputDTO, Input.class);
        Parcel p = new Parcel();
        p.setIdParcel(inputDTO.getParcelId());
        input.setParcel(p);
        iS.update(input);
    }


    @DeleteMapping("/{idInsumo}")
    public void eliminar(@PathVariable int idInsumo) {
        iS.delete(idInsumo);
    }

    @GetMapping("/by-parcel/{parcelId}") // US11 - El usuario puede ver todos los insumos utilizados en una parcela específica.
    public List<InputDTO> getByParcel(@PathVariable("parcelId") int parcelId) {
        return iS.findByParcelId(parcelId).stream()
                .map(x -> new ModelMapper().map(x, InputDTO.class))
                .collect(Collectors.toList());
    }
}

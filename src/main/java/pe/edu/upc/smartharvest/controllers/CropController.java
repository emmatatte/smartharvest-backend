package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.CropDTO;
import pe.edu.upc.smartharvest.entities.Crop;
import pe.edu.upc.smartharvest.servicesinterfaces.ICropService;

import java.util.List;
import java.util.stream.Collectors;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/crops")
public class CropController {
    @Autowired
    private ICropService cS;

    public CropController() {
    }

    @GetMapping
    public List<CropDTO> listar() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CropDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody CropDTO cDTO) {
        ModelMapper m = new ModelMapper();
        Crop c = m.map(cDTO, Crop.class);
        cS.insert(c);
    }

    @PutMapping
    public void modificar(@RequestBody CropDTO cDTO) {
        ModelMapper m = new ModelMapper();
        Crop c = m.map(cDTO, Crop.class);
        cS.update(c);
    }

    @DeleteMapping("/{idCultivo}")
    public void eliminar(@PathVariable int idCultivo) {
        cS.delete(idCultivo);
    }
}

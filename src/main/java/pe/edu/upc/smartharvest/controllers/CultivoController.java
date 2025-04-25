package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.CultivoDTO;
import pe.edu.upc.smartharvest.entities.Cultivo;
import pe.edu.upc.smartharvest.servicesinterfaces.ICultivoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cultivos")
public class CultivoController {
    @Autowired
    private ICultivoService cS;

    public CultivoController() {
    }

    @GetMapping
    public List<CultivoDTO> listar() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CultivoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody CultivoDTO cDTO) {
        ModelMapper m = new ModelMapper();
        Cultivo c = m.map(cDTO, Cultivo.class);
        cS.insert(c);
    }

    @PutMapping
    public void modificar(@RequestBody CultivoDTO cDTO) {
        ModelMapper m = new ModelMapper();
        Cultivo c = m.map(cDTO, Cultivo.class);
        cS.update(c);
    }

    @DeleteMapping("/{idCultivo}")
    public void eliminar(@PathVariable int idCultivo) {
        cS.delete(idCultivo);
    }
}

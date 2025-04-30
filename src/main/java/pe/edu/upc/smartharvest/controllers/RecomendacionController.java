package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.RecomendacionDTO;
import pe.edu.upc.smartharvest.entities.Recomendacion;
import pe.edu.upc.smartharvest.servicesinterfaces.IRecomendacionService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/recomendaciones")

public class RecomendacionController {
    @Autowired
    private IRecomendacionService rS;

    public RecomendacionController() {
    }

    @GetMapping
    public List<RecomendacionDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecomendacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void register(@RequestBody RecomendacionDTO rDTO) {
        ModelMapper m = new ModelMapper();
        Recomendacion r = m.map(rDTO, Recomendacion.class);
        rS.insert(r);
    }

    @PutMapping
    public void modificar(@RequestBody Recomendacion rDTO) {
        ModelMapper m = new ModelMapper();
        Recomendacion r = m.map(rDTO, Recomendacion.class);
        rS.update(r);
    }

    @DeleteMapping("/{idRecomendation}")
    public void eliminar(@PathVariable int idRecomendation) {
        rS.delete(idRecomendation);
    }
}

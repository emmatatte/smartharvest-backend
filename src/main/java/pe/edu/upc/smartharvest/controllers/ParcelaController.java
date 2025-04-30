package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.ParcelaDTO;
import pe.edu.upc.smartharvest.entities.Parcela;
import pe.edu.upc.smartharvest.servicesinterfaces.IParcelaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/parcelas")
public class ParcelaController {
    @Autowired
    private IParcelaService pS;

    public ParcelaController() {
    }

    @GetMapping
    public List<ParcelaDTO> listar() {
        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ParcelaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody ParcelaDTO pDTO) {
        ModelMapper m = new ModelMapper();
        Parcela p = m.map(pDTO, Parcela.class);
        pS.insert(p);
    }

    @PutMapping
    public void modificar(@RequestBody ParcelaDTO pDTO) {
        ModelMapper m = new ModelMapper();
        Parcela p = m.map(pDTO, Parcela.class);
        pS.update(p);
    }

    @DeleteMapping("/{idParcela}")
    public void eliminar(@PathVariable int idParcela) {
        pS.delete(idParcela);
    }
}

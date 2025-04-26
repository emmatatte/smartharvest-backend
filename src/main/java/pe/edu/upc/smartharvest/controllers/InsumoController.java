package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.InsumoDTO;
import pe.edu.upc.smartharvest.entities.Insumo;
import pe.edu.upc.smartharvest.servicesinterfaces.IInsumoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/insumos")
public class InsumoController {
    @Autowired
    private IInsumoService iS;

    public InsumoController() {
    }

    @GetMapping
    public List<InsumoDTO> listar() {
        return iS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, InsumoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody InsumoDTO iDTO) {
        ModelMapper m = new ModelMapper();
        Insumo i = m.map(iDTO, Insumo.class);
        iS.insert(i);
    }

    @PutMapping
    public void modificar(@RequestBody InsumoDTO iDTO) {
        ModelMapper m = new ModelMapper();
        Insumo i = m.map(iDTO, Insumo.class);
        iS.update(i);
    }

    @DeleteMapping("/{idInsumo}")
    public void eliminar(@PathVariable int idInsumo) {
        iS.delete(idInsumo);
    }

}

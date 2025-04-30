package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.MantenimientoDTO;
import pe.edu.upc.smartharvest.entities.Mantenimiento;
import pe.edu.upc.smartharvest.servicesinterfaces.IMantenimientoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mantenimiento")
public class MantenimientoController {
    @Autowired
    private IMantenimientoService mS;

    public MantenimientoController() {
    }

    @GetMapping
    public List<MantenimientoDTO> listar(){
        return mS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x,MantenimientoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody MantenimientoDTO mDTO) {
        ModelMapper m = new ModelMapper();
        Mantenimiento ma = m.map(mDTO, Mantenimiento.class);
        mS.insert(ma);
    }

    @PutMapping
    public void modificar(@RequestBody MantenimientoDTO mDTO) {
        ModelMapper m = new ModelMapper();
        Mantenimiento ma = m.map(mDTO, Mantenimiento.class);
        mS.update(ma);
    }

    @DeleteMapping("/{idMantenimiento}")
    public void eliminiar(@PathVariable int idMantenimiento) {
        mS.delete(idMantenimiento);
    }

}

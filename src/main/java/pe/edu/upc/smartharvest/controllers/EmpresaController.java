package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.EmpresaDTO;
import pe.edu.upc.smartharvest.entities.Empresa;
import pe.edu.upc.smartharvest.servicesinterfaces.IEmpresaService;
import pe.edu.upc.smartharvest.servicesinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    @Autowired
    private IEmpresaService eS;

    public EmpresaController() {
    }

    @GetMapping
    public List<EmpresaDTO> listar() {
        return eS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,EmpresaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody EmpresaDTO eDTO) {
        ModelMapper m = new ModelMapper();
        Empresa e = m.map(eDTO,Empresa.class);
        eS.insert(e);
    }

    @PutMapping
    public void modificar(@RequestBody EmpresaDTO eDTO) {
        ModelMapper m = new ModelMapper();
        Empresa e = m.map(eDTO, Empresa.class);
        eS.update(e);
    }

    @DeleteMapping("/{idEmpresa}")
    public void eliminar(@PathVariable int idEmpresa) {
        eS.delete(idEmpresa);
    }
}

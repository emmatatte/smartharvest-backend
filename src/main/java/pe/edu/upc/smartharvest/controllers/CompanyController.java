package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.CompanyDTO;
import pe.edu.upc.smartharvest.entities.Company;
import pe.edu.upc.smartharvest.servicesinterfaces.ICompanyService;

import java.util.List;
import java.util.stream.Collectors;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private ICompanyService eS;

    public CompanyController() {
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<CompanyDTO> listar() {
        return eS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, CompanyDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody CompanyDTO eDTO) {
        ModelMapper m = new ModelMapper();
        Company e = m.map(eDTO, Company.class);
        eS.insert(e);
    }

    @PutMapping
    public void modificar(@RequestBody CompanyDTO eDTO) {
        ModelMapper m = new ModelMapper();
        Company e = m.map(eDTO, Company.class);
        eS.update(e);
    }

    @DeleteMapping("/{idEmpresa}")
    public void eliminar(@PathVariable int idEmpresa) {
        eS.delete(idEmpresa);
    }
}

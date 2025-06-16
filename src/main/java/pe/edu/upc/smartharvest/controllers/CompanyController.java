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

@RestController
@RequestMapping("/companies")
//@SecurityRequirement(name = "bearerAuth")
public class CompanyController {
    @Autowired
    private ICompanyService eS;

    public CompanyController() {
    }

    @GetMapping
    //@PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR','DUEÑO_DE_MERCADO')")
    public List<CompanyDTO> listar() {
        return eS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, CompanyDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody CompanyDTO eDTO) {
        ModelMapper m = new ModelMapper();
        Company e = m.map(eDTO, Company.class);
        eS.insert(e);
    }

    @PutMapping
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody CompanyDTO eDTO) {
        ModelMapper m = new ModelMapper();
        Company e = m.map(eDTO, Company.class);
        eS.update(e);
    }

    @GetMapping("/{idEmpresa}")
    public CompanyDTO listarId(@PathVariable("idEmpresa") int idEmpresa) {
        ModelMapper m = new ModelMapper();
        CompanyDTO dto = m.map(eS.listId(idEmpresa), CompanyDTO.class);
        return dto;
    }

    @DeleteMapping("/{idEmpresa}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("idEmpresa") int idEmpresa) {
        eS.delete(idEmpresa);
    }
}

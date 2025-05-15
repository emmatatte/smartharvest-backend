package pe.edu.upc.smartharvest.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.AgriculturalProductDTO;
import pe.edu.upc.smartharvest.dtos.AgriculturalProductDTOforRegister;
import pe.edu.upc.smartharvest.entities.AgriculturalProduct;
import pe.edu.upc.smartharvest.servicesinterfaces.IAgriculturalProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/agriculturalproducts")
@SecurityRequirement(name = "bearerAuth")
public class AgriculturalProductController {
    @Autowired
    private IAgriculturalProductService aP;

    public AgriculturalProductController() {
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<AgriculturalProductDTO> listar() {
        return aP.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AgriculturalProductDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void register(@RequestBody AgriculturalProductDTOforRegister aDTO) {
        ModelMapper m = new ModelMapper();
        AgriculturalProduct a = m.map(aDTO, AgriculturalProduct.class);
        aP.insert(a);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void modificar(@RequestBody AgriculturalProductDTOforRegister aDTO) {
        ModelMapper m = new ModelMapper();
        AgriculturalProduct pa = m.map(aDTO, AgriculturalProduct.class);
        aP.update(pa);
    }

    @DeleteMapping("/{idProduct}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void eliminar(@PathVariable int idProduct) {
        aP.delete(idProduct);
    }
}

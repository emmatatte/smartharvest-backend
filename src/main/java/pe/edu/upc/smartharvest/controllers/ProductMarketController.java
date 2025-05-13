package pe.edu.upc.smartharvest.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.ProductMarketDTO;
import pe.edu.upc.smartharvest.entities.ProductMarket;
import pe.edu.upc.smartharvest.servicesinterfaces.IProductMarketService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productmarkets")
@SecurityRequirement(name = "bearerAuth")
public class ProductMarketController {
    @Autowired
    private IProductMarketService pmS;

    public ProductMarketController() {
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR','DUEÑO_DE_MERCADO')")
    public List<ProductMarketDTO> listar() {
        return pmS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ProductMarketDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'DUEÑO_DE_MERCADO')")
    public void register(@RequestBody ProductMarketDTO pmDTO) {
        ModelMapper m = new ModelMapper();
        ProductMarket pm = m.map(pmDTO, ProductMarket.class);
        pmS.insert(pm);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'DUEÑO_DE_MERCADO')")
    public void modificar(@RequestBody ProductMarketDTO pmDTO) {
        ModelMapper m = new ModelMapper();
        ProductMarket pm = m.map(pmDTO, ProductMarket.class);
        pmS.update(pm);
    }

    @DeleteMapping("/{idProductMarket}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'DUEÑO_DE_MERCADO')")
    public void eliminar(@PathVariable int idProductMarket) {
        pmS.delete(idProductMarket);
    }

    @GetMapping("/ranking-mercados-productos")
    @PreAuthorize("hasAnyAuthority('AGRICULTOR')")
    public ResponseEntity<List<String[]>> getTopMarketsByProductCount() {
        return ResponseEntity.ok(pmS.findTopMarketsByProductCount());
    }
}

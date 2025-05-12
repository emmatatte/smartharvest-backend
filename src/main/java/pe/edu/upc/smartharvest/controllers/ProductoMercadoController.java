package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.ProductoMercadoDTO;
import pe.edu.upc.smartharvest.entities.ProductoMercado;
import pe.edu.upc.smartharvest.servicesinterfaces.IProductoMercadoService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/productosmercados")

public class ProductoMercadoController {
    @Autowired
    private IProductoMercadoService pmS;

    public ProductoMercadoController() {
    }

    @GetMapping
    public List<ProductoMercadoDTO> listar() {
        return pmS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ProductoMercadoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void register(@RequestBody ProductoMercadoDTO pmDTO) {
        ModelMapper m = new ModelMapper();
        ProductoMercado pm = m.map(pmDTO, ProductoMercado.class);
        pmS.insert(pm);
    }

    @PutMapping
    public void modificar(@RequestBody ProductoMercado pmDTO) {
        ModelMapper m = new ModelMapper();
        ProductoMercado pm = m.map(pmDTO, ProductoMercado.class);
        pmS.update(pm);
    }

    @DeleteMapping("/{idMarketProduct}")
    public void eliminar(@PathVariable int idMarketProduct) {
        pmS.delete(idMarketProduct);
    }
}

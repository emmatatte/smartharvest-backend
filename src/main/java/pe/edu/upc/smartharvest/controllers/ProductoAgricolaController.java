package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.ProductoAgricolaDTO;
import pe.edu.upc.smartharvest.entities.ProductoAgricola;
import pe.edu.upc.smartharvest.servicesinterfaces.IProductoAgricolaService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/productosagricolas")

public class ProductoAgricolaController {
    @Autowired
    private IProductoAgricolaService paS;

    public ProductoAgricolaController() {
    }

    @GetMapping
    public List<ProductoAgricolaDTO> listar() {
        return paS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ProductoAgricolaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void register(@RequestBody ProductoAgricolaDTO paDTO) {
        ModelMapper m = new ModelMapper();
        ProductoAgricola pa = m.map(paDTO, ProductoAgricola.class);
        paS.insert(pa);
    }

    @PutMapping
    public void modificar(@RequestBody ProductoAgricola paDTO) {
        ModelMapper m = new ModelMapper();
        ProductoAgricola pa = m.map(paDTO, ProductoAgricola.class);
        paS.update(pa);
    }

    @DeleteMapping("/{idProduct}")
    public void eliminar(@PathVariable int idProduct) {
        paS.delete(idProduct);
    }
}

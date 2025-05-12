package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.ProductoAgricola;
import pe.edu.upc.smartharvest.repositories.IProductoAgricolaRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IProductoAgricolaService;

import java.util.List;

@Service
public class ProductoAgricolaServiceImplement implements IProductoAgricolaService{
    @Autowired
    private IProductoAgricolaRepository paR;

    @Override
    public List<ProductoAgricola> list() {return paR.findAll();}

    @Override
    public void insert(ProductoAgricola pa) {paR.save(pa);}

    @Override
    public void update(ProductoAgricola pa) {paR.save(pa);}

    @Override
    public void delete(int idProduct) {paR.deleteById(idProduct);}
}

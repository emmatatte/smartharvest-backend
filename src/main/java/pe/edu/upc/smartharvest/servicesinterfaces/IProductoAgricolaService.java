package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.ProductoAgricola;

import java.util.List;

public interface IProductoAgricolaService {
    List<ProductoAgricola> list();
    void insert(ProductoAgricola pa);
    void update(ProductoAgricola pa);
    void delete(int idProduct);
}

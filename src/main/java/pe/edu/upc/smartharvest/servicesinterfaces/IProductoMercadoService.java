package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.ProductoMercado;

import java.util.List;

public interface IProductoMercadoService {
    List<ProductoMercado> list();
    void insert(ProductoMercado pm);
    void update(ProductoMercado pm);
    void delete(int idMarketProduct);
}

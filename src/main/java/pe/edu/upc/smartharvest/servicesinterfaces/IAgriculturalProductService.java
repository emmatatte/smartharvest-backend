package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.AgriculturalProduct;

import java.util.List;

public interface IAgriculturalProductService {
    List<AgriculturalProduct> list();
    void insert(AgriculturalProduct agriculturalProduct);
    void update(AgriculturalProduct agriculturalProduct);
    void delete(int idAgriculturalProduct);
}

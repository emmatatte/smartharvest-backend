package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.AgriculturalProduct;
import pe.edu.upc.smartharvest.entities.Crop;

import java.util.List;

public interface IAgriculturalProductService {
    List<AgriculturalProduct> list();
    void insert(AgriculturalProduct agriculturalProduct);
    void update(AgriculturalProduct agriculturalProduct);
    void delete(int idAgriculturalProduct);
    AgriculturalProduct listId(int idAgriculturalProduct);
}

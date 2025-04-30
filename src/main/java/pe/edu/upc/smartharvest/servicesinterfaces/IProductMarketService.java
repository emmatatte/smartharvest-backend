package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Notification;
import pe.edu.upc.smartharvest.entities.ProductMarket;

import java.util.List;

public interface IProductMarketService {
    List<ProductMarket> list();
    void insert(ProductMarket productMarket);
    void update(ProductMarket productMarket);
    void delete(int idProductMarket);
}

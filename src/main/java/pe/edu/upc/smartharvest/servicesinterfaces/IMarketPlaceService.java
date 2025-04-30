package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.LocalMarket;

import java.util.List;

public interface IMarketPlaceService {
    List<LocalMarket> list();
    void insert(LocalMarket m);
    void update(LocalMarket m);
    void delete(int idLocalMarket);
}

package pe.edu.upc.smartharvest.servicesinterfaces;

import org.springframework.cglib.core.Local;
import pe.edu.upc.smartharvest.entities.Company;
import pe.edu.upc.smartharvest.entities.LocalMarket;

import java.util.List;

public interface IMarketPlaceService {
    List<LocalMarket> list();
    void insert(LocalMarket m);
    void update(LocalMarket m);
    void delete(int idLocalMarket);
    List<LocalMarket> findByLocation(String location);
    public LocalMarket listId(int idLocalMarket);
}

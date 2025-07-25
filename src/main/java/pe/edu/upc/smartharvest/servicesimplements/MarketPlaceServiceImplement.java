package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.LocalMarket;
import pe.edu.upc.smartharvest.repositories.ILocalMarketRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IMarketPlaceService;

import java.util.List;

@Service
public class MarketPlaceServiceImplement implements IMarketPlaceService {
    @Autowired
    private ILocalMarketRepository mR;

    @Override
    public List<LocalMarket> list() {return mR.findAll();}

    @Override
    public void insert(LocalMarket m) {
        mR.save(m);
    }

    @Override
    public void update(LocalMarket m) { mR.save(m);}

    @Override
    public void delete(int idMercadoLocal) {mR.deleteById(idMercadoLocal);};

    @Override
    public List<LocalMarket> findByLocation(String location) {
        return mR.findByLocationContainingIgnoreCase(location);
    }

    @Override
    public LocalMarket listId(int idLocalMarket) {
        return mR.findById(idLocalMarket).orElse(new LocalMarket());
    }

    @Override
    public List<LocalMarket> findLocalMarketsByUsers_Id(Long usersId) {
        return mR.findLocalMarketsByUsers_Id(usersId);
    }

}

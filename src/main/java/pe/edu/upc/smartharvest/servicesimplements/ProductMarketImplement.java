package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.ProductMarket;
import pe.edu.upc.smartharvest.repositories.IProductMarketRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IProductMarketService;

import java.util.List;
@Service
public class ProductMarketImplement implements IProductMarketService {
    @Autowired
    private IProductMarketRepository pM;

    @Override
    public List<ProductMarket> list() {
        return pM.findAll();
    }

    @Override
    public void insert(ProductMarket productMarket) {
        pM.save(productMarket);
    }

    @Override
    public void update(ProductMarket productMarket) {
        pM.save(productMarket);
    }

    @Override
    public void delete(int idProductMarket) {
        pM.deleteById(idProductMarket);
    }
}

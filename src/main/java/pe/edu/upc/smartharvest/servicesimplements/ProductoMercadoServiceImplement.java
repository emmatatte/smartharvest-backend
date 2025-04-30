package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.ProductoMercado;
import pe.edu.upc.smartharvest.repositories.IProductoMercadoRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IProductoMercadoService;

import java.util.List;

@Service
public class ProductoMercadoServiceImplement implements IProductoMercadoService {
    @Autowired
    private IProductoMercadoRepository pmR;

    @Override
    public List<ProductoMercado> list() {return pmR.findAll();}

    @Override
    public void insert(ProductoMercado pm) {pmR.save(pm);}

    @Override
    public void update(ProductoMercado pm) {pmR.save(pm);}

    @Override
    public void delete(int idMarketProduct) {pmR.deleteById(idMarketProduct);}

}

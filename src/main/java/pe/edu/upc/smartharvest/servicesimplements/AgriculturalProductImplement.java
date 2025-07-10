package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.AgriculturalProduct;
import pe.edu.upc.smartharvest.entities.ProductMarket;
import pe.edu.upc.smartharvest.repositories.IAgriculturalProductRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IAgriculturalProductService;
import pe.edu.upc.smartharvest.servicesinterfaces.IProductMarketService;

import java.util.List;

@Service
public class AgriculturalProductImplement implements IAgriculturalProductService {
    @Autowired
    private IAgriculturalProductRepository aP;


    @Override
    public List<AgriculturalProduct> list() {
        return aP.findAll();
    }

    @Override
    public void insert(AgriculturalProduct agriculturalProduct) {
        aP.save(agriculturalProduct);
    }

    @Override
    public void update(AgriculturalProduct agriculturalProduct) {
        aP.save(agriculturalProduct);
    }

    @Override
    public void delete(int idAgriculturalProduct) {
        aP.deleteById(idAgriculturalProduct);
    }

    @Override
    public AgriculturalProduct listId(int idAgriculturalProduct) {
        return aP.findById(idAgriculturalProduct).orElse(new AgriculturalProduct());
    }

    @Override
    public List<AgriculturalProduct> findAgriculturalProductsByCrop_Parcel_Users_Id(Long cropParcelUsersId) {
        return aP.findAgriculturalProductsByCrop_Parcel_Users_Id(cropParcelUsersId);
    }
}

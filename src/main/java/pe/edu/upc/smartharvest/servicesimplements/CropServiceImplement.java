package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Crop;
import pe.edu.upc.smartharvest.repositories.ICropRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.ICropService;

import java.util.List;

@Service
public class CropServiceImplement implements ICropService {
    @Autowired
    private ICropRepository cR;

    @Override
    public List<Crop> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Crop cultivo) {
        cR.save(cultivo);
    }

    @Override
    public void update(Crop cultivo) {
        cR.save(cultivo);
    }

    @Override
    public void delete(int idCultivo) {
        cR.deleteById(idCultivo);
    }
    @Override
    public List<Crop> findByTypeCrop(String typeCrop) {
        return cR.findByTypeCrop(typeCrop);
    }

    @Override
    public List<Crop> findByActualState(String actualState) {
        return cR.findByActualState(actualState);
    }

}

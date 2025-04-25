package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Cultivo;
import pe.edu.upc.smartharvest.repositories.ICultivoRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.ICultivoService;

import java.util.List;

@Service
public class CultivoServiceImplement implements ICultivoService {
    @Autowired
    private ICultivoRepository cR;

    @Override
    public List<Cultivo> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Cultivo cultivo) {
        cR.save(cultivo);
    }

    @Override
    public void update(Cultivo cultivo) {
        cR.save(cultivo);
    }

    @Override
    public void delete(int idCultivo) {
        cR.deleteById(idCultivo);
    }
}

package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Insumo;
import pe.edu.upc.smartharvest.repositories.IInsumoRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IInsumoService;

import java.util.List;

@Service
public class InsumoServiceImplement implements IInsumoService {
    @Autowired
    private IInsumoRepository iR;

    @Override
    public List<Insumo> list() {
        return iR.findAll();
    }

    @Override
    public void insert(Insumo insumo) {
        iR.save(insumo);
    }

    @Override
    public void update(Insumo insumo) {
        iR.save(insumo);
    }

    @Override
    public void delete(int idInsumo) {
        iR.deleteById(idInsumo);
    }
}

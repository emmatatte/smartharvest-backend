package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Parcela;
import pe.edu.upc.smartharvest.repositories.IParcelaRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IParcelaService;

import java.util.List;

@Service
public class ParcelaServiceImplement implements IParcelaService {
    @Autowired
    private IParcelaRepository pR;

    @Override
    public List<Parcela> list() {
        return pR.findAll();
    }

    @Override
    public void insert(Parcela parcela) {
        pR.save(parcela);
    }

    @Override
    public void update(Parcela parcela) {
        pR.save(parcela);
    }

    @Override
    public void delete(int idParcela) {
        pR.deleteById(idParcela);
    }
}

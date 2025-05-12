package pe.edu.upc.smartharvest.servicesimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Recomendacion;
import pe.edu.upc.smartharvest.repositories.IRecomendacionRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IRecomendacionService;

import java.util.List;

@Service
public class RecomendacionServiceImplement implements IRecomendacionService {
    @Autowired
    private IRecomendacionRepository rR;

    @Override
    public List<Recomendacion> list() {return rR.findAll();}

    @Override
    public void insert(Recomendacion r) {rR.save(r);}

    @Override
    public void update(Recomendacion r) {rR.save(r);}

    @Override
    public void delete(int idRecomendation) {rR.deleteById(idRecomendation);}
}

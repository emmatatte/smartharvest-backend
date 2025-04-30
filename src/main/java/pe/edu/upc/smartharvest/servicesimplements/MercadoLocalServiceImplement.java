package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.MercadoLocal;
import pe.edu.upc.smartharvest.repositories.IMercadoLocalRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IMercadoLocalService;

import java.util.List;

@Service
public class MercadoLocalServiceImplement implements IMercadoLocalService {
    @Autowired
    private IMercadoLocalRepository mR;

    @Override
    public List<MercadoLocal> list() {return mR.findAll();}

    @Override
    public void insert(MercadoLocal m) {
        mR.save(m);
    }

    @Override
    public void update(MercadoLocal m) { mR.save(m);}

    @Override
    public void delete(int idMercadoLocal) {mR.deleteById(idMercadoLocal);};
}

package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Rol;
import pe.edu.upc.smartharvest.repositories.IRolRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IRolService;

import java.util.List;

@Service
public class RolServiceImplement implements IRolService {
    @Autowired
    private IRolRepository rR;

    @Override
    public List<Rol> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Rol r) {
        rR.save(r);
    }

    @Override
    public void update(Rol r) {
        rR.save(r);
    }

    @Override
    public void delete(int idrol) {
        rR.deleteById(idrol);
    }
}

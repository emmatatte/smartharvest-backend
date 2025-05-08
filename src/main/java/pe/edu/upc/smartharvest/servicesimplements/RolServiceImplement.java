package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Role;
import pe.edu.upc.smartharvest.repositories.IRoleRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IRoleService;

import java.util.List;
@Service
public class RolServiceImplement implements IRoleService {
    @Autowired
    private IRoleRepository rR;

    @Override
    public List<Role> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Role role) {
        rR.save(role);
    }

    @Override
    public void update(Role role) {
        rR.save(role);
    }

    @Override
    public void delete(int idRole) {
        rR.deleteById(idRole);
    }
}

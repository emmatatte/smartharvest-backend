package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Users;
import pe.edu.upc.smartharvest.repositories.IUserRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IUserService;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository uR;

    @Override
    public List<Users> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Users user) {
        uR.save(user);
    }

    @Override
    public void update(Users user) {
        uR.save(user);
    }

    @Override
    public void delete(int idUser) {
        uR.deleteById(idUser);
    }
}

package pe.edu.upc.smartharvest.servicesinterfaces;

import org.springframework.security.core.userdetails.User;
import pe.edu.upc.smartharvest.entities.Role;
import pe.edu.upc.smartharvest.entities.Users;

import java.util.List;

public interface IUserService {
    List<Users> list();
    void insert(Users user, String rolStr);
    void update(Users user);
    void delete(int idUser);
}

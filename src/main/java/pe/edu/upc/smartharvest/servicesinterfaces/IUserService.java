package pe.edu.upc.smartharvest.servicesinterfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.User;
import pe.edu.upc.smartharvest.entities.Role;
import pe.edu.upc.smartharvest.entities.Users;

import java.util.List;

public interface IUserService {
    List<Users> list();
    void insert(Users user);
    void update(Users user);
    void delete(Long idUser);
    List<String[]> getUsersQuantity();
    public Users listId(long idUser);
}

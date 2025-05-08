package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Role;

import java.util.List;

public interface IRoleService {
    List<Role> list();
    void insert(Role role);
    void update(Role role);
    void delete(int idRole);
}

package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Rol;

import java.util.List;

public interface IRolService {
    List<Rol> list();
    void insert(Rol r);
    void update(Rol r);
    void delete(int idrol);
}

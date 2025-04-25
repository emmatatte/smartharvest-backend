package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> list();
    void insert(Usuario usuario);
    void update(Usuario usuario);
    void delete(int idUsuario);
    
}

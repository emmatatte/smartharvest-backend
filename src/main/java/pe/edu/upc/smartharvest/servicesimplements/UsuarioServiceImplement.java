package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Usuario;
import pe.edu.upc.smartharvest.repositories.IUsuarioRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository uR;

    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public void delete(int idUsuario) {
        uR.deleteById(idUsuario);
    }
}

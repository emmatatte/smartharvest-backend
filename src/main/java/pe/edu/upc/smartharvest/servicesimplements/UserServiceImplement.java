package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Role;
import pe.edu.upc.smartharvest.entities.Users;
import pe.edu.upc.smartharvest.repositories.IRoleRepository;
import pe.edu.upc.smartharvest.repositories.IUsersRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IUserService;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUsersRepository uR;

    @Autowired
    private IRoleRepository iR;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Users> list() {
        return uR.findAll();
    }

    @Override
    public void update(Users user) {
        // Buscar el usuario existente
        Users existingUser = uR.findById(user.getId()).orElse(null);
        if (existingUser == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        // Actualizar solo los campos que quieres cambiar
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        existingUser.setEnabled(user.getEnabled() != null ? user.getEnabled() : true);

        // NO tocar los roles, mantener los existentes
        // existingUser.getRoles() se mantiene igual

        // Guardar
        uR.save(existingUser);
    }

    @Override
    public void delete(Long idUser) {
        uR.deleteById(idUser);
    }

    @Override
    public void insert(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        uR.save(user);
    }
    @Override
    public List<String[]> getUsersQuantity(){
        return uR.getUsersQuantity();
    }

    @Override
    public Users listId(long idUser) {
        return uR.findById(idUser).orElse(new Users());
    }
}

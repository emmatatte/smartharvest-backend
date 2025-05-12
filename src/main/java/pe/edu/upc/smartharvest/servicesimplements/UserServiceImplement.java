package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Role;
import pe.edu.upc.smartharvest.entities.RoleType;
import pe.edu.upc.smartharvest.entities.Users;
import pe.edu.upc.smartharvest.repositories.IRoleRepository;
import pe.edu.upc.smartharvest.repositories.IUserRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IUserService;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository uR;

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
        uR.save(user);
    }

    @Override
    public void delete(int idUser) {
        uR.deleteById(idUser);
    }

    @Override
    public void insert(Users user, String rolStr) {
        // 1. Validar y convertir el String a RoleType
        RoleType rolType;
        try {
            rolType = RoleType.valueOf(rolStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Rol inválido. Usa: " + Arrays.toString(RoleType.values()));
        }

        // 2. Buscar o crear el rol
        Role rol = iR.findByRol(rolType)
                .orElseGet(() -> {
                    Role newRol = new Role();
                    newRol.setRol(rolType); // Asigna el Enum
                    return iR.save(newRol);
                });

        // 3. Asignar rol y guardar
        user.setRole(rol);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        uR.save(user);
    }
}

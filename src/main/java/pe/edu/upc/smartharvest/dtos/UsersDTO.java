package pe.edu.upc.smartharvest.dtos;

import jakarta.persistence.*;
import pe.edu.upc.smartharvest.entities.Role;
import pe.edu.upc.smartharvest.entities.RoleType;

import java.util.List;

public class UsersDTO {
    private Long idUser;
    private String username;
    private String password;
    private String email;
    private String rol;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        if (!RoleType.isValid(rol)) {
            throw new IllegalArgumentException("Rol inválido");
        }
        this.rol = rol.toUpperCase();
    }
}

package pe.edu.upc.smartharvest.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"idUser", "rol"})})
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private RoleType rol;

    @OneToMany(mappedBy = "role")  // Relación inversa
    @JsonIgnore  // Evita el bucle en JSON
    private List<Users> users;  // Lista de usuarios con este rol

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public RoleType getRol() {
        return rol;
    }

    public void setRol(RoleType rol) {
        this.rol = rol;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
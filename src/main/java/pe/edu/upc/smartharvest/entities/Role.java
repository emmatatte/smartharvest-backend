package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"idUser", "rol"})})
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    private String rol;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private Users user;


    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
package pe.edu.upc.smartharvest.dtos;


import pe.edu.upc.smartharvest.entities.Users;

public class RoleDTO {
    private Long idRol;
    private String rol;
    private Users user;

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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}

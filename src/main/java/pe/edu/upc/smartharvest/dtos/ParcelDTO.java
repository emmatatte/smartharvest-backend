package pe.edu.upc.smartharvest.dtos;

import pe.edu.upc.smartharvest.entities.Users;

import java.time.LocalDate;

public class ParcelDTO {
    private int idParcel;
    private String name;
    private String location;
    private double sizem2;
    private String groundType;
    private LocalDate registrationDate;
    private UsersDTO users;

    public int getIdParcel() {
        return idParcel;
    }

    public void setIdParcel(int idParcel) {
        this.idParcel = idParcel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSizem2() {
        return sizem2;
    }

    public void setSizem2(double sizem2) {
        this.sizem2 = sizem2;
    }

    public String getGroundType() {
        return groundType;
    }

    public void setGroundType(String groundType) {
        this.groundType = groundType;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public UsersDTO getUsers() {
        return users;
    }

    public void setUsers(UsersDTO users) {
        this.users = users;
    }
}

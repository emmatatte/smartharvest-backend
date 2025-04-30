package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Parcel")
public class Parcel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idParcel;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "location", nullable = false, length = 200)
    private String location;

    @Column(name = "sizem2")
    private double sizem2;

    @Column(name = "groundType", nullable = false, length = 100)
    private String groundType;

    @Column(name = "registrationDate", nullable = false)
    private LocalDate registrationDate;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Users users;

    public Parcel() {
    }

    public Parcel(int idParcel, String name, String location, double sizem2, String groundType, LocalDate registrationDate, Users users) {
        this.idParcel = idParcel;
        this.name = name;
        this.location = location;
        this.sizem2 = sizem2;
        this.groundType = groundType;
        this.registrationDate = registrationDate;
        this.users = users;
    }

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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}

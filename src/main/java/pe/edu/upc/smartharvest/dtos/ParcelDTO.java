package pe.edu.upc.smartharvest.dtos;

import jakarta.persistence.*;
import pe.edu.upc.smartharvest.entities.Users;

import java.time.LocalDate;

public class ParcelDTO {
    private int idParcel;
    private String name;
    private String location;
    private double sizem2;
    private String groundType;
    private LocalDate registrationDate;
    private Users users;
}

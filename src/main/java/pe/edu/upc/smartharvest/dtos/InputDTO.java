package pe.edu.upc.smartharvest.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.smartharvest.entities.Users;

import java.time.LocalDate;

public class InputDTO {
    private int idInput;
    private String name;
    private String type;
    private int amount;
    private String unit;
    private LocalDate registrationDate;
    private LocalDate expirationDate;
    private Users users;
}

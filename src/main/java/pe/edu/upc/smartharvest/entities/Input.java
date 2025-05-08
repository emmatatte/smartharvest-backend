package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Input")
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInput;

    @Column(name = "name", nullable = false, length = 70)
    private String name;

    @Column(name = "type", nullable = false, length = 70)
    private String type;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "unit", nullable = false, length = 15)
    private String unit;

    @Column(name = "registrationDate", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "expirationDate", nullable = false)
    private LocalDate expirationDate;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Users users;

    public Input() {
    }

    public Input(int idInput, String name, String type, int amount, String unit, LocalDate registrationDate, LocalDate expirationDate, Users users) {
        this.idInput = idInput;
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.unit = unit;
        this.registrationDate = registrationDate;
        this.expirationDate = expirationDate;
        this.users = users;
    }

    public int getIdInput() {
        return idInput;
    }

    public void setIdInput(int idInput) {
        this.idInput = idInput;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}

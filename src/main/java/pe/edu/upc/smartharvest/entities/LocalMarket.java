package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "LocalMarket")
public class LocalMarket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLocalMarket;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "location", nullable = false, length = 200)
    private String location;

    @Column(name = "contact", nullable = false, length = 15)
    private String contact;

    @Column(name = "attentionDate", nullable = false, length = 50)
    private String attentionDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    public LocalMarket() {
    }

    public LocalMarket(int idLocalMarket, String name, String location, String contact, String attentionDate, Users users) {
        this.idLocalMarket = idLocalMarket;
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.attentionDate = attentionDate;
        this.users = users;
    }

    public int getIdLocalMarket() {
        return idLocalMarket;
    }

    public void setIdLocalMarket(int idLocalMarket) {
        this.idLocalMarket = idLocalMarket;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAttentionDate() {
        return attentionDate;
    }

    public void setAttentionDate(String attentionDate) {
        this.attentionDate = attentionDate;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}

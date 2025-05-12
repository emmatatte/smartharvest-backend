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

    public LocalMarket() {
    }

    public LocalMarket(int idLocalMarket, String name, String location, String contact, String attentionDate) {
        this.idLocalMarket = idLocalMarket;
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.attentionDate = attentionDate;
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
}

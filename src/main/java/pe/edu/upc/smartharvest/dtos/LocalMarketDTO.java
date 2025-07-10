package pe.edu.upc.smartharvest.dtos;

import jakarta.persistence.*;
import pe.edu.upc.smartharvest.entities.Sensor;
import pe.edu.upc.smartharvest.entities.Users;

public class LocalMarketDTO {
    private int idLocalMarket;
    private String name;
    private String location;
    private String contact;
    private String attentionDate;
    private Users users;

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

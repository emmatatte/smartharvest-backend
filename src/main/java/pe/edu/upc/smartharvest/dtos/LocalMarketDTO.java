package pe.edu.upc.smartharvest.dtos;

import jakarta.persistence.*;
import pe.edu.upc.smartharvest.entities.Sensor;

public class LocalMarketDTO {
    private int idLocalMarket;
    private String name;
    private String location;
    private String contact;
    private String attentionDate;

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

package pe.edu.upc.smartharvest.dtos;

import jakarta.persistence.*;
import pe.edu.upc.smartharvest.entities.Sensor;

public class LocalMarketDTO {
    private int idLocalMarket;
    private String name;
    private String location;
    private String contact;
    private String attentionDate;
    private Sensor sensor;
}

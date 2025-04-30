package pe.edu.upc.smartharvest.dtos;

import jakarta.persistence.*;
import pe.edu.upc.smartharvest.entities.Sensor;

import java.time.LocalDate;

public class MaintenanceDTO {
    private int idMaintenance;
    private LocalDate installationDate;
    private String tipoMantenimiento;
    private String description;
    private Sensor sensor;
}

package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Maintenance")
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMaintenance;

    @Column(name = "installationDate", nullable = false)
    private LocalDate installationDate;

    @Column(name = "maintenanceType", nullable = false, length = 50)
    private String tipoMantenimiento;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @ManyToOne
    @JoinColumn(name = "idSensor")
    private Sensor sensor;

    public Maintenance() {
    }

    public Maintenance(int idMaintenance, LocalDate installationDate, String tipoMantenimiento, String description, Sensor sensor) {
        this.idMaintenance = idMaintenance;
        this.installationDate = installationDate;
        this.tipoMantenimiento = tipoMantenimiento;
        this.description = description;
        this.sensor = sensor;
    }

    public int getIdMaintenance() {
        return idMaintenance;
    }

    public void setIdMaintenance(int idMaintenance) {
        this.idMaintenance = idMaintenance;
    }

    public LocalDate getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(LocalDate installationDate) {
        this.installationDate = installationDate;
    }

    public String getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public void setTipoMantenimiento(String tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}

package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Mantenimiento")
public class Mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMantenimiento;

    @Column(name = "fechaInstalacion", nullable = false)
    private LocalDate fechaInstalacion;

    @Column(name = "tipoMantenimiento", nullable = false, length = 50)
    private String tipoMantenimiento;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idSensor")
    private Sensor sensor;

    public Mantenimiento() {
    }

    public Mantenimiento(int idMantenimiento, LocalDate fechaInstalacion, String tipoMantenimiento, String descripcion, Sensor sensor) {
        this.idMantenimiento = idMantenimiento;
        this.fechaInstalacion = fechaInstalacion;
        this.tipoMantenimiento = tipoMantenimiento;
        this.descripcion = descripcion;
        this.sensor = sensor;
    }

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public LocalDate getFechaInstalacion() {
        return fechaInstalacion;
    }

    public void setFechaInstalacion(LocalDate fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }

    public String getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public void setTipoMantenimiento(String tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}

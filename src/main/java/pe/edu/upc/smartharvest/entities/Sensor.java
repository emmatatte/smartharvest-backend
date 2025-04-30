package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Sensor")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSensor;

    @Column(name = "tipoSensor", nullable = false, length = 20)
    private String tipoSensor;

    @Column(name = "fechaInstalacion", nullable = false)
    private LocalDate fechaInstalacion;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    @Column(name = "ultimaLectura", nullable = false)
    private LocalDate ultimaLectura;

    @ManyToOne
    @JoinColumn(name = "idParcela")
    private Parcela parcela;

    public Sensor() {
    }

    public Sensor(int idSensor, String tipoSensor, LocalDate fechaInstalacion, boolean estado, LocalDate ultimaLectura, Parcela parcela) {
        this.idSensor = idSensor;
        this.tipoSensor = tipoSensor;
        this.fechaInstalacion = fechaInstalacion;
        this.estado = estado;
        this.ultimaLectura = ultimaLectura;
        this.parcela = parcela;
    }

    public int getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(int idSensor) {
        this.idSensor = idSensor;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }

    public LocalDate getFechaInstalacion() {
        return fechaInstalacion;
    }

    public void setFechaInstalacion(LocalDate fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDate getUltimaLectura() {
        return ultimaLectura;
    }

    public void setUltimaLectura(LocalDate ultimaLectura) {
        this.ultimaLectura = ultimaLectura;
    }

    public Parcela getParcela() {
        return parcela;
    }

    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
    }
}

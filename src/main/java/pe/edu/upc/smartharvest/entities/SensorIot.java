package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "SensorIoT")
public class SensorIot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSensor;

    @Column (name = "tipo", nullable = false, length = 50)
    private String tipo;

    @Column (name = "fechaInstalacion", nullable = false)
    private LocalDate fechaInstalacion;

    @Column (name = "estado", nullable = false)
    private boolean estado;

    @Column (name = "ultimaLectura", nullable = false)
    private LocalDate ultimaLectura;

    @ManyToOne
    @JoinColumn(name = "idParcela")
    private Parcela parcela;

    public SensorIot() {
    }

    public SensorIot(boolean estado, LocalDate ultimaLectura, Parcela parcela, LocalDate fechaInstalacion, String tipo, int idSensor) {
        this.estado = estado;
        this.ultimaLectura = ultimaLectura;
        this.parcela = parcela;
        this.fechaInstalacion = fechaInstalacion;
        this.tipo = tipo;
        this.idSensor = idSensor;
    }

    public LocalDate getUltimaLectura() {
        return ultimaLectura;
    }

    public void setUltimaLectura(LocalDate ultimaLectura) {
        this.ultimaLectura = ultimaLectura;
    }

    public int getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(int idSensor) {
        this.idSensor = idSensor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public Parcela getParcela() {
        return parcela;
    }

    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
    }
}

package pe.edu.upc.smartharvest.dtos;

import pe.edu.upc.smartharvest.entities.Parcela;

import java.time.LocalDate;

public class SensorIotDTO {
    private int idSensor;
    private String tipo;
    private LocalDate fechaInstalacion;
    private boolean estado;
    private LocalDate ultimaLectura;
    private Parcela parcela;

    public Parcela getParcela() {
        return parcela;
    }

    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
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

    public LocalDate getUltimaLectura() {
        return ultimaLectura;
    }

    public void setUltimaLectura(LocalDate ultimaLectura) {
        this.ultimaLectura = ultimaLectura;
    }
}

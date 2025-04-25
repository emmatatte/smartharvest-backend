package pe.edu.upc.smartharvest.dtos;

public class CultivoDTO {
    private int idCultivo;
    private String tipoCultivo;
    private String fechaSiembra;
    private String fechaCosechaEstimada;
    private String estadoActual;

    public int getIdCultivo() {
        return idCultivo;
    }

    public void setIdCultivo(int idCultivo) {
        this.idCultivo = idCultivo;
    }

    public String getTipoCultivo() {
        return tipoCultivo;
    }

    public void setTipoCultivo(String tipoCultivo) {
        this.tipoCultivo = tipoCultivo;
    }

    public String getFechaSiembra() {
        return fechaSiembra;
    }

    public void setFechaSiembra(String fechaSiembra) {
        this.fechaSiembra = fechaSiembra;
    }

    public String getFechaCosechaEstimada() {
        return fechaCosechaEstimada;
    }

    public void setFechaCosechaEstimada(String fechaCosechaEstimada) {
        this.fechaCosechaEstimada = fechaCosechaEstimada;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }
}

package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Cultivo")
public class Cultivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCultivo;

    @Column(name = "tipo_cultivo", length = 50)
    private String tipoCultivo;

    @Column(name = "fecha_siembra")
    private String fechaSiembra;

    @Column(name = "fecha_cosecha_estimada")
    private String fechaCosechaEstimada;

    @Column(name = "estado_actual", length = 50)
    private String estadoActual;

    @ManyToOne
    @JoinColumn(name = "idParcela")
    private Parcela parcela;

    public Cultivo() {
    }

    public Cultivo(int idCultivo, String tipoCultivo, String fechaSiembra, String fechaCosechaEstimada, String estadoActual, Parcela parcela) {
        this.idCultivo = idCultivo;
        this.tipoCultivo = tipoCultivo;
        this.fechaSiembra = fechaSiembra;
        this.fechaCosechaEstimada = fechaCosechaEstimada;
        this.estadoActual = estadoActual;
        this.parcela = parcela;
    }

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

    public Parcela getParcela() {
        return parcela;
    }

    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
    }
}

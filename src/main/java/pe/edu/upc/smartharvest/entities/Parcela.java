package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Parcela")
public class Parcela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idParcela;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "ubicacion", nullable = false, length = 200)
    private String ubicacion;

    @Column(name = "tamaño")
    private double tamaño;

    @Column(name = "tipo_suelo", length = 100)
    private String tipoSuelo;

    @Column(name = "fecha_registro")
    private String fechaRegistro;

    public Parcela() {
    }

    public Parcela(int idParcela, String nombre, String ubicacion, double tamaño, String tipoSuelo, String fechaRegistro) {
        this.idParcela = idParcela;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tamaño = tamaño;
        this.tipoSuelo = tipoSuelo;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdParcela() {
        return idParcela;
    }

    public void setIdParcela(int idParcela) {
        this.idParcela = idParcela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public String getTipoSuelo() {
        return tipoSuelo;
    }

    public void setTipoSuelo(String tipoSuelo) {
        this.tipoSuelo = tipoSuelo;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}

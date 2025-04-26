package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Insumo")
public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInsumo;

    @Column(name = "nombre", nullable = false, length = 70)
    private String nombre;

    @Column(name = "tipo", nullable = false, length = 70)
    private String tipo;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "unidad", nullable = false, length = 15)
    private String unidad;

    @Column(name = "fechaRegistro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "fechaCaducidad", nullable = false)
    private LocalDate fechaCaducidad;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Insumo() {
    }

    public Insumo(int idInsumo, String nombre, String tipo, int cantidad, String unidad, LocalDate fechaRegistro, LocalDate fechaCaducidad, Usuario usuario) {
        this.idInsumo = idInsumo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.fechaRegistro = fechaRegistro;
        this.fechaCaducidad = fechaCaducidad;
        this.usuario = usuario;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

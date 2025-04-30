package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "MercadoLocal")
public class MercadoLocal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMercadoLocal;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "ubicacion", nullable = false, length = 200)
    private String ubicacion;

    @Column(name = "contacto", nullable = false, length = 15)
    private String contacto;

    @Column(name = "horarioAtencion", nullable = false, length = 50)
    private String horarioAtencion;

    public MercadoLocal() {
    }

    public MercadoLocal(int idMercadoLocal, String nombre, String ubicacion, String contacto, String horarioAtencion) {
        this.idMercadoLocal = idMercadoLocal;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.contacto = contacto;
        this.horarioAtencion = horarioAtencion;
    }

    public int getIdMercadoLocal() {
        return idMercadoLocal;
    }

    public void setIdMercadoLocal(int idMercadoLocal) {
        this.idMercadoLocal = idMercadoLocal;
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

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }
}

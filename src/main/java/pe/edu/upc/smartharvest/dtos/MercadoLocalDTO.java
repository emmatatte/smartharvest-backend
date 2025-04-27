package pe.edu.upc.smartharvest.dtos;

public class MercadoLocalDTO {
    private int idMercadoLocal;
    private String nombre;
    private String ubicacion;
    private String contacto;
    private String horarioAtencion;

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

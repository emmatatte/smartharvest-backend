package pe.edu.upc.smartharvest.dtos;
import pe.edu.upc.smartharvest.entities.Sensor;
import pe.edu.upc.smartharvest.entities.Usuario;

import java.time.LocalDateTime;

public class NotificacionDTO {
    private int idNotification;
    private String notificationType;
    private String message;
    private LocalDateTime dateTime;
    private Boolean read;
    private Sensor sensor;
    private Usuario usuario;

    public int getIdNotification() {return idNotification;}

    public void setIdNotification(int idNotification) {this.idNotification = idNotification;}

    public String getNotificationType() {return notificationType;}

    public void setNotificationType(String notificationType) {this.notificationType = notificationType;}

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}

    public LocalDateTime getDateTime() {return dateTime;}

    public void setDateTime(LocalDateTime dateTime) {this.dateTime = dateTime;}

    public Boolean getRead() {return read;}

    public void setRead(Boolean read) {this.read = read;}

    public Sensor getSensor() {return sensor;}

    public void setSensor(Sensor sensor) {this.sensor = sensor;}

    public Usuario getUsuario() {return usuario;}

    public void setUsuario(Usuario usuario) {this.usuario = usuario;}
}

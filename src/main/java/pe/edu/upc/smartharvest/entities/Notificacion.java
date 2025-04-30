package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Notificacion")

public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotification;

    @Column(name = "tipo_notificacion", length = 70)
    private String notificationType;

    @Column(name = "mensaje", length = 200)
    private String message;

    @Column(name = "fecha_hora")
    private LocalDateTime dateTime;

    @Column(name = "leido")
    private Boolean read;

    @ManyToOne
    @JoinColumn(name = "idSensor", nullable = false)
    private Sensor sensor;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    public Notificacion() {
    }

    public Notificacion(int idNotification, String notificationType, String message, LocalDateTime dateTime, Boolean read, Sensor sensor, Usuario usuario) {
        this.idNotification = idNotification;
        this.notificationType = notificationType;
        this.message = message;
        this.dateTime = dateTime;
        this.read = read;
        this.sensor = sensor;
        this.usuario = usuario;
    }

    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

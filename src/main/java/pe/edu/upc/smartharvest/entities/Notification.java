package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotification;

    @Column(name = "notificationType", nullable = false, length = 70)
    private String notificationType;

    @Column(name = "message", nullable = false, length = 200)
    private String message;

    @Column(name = "dateTime", nullable = false)
    private LocalDate dateTime;

    @Column(name = "read", nullable = false)
    private Boolean read;

    @ManyToOne
    @JoinColumn(name = "idSensor")
    private Sensor sensor;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Users users;

    @Column(name = "weather_event", length = 50)
    private String weatherEvent;

    public Notification() {
    }

    public Notification(int idNotification, String notificationType, String message, LocalDate dateTime, Boolean read, Sensor sensor, Users users) {
        this.idNotification = idNotification;
        this.notificationType = notificationType;
        this.message = message;
        this.dateTime = dateTime;
        this.read = read;
        this.sensor = sensor;
        this.users = users;
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

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getWeatherEvent() {
        return weatherEvent;
    }

    public void setWeatherEvent(String weatherEvent) {
        this.weatherEvent = weatherEvent;
    }
}
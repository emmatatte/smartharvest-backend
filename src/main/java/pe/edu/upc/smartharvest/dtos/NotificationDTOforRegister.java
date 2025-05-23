package pe.edu.upc.smartharvest.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.smartharvest.entities.Sensor;
import pe.edu.upc.smartharvest.entities.Users;

import java.time.LocalDate;

public class NotificationDTOforRegister {
    private int idNotification;
    private String notificationType;
    private String message;
    private LocalDate dateTime;
    private Boolean read;
    private Sensor sensor;
    private Users users;
    private String weatherEvent;

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

package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Sensor")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSensor;

    @Column(name = "sensorType", nullable = false, length = 20)
    private String sensorType;

    @Column(name = "installationDate", nullable = false)
    private LocalDate installationDate;

    @Column(name = "state", nullable = false)
    private boolean state;

    @Column(name = "lastLecture", nullable = false)
    private LocalDate lastLecture;

    @Column(name = "batteryLevel", nullable = false)
    private double batteryLevel;

    @ManyToOne
    @JoinColumn(name = "idParcel")
    private Parcel parcel;

    @Column(name = "humidity", nullable = false)
    private Double humidity;

    public Sensor() {
    }

    public Sensor(int idSensor, String sensorType, LocalDate installationDate, boolean state, LocalDate lastLecture, Parcel parcel, double batteryLevel, Double humidity) {
        this.idSensor = idSensor;
        this.sensorType = sensorType;
        this.installationDate = installationDate;
        this.state = state;
        this.lastLecture = lastLecture;
        this.parcel = parcel;
        this.batteryLevel = batteryLevel;
        this.humidity = humidity;
    }

    public int getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(int idSensor) {
        this.idSensor = idSensor;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public LocalDate getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(LocalDate installationDate) {
        this.installationDate = installationDate;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public LocalDate getLastLecture() {
        return lastLecture;
    }

    public void setLastLecture(LocalDate lastLecture) {
        this.lastLecture = lastLecture;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }
}

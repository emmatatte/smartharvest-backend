package pe.edu.upc.smartharvest.dtos;

import java.time.LocalDate;

public class SensorDTO {
    private int idSensor;
    private String sensorType;
    private LocalDate installationDate;
    private boolean state;
    private LocalDate lastLecture;
    private double batteryLevel;
    private ParcelDTO parcel;
    private Double humidity;

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

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public ParcelDTO getParcel() {
        return parcel;
    }

    public void setParcel(ParcelDTO parcel) {
        this.parcel = parcel;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }
}

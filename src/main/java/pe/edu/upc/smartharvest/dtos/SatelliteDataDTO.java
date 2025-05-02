package pe.edu.upc.smartharvest.dtos;

import java.time.LocalDate;

public class SatelliteDataDTO {

    private Long id;
    private LocalDate captureDate;
    private double ndviValue;
    private double latitude;
    private double longitude;
    private int cropId;

    public SatelliteDataDTO() {
    }

    public SatelliteDataDTO(Long id, LocalDate captureDate, double ndviValue, double latitude, double longitude, int cropId) {
        this.id = id;
        this.captureDate = captureDate;
        this.ndviValue = ndviValue;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cropId = cropId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(LocalDate captureDate) {
        this.captureDate = captureDate;
    }

    public double getNdviValue() {
        return ndviValue;
    }

    public void setNdviValue(double ndviValue) {
        this.ndviValue = ndviValue;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }
}
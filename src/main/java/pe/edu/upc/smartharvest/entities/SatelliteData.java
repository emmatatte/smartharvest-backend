package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "satellite_data")
public class SatelliteData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "capture_date", nullable = false)
    private LocalDate captureDate;

    @Column(name = "ndvi_value", nullable = false)
    private double ndviValue; // Example: Normalized Difference Vegetation Index

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @ManyToOne
    @JoinColumn(name = "crop_id")
    private Crop crop;

    public SatelliteData() {
    }

    public SatelliteData(Long id, LocalDate captureDate, double ndviValue, double latitude, double longitude, Crop crop) {
        this.id = id;
        this.captureDate = captureDate;
        this.ndviValue = ndviValue;
        this.latitude = latitude;
        this.longitude = longitude;
        this.crop = crop;
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

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }
}
package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Crop")
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCrop;

    @Column(name = "typeCrop", nullable = false, length = 50)
    private String typeCrop;

    @Column(name = "sowingDate", nullable = false)
    private LocalDate sowingDate;

    @Column(name = "estimatedHarvestDate", nullable = false)
    private LocalDate estimatedHarvestDate;

    @Column(name = "actualState", nullable = false, length = 50)
    private String actualState;

    @ManyToOne
    @JoinColumn(name = "idParcela")
    private Parcel parcel;

    public Crop() {
    }

    public Crop(int idCrop, String typeCrop, LocalDate sowingDate, LocalDate estimatedHarvestDate, String actualState, Parcel parcel) {
        this.idCrop = idCrop;
        this.typeCrop = typeCrop;
        this.sowingDate = sowingDate;
        this.estimatedHarvestDate = estimatedHarvestDate;
        this.actualState = actualState;
        this.parcel = parcel;
    }

    public int getIdCrop() {
        return idCrop;
    }

    public void setIdCrop(int idCrop) {
        this.idCrop = idCrop;
    }

    public String getTypeCrop() {
        return typeCrop;
    }

    public void setTypeCrop(String typeCrop) {
        this.typeCrop = typeCrop;
    }

    public LocalDate getSowingDate() {
        return sowingDate;
    }

    public void setSowingDate(LocalDate sowingDate) {
        this.sowingDate = sowingDate;
    }

    public LocalDate getEstimatedHarvestDate() {
        return estimatedHarvestDate;
    }

    public void setEstimatedHarvestDate(LocalDate estimatedHarvestDate) {
        this.estimatedHarvestDate = estimatedHarvestDate;
    }

    public String getActualState() {
        return actualState;
    }

    public void setActualState(String actualState) {
        this.actualState = actualState;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }
}
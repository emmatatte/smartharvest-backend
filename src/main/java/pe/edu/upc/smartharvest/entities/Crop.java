package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Crop")
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCrop;

    @Column(name = "typeCrop", length = 50)
    private String typeCrop;

    @Column(name = "sowingDate")
    private String sowingDate;

    @Column(name = "estimatedHarvestDate")
    private String estimatedHarvestDate;

    @Column(name = "actualState", length = 50)
    private String actualState;

    @ManyToOne
    @JoinColumn(name = "idParcela")
    private Parcel parcel;

    public Crop() {
    }

    public Crop(int idCrop, String typeCrop, String sowingDate, String estimatedHarvestDate, String actualState, Parcel parcel) {
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

    public String getSowingDate() {
        return sowingDate;
    }

    public void setSowingDate(String sowingDate) {
        this.sowingDate = sowingDate;
    }

    public String getEstimatedHarvestDate() {
        return estimatedHarvestDate;
    }

    public void setEstimatedHarvestDate(String estimatedHarvestDate) {
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

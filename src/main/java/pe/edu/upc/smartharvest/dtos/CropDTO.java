package pe.edu.upc.smartharvest.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.smartharvest.entities.Parcel;

public class CropDTO {
    private int idCrop;
    private String typeCrop;
    private String sowingDate;
    private String estimatedHarvestDate;
    private String actualState;
    private Parcel parcel;

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

package pe.edu.upc.smartharvest.dtos;

import java.time.LocalDate;

public class CropDTO {
    private int idCrop;
    private String typeCrop;
    private LocalDate sowingDate;
    private LocalDate estimatedHarvestDate;
    private String actualState;
    private ParcelDTO parcel;

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

    public ParcelDTO getParcel() {
        return parcel;
    }

    public void setParcel(ParcelDTO parcel) {
        this.parcel = parcel;
    }
}

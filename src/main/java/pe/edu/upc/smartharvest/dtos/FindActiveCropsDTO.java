package pe.edu.upc.smartharvest.dtos;

import java.time.LocalDate;

public class FindActiveCropsDTO {
    private int idCrop;
    private String actualState;
    private String name;
    private String type_crop;
    private LocalDate sowing_date;
    private int idParcel;

    public int getIdCrop() {
        return idCrop;
    }

    public void setIdCrop(int idCrop) {
        this.idCrop = idCrop;
    }

    public String getActualState() {
        return actualState;
    }

    public void setActualState(String actualState) {
        this.actualState = actualState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType_crop() {
        return type_crop;
    }

    public void setType_crop(String type_crop) {
        this.type_crop = type_crop;
    }

    public LocalDate getSowing_date() {
        return sowing_date;
    }

    public void setSowing_date(LocalDate sowing_date) {
        this.sowing_date = sowing_date;
    }

    public int getIdParcel() {
        return idParcel;
    }

    public void setIdParcel(int idParcel) {
        this.idParcel = idParcel;
    }
}
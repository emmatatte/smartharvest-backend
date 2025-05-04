package pe.edu.upc.smartharvest.dtos;

import java.time.LocalDate;

public class CropsNeedingAttentionDTO {
    private int idCrop;
    private String typeCrop;
    private String name;
    private LocalDate sowingDate;
    private String actualState;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getSowingDate() {
        return sowingDate;
    }

    public void setSowingDate(LocalDate sowingDate) {
        this.sowingDate = sowingDate;
    }

    public String getActualState() {
        return actualState;
    }

    public void setActualState(String actualState) {
        this.actualState = actualState;
    }
}

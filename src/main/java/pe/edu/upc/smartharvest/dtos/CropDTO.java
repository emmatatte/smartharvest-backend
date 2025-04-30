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
}

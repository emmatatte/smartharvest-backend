package pe.edu.upc.smartharvest.dtos;

public class TopCropsByMaintenanceDTO {
    private String type_crop ;
    private int quant_maintenance;

    public String getType_crop() {
        return type_crop;
    }

    public void setType_crop(String type_crop) {
        this.type_crop = type_crop;
    }

    public int getQuant_maintenance() {
        return quant_maintenance;
    }

    public void setQuant_maintenance(int quant_maintenance) {
        this.quant_maintenance = quant_maintenance;
    }
}

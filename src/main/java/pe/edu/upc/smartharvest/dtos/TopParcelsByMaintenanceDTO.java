package pe.edu.upc.smartharvest.dtos;

public class TopParcelsByMaintenanceDTO {
    private String parcelName;
    private int quant_maintenance;

    public String getParcelName() {
        return parcelName;
    }

    public void setParcelName(String parcelName) {
        this.parcelName = parcelName;
    }

    public int getQuant_maintenance() {
        return quant_maintenance;
    }

    public void setQuant_maintenance(int quant_maintenance) {
        this.quant_maintenance = quant_maintenance;
    }
}

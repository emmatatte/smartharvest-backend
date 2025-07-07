package pe.edu.upc.smartharvest.dtos;

public class CountMaintenanceSensorDTO {
    private String sensorType;
    private int quantity;

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

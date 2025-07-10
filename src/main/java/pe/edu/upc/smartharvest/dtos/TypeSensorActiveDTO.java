package pe.edu.upc.smartharvest.dtos;

public class TypeSensorActiveDTO {
    private String sensorType ;
    private int cantidad;

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

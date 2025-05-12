package pe.edu.upc.smartharvest.dtos;

public class FindActiveSensorsDTO {
    private int idSensor;
    private String name;

    public int getIdSensor() {
        return idSensor;
    }
    public void setIdSensor(int idSensor) {
        this.idSensor = idSensor;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

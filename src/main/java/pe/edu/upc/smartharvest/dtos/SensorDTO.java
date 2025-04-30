package pe.edu.upc.smartharvest.dtos;
import pe.edu.upc.smartharvest.entities.Parcel;
import java.time.LocalDate;

public class SensorDTO {
    private int idSensor;
    private String sensorType;
    private LocalDate installationDate;
    private boolean state;
    private LocalDate lastLecture;
    private Parcel parcel;

    public SensorDTO() {
    }

    public SensorDTO(int idSensor, String sensorType, LocalDate installationDate, boolean state, LocalDate lastLecture, Parcel parcel) {
        this.idSensor = idSensor;
        this.sensorType = sensorType;
        this.installationDate = installationDate;
        this.state = state;
        this.lastLecture = lastLecture;
        this.parcel = parcel;
    }

    public int getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(int idSensor) {
        this.idSensor = idSensor;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public LocalDate getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(LocalDate installationDate) {
        this.installationDate = installationDate;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public LocalDate getLastLecture() {
        return lastLecture;
    }

    public void setLastLecture(LocalDate lastLecture) {
        this.lastLecture = lastLecture;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }
}


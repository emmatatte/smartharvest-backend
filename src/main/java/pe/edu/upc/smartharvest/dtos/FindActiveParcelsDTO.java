package pe.edu.upc.smartharvest.dtos;

public class FindActiveParcelsDTO {
    private int idParcel;
    private String name;

    public int getIdParcel() {
        return idParcel;
    }
    public void setIdParcel(int idParcel) {
        this.idParcel = idParcel;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

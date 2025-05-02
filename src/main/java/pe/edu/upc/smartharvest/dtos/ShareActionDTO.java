package pe.edu.upc.smartharvest.dtos;

public class ShareActionDTO {
    private int id;
    private String sharedTo;
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSharedTo() {
        return sharedTo;
    }

    public void setSharedTo(String sharedTo) {
        this.sharedTo = sharedTo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

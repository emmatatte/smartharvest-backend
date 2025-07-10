package pe.edu.upc.smartharvest.dtos;

public class CropByStateDTO {
    private String actualState;
    private int quantity;

    public String getActualState() {
        return actualState;
    }

    public void setActualState(String actualState) {
        this.actualState = actualState;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

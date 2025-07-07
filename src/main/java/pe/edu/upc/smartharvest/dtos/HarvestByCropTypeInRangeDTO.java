package pe.edu.upc.smartharvest.dtos;

public class HarvestByCropTypeInRangeDTO {
    private String typeCrop;
    private int quantity;

    public String getTypeCrop() {
        return typeCrop;
    }

    public void setTypeCrop(String typeCrop) {
        this.typeCrop = typeCrop;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

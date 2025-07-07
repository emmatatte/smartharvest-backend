package pe.edu.upc.smartharvest.dtos;

public class RecommendationsByMonthInYearDTO {
    private String mes;
    private int quantity;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

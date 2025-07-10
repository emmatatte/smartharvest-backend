package pe.edu.upc.smartharvest.dtos;

public class ParcelsByMonthDTO {
    private String mes ;
    private int cantidad;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

package pe.edu.upc.smartharvest.dtos;

import pe.edu.upc.smartharvest.entities.AgriculturalProduct;
import pe.edu.upc.smartharvest.entities.LocalMarket;

public class ProductMarketDTO {
    private int idProductMarket;
    private Double estimatedPrice;
    private Boolean availability;
    private AgriculturalProduct agriculturalProduct;
    private LocalMarket LocalMarket;

    public int getIdProductMarket() {
        return idProductMarket;
    }

    public void setIdProductMarket(int idProductMarket) {
        this.idProductMarket = idProductMarket;
    }

    public Double getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(Double estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public AgriculturalProduct getAgriculturalProduct() {
        return agriculturalProduct;
    }

    public void setAgriculturalProduct(AgriculturalProduct agriculturalProduct) {
        this.agriculturalProduct = agriculturalProduct;
    }

    public LocalMarket getLocalMarket() {
        return LocalMarket;
    }

    public void setLocalMarket(LocalMarket localMarket) {
        LocalMarket = localMarket;
    }
}

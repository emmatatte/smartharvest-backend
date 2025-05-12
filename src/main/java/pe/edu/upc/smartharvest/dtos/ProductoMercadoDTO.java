package pe.edu.upc.smartharvest.dtos;

import pe.edu.upc.smartharvest.entities.MercadoLocal;
import pe.edu.upc.smartharvest.entities.ProductoAgricola;

public class ProductoMercadoDTO {
    private int idMarketProduct;
    private Double estimatedPrice;
    private Boolean availability;
    private ProductoAgricola ProductoAgricola;
    private MercadoLocal MercadoLocal;

    public int getIdMarketProduct() {
        return idMarketProduct;
    }

    public void setIdMarketProduct(int idMarketProduct) {
        this.idMarketProduct = idMarketProduct;
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

    public ProductoAgricola getProductoAgricola() {
        return ProductoAgricola;
    }

    public void setProductoAgricola(ProductoAgricola productoAgricola) {
        ProductoAgricola = productoAgricola;
    }

    public MercadoLocal getMercadoLocal() {
        return MercadoLocal;
    }

    public void setMercadoLocal(MercadoLocal mercadoLocal) {
        MercadoLocal = mercadoLocal;
    }
}

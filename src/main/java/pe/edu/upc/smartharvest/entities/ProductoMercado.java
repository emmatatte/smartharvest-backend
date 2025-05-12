package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ProductoMercado")

public class ProductoMercado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMarketProduct;

    @Column(name = "precio_estimado")
    private Double estimatedPrice;

    @Column(name = "disponibilidad")
    private Boolean availability;

    @ManyToOne
    @JoinColumn(name = "idProduct", nullable = false)
    private ProductoAgricola ProductoAgricola;

    @ManyToOne
    @JoinColumn(name = "idMercadoLocal", nullable = false)
    private MercadoLocal MercadoLocal;

    public ProductoMercado() {
    }

    public ProductoMercado(int idMarketProduct, Double estimatedPrice, Boolean availability, ProductoAgricola productoAgricola, MercadoLocal mercadoLocal) {
        this.idMarketProduct = idMarketProduct;
        this.estimatedPrice = estimatedPrice;
        this.availability = availability;
        ProductoAgricola = productoAgricola;
        MercadoLocal = mercadoLocal;
    }

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

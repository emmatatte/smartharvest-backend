package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ProductMarket")
public class ProductMarket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProductMarket;

    @Column(name = "estimatedPrice", nullable = false)
    private Double estimatedPrice;

    @Column(name = "availability")
    private Boolean availability;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    private AgriculturalProduct agriculturalProduct;

    @ManyToOne
    @JoinColumn(name = "idLocalMarket")
    private LocalMarket localMarket;

    public ProductMarket() {
    }

    public ProductMarket(int idProductMarket, Double estimatedPrice, Boolean availability, AgriculturalProduct agriculturalProduct, LocalMarket localMarket) {
        this.idProductMarket = idProductMarket;
        this.estimatedPrice = estimatedPrice;
        this.availability = availability;
        this.agriculturalProduct = agriculturalProduct;
        this.localMarket = localMarket;
    }

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
        return localMarket;
    }

    public void setLocalMarket(LocalMarket localMarket) {
        this.localMarket = localMarket;
    }
}

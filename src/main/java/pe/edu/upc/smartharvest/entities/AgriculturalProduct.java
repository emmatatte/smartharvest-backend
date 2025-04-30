package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "AgriculturalProduct")
public class AgriculturalProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "unitMeasure", nullable = false, length = 20)
    private String unitMeasure;

    @Column(name = "harvestDate", nullable = false)
    private LocalDate harvestDate;

    @ManyToOne
    @JoinColumn(name = "idCrop")
    private Crop crop;

    public AgriculturalProduct() {
    }

    public AgriculturalProduct(int idProduct, String name, int quantity, String unitMeasure, LocalDate harvestDate, Crop crop) {
        this.idProduct = idProduct;
        this.name = name;
        this.quantity = quantity;
        this.unitMeasure = unitMeasure;
        this.harvestDate = harvestDate;
        this.crop = crop;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    public LocalDate getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(LocalDate harvestDate) {
        this.harvestDate = harvestDate;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }
}

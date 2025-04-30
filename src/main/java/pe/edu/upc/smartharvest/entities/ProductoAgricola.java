package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ProductoAgricola")

public class ProductoAgricola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    @Column(name = "nombre", length = 50)
    private String name;

    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "unidad_medida", length = 10)
    private String unitMeasure;

    @Column(name = "fecha_recoleccion")
    private LocalDateTime harvestDate;

    @ManyToOne
    @JoinColumn(name = "idCultivo", nullable = false)
    private Cultivo cultivo;

    public ProductoAgricola() {
    }

    public ProductoAgricola(int idProduct, String name, Integer quantity, String unitMeasure, LocalDateTime harvestDate, Cultivo cultivo) {
        this.idProduct = idProduct;
        this.name = name;
        this.quantity = quantity;
        this.unitMeasure = unitMeasure;
        this.harvestDate = harvestDate;
        this.cultivo = cultivo;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    public LocalDateTime getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(LocalDateTime harvestDate) {
        this.harvestDate = harvestDate;
    }

    public Cultivo getCultivo() {
        return cultivo;
    }

    public void setCultivo(Cultivo cultivo) {
        this.cultivo = cultivo;
    }
}

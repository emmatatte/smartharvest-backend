package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Recommendation")
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecommendation;

    @Column(name = "type", nullable = false, length = 50)
    private String type;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @Column(name = "issueDate", nullable = false)
    private LocalDate issueDate;

    @Column(name = "source", nullable = false, length = 50)
    private String source;

    @ManyToOne
    @JoinColumn(name = "idCrop")
    private Crop crop;

    public Recommendation() {
    }

    public Recommendation(int idRecommendation, String type, String description, LocalDate issueDate, String source, Crop crop) {
        this.idRecommendation = idRecommendation;
        this.type = type;
        this.description = description;
        this.issueDate = issueDate;
        this.source = source;
        this.crop = crop;
    }

    public int getIdRecommendation() {
        return idRecommendation;
    }

    public void setIdRecommendation(int idRecommendation) {
        this.idRecommendation = idRecommendation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }
}

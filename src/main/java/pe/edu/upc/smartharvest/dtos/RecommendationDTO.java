package pe.edu.upc.smartharvest.dtos;

import pe.edu.upc.smartharvest.entities.Crop;
import pe.edu.upc.smartharvest.entities.Users;

import java.time.LocalDate;

public class RecommendationDTO {
    private int idRecommendation;
    private String type;
    private String description;
    private LocalDate issueDate;
    private String source;
    private CropDTO crop;

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

    public CropDTO getCrop() {
        return crop;
    }

    public void setCrop(CropDTO crop) {
        this.crop = crop;
    }
}

package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Recomendacion")
public class Recomendacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecommendation;

    @Column(name = "tipo", length = 50)
    private String type;

    @Column(name = "descripcion", length = 200)
    private String description;

    @Column(name = "fecha_emision")
    private LocalDateTime issueDate;

    @Column(name = "fuente", length = 50)
    private String source;

    @ManyToOne
    @JoinColumn(name = "idCultivo", nullable = false)
    private Cultivo cultivo;

    public Recomendacion() {
    }

    public Recomendacion(int idRecommendation, String type, String description, LocalDateTime issueDate, String source, Cultivo cultivo) {
        this.idRecommendation = idRecommendation;
        this.type = type;
        this.description = description;
        this.issueDate = issueDate;
        this.source = source;
        this.cultivo = cultivo;
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

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Cultivo getCultivo() {
        return cultivo;
    }

    public void setCultivo(Cultivo cultivo) {
        this.cultivo = cultivo;
    }
}

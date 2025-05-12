package pe.edu.upc.smartharvest.dtos;

public class findRecommendationsDTO {
    private int idRecommendation;
    private String description;
    private int IDROP;
    private String type;
    private String state;

    public int getIdRecommendation() {
        return idRecommendation;
    }

    public void setIdRecommendation(int idRecommendation) {
        this.idRecommendation = idRecommendation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIDROP() {
        return IDROP;
    }

    public void setIDROP(int IDROP) {
        this.IDROP = IDROP;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

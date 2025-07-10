package pe.edu.upc.smartharvest.dtos;

public class RiskPercentageByParcelDTO {
    private int idParcel;
    private String parcelName;
    private int totalCrops;
    private int cropsAtRisk;
    private double riskPercentage;

    public int getIdParcel() {
        return idParcel;
    }

    public void setIdParcel(int idParcel) {
        this.idParcel = idParcel;
    }

    public String getParcelName() {
        return parcelName;
    }

    public void setParcelName(String parcelName) {
        this.parcelName = parcelName;
    }

    public int getTotalCrops() {
        return totalCrops;
    }

    public void setTotalCrops(int totalCrops) {
        this.totalCrops = totalCrops;
    }

    public int getCropsAtRisk() {
        return cropsAtRisk;
    }

    public void setCropsAtRisk(int cropsAtRisk) {
        this.cropsAtRisk = cropsAtRisk;
    }

    public double getRiskPercentage() {
        return riskPercentage;
    }

    public void setRiskPercentage(double riskPercentage) {
        this.riskPercentage = riskPercentage;
    }
}

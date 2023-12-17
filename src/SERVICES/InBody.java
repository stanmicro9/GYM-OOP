package SERVICES;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;
public class InBody implements Serializable{
    protected double heightM;
    protected double totalWeightKG;
    protected double bodyFatMassKG;
    protected double MineralsKG;
    protected double totalBodyWater;
    protected double proteinKG;
    protected LocalDate date;
    private transient final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public LocalDate getDate() {
        return date;
    }
    public double getHeightM() {
        return heightM;
    }
    public double getTotalWeightKG() {
        return totalWeightKG;
    }
    public double getBodyFatMassKG() {
        return bodyFatMassKG;
    }
    public double getMineralsKG() {
        return MineralsKG;
    }
    public double getTotalBodyWater() {
        return totalBodyWater;
    }
    public double getProteinKG() {
        return proteinKG;
    }
    public void setHeightM(double heightM) {
        this.heightM = heightM;
    }
    public void setTotalWeightKG(double totalWeightKG) {
        this.totalWeightKG = totalWeightKG;
    }
    public void setBodyFatMassKG(double bodyFatMassKG) {
        this.bodyFatMassKG = bodyFatMassKG;
    }
    public void setMineralsKG(double mineralsKG) {
        MineralsKG = mineralsKG;
    }
    public void setTotalBodyWater(double totalBodyWater) {
        this.totalBodyWater = totalBodyWater;
    }
    public void setProteinKG(double proteinKG) {
        this.proteinKG = proteinKG;
    }
    public void setDate(String date) {
        this.date = LocalDate.parse(date, formatter);
    }

    public void displayInbody() {
        System.out.println("\n\t\tInbody's Details : " + "\n---------------------------------------------------------------\n"
                + "\n> Date : " + getDate() + "\n> Height (m) : " + getHeightM() + "\n> Total Weight (KG) : " + getTotalWeightKG() + "\n> Body Fat Mass (KG) : " + getBodyFatMassKG() + "\n> Minerals (KG): " + getMineralsKG()
                + "\n> Total Body Water : " + getTotalBodyWater() + "\n> Protein (KG) : " + getProteinKG() + "\n---------------------------------------------------------------\n");
    }

    public static double calculateTargetWeight(double heightM) {
        //Example: Target weight is BMI of 22
        double targetBMI = 22.0;
        return targetBMI * heightM * heightM;
    }

}

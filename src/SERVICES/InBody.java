package SERVICES;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class
InBody {
    protected int heightM;
    protected int totalWeightKG;
    protected int bodyFatMassKG;
    protected int MineralsKG;
    protected int totalBodyWater;
    protected int proteinKG;
    protected LocalDate date;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public LocalDate getDate() {
        return date;
    }
    public int getHeightM() {
        return heightM;
    }
    public int getTotalWeightKG() {
        return totalWeightKG;
    }
    public int getBodyFatMassKG() {
        return bodyFatMassKG;
    }
    public int getMineralsKG() {
        return MineralsKG;
    }
    public int getTotalBodyWater() {
        return totalBodyWater;
    }
    public int getProteinKG() {
        return proteinKG;
    }
    public void setHeightM(int heightM) {
        this.heightM = heightM;
    }
    public void setTotalWeightKG(int totalWeightKG) {
        this.totalWeightKG = totalWeightKG;
    }
    public void setBodyFatMassKG(int bodyFatMassKG) {
        this.bodyFatMassKG = bodyFatMassKG;
    }
    public void setMineralsKG(int mineralsKG) {
        MineralsKG = mineralsKG;
    }
    public void setTotalBodyWater(int totalBodyWater) {
        this.totalBodyWater = totalBodyWater;
    }
    public void setProteinKG(int proteinKG) {
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

}

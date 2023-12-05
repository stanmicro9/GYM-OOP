package SERVICES;

public class
InBody {
    protected int heightM;
    protected int totalWeightKG;
    protected int bodyFatMassKG;
    protected int MineralsKG;
    protected int totalBodyWater;
    protected int proteinKG;
    protected String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHeightM() {
        return heightM;
    }

    public void setHeightM(int heightM) {
        this.heightM = heightM;
    }

    public int getTotalWeightKG() {
        return totalWeightKG;
    }

    public void setTotalWeightKG(int totalWeightKG) {
        this.totalWeightKG = totalWeightKG;
    }

    public int getBodyFatMassKG() {
        return bodyFatMassKG;
    }

    public void setBodyFatMassKG(int bodyFatMassKG) {
        this.bodyFatMassKG = bodyFatMassKG;
    }

    public int getMineralsKG() {
        return MineralsKG;
    }

    public void setMineralsKG(int mineralsKG) {
        MineralsKG = mineralsKG;
    }

    public int getTotalBodyWater() {
        return totalBodyWater;
    }

    public void setTotalBodyWater(int totalBodyWater) {
        this.totalBodyWater = totalBodyWater;
    }

    public int getProteinKG() {
        return proteinKG;
    }

    public void setProteinKG(int proteinKG) {
        this.proteinKG = proteinKG;
    }

    public void displayInbody() {
        System.out.println("\n\t\tInbody's Details : " + "\n---------------------------------------------------------------\n"
                + "\n> Date : " + getDate() + "\n> Height (m) : " + getHeightM() + "\n> Total Weight (KG) : " + getTotalWeightKG() + "\n> Body Fat Mass (KG) : " + getBodyFatMassKG() + "\n> Minerals (KG): " + getMineralsKG()
                + "\n> Total Body Water : " + getTotalBodyWater() + "\n> Protein (KG) : " + "\n---------------------------------------------------------------\n");
    }

}

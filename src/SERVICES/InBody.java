package SERVICES;

public class InBody {
    protected int heightM;
    protected int totalWeightKG;
    protected  int bodyFatMassKG;
    protected int MineralsKG;
    protected int totalBodyWater;
    protected int proteinKG;
    //dateofinbody


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
}

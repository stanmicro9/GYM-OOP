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


    public void displayInbody() {
        System.out.println("\n\t\tInbody's Details : " + "\n---------------------------------------------------------------\n"
                + "\n> Date : " + getDate() + "\n> Height (m) : " + getHeightM() + "\n> Total Weight (KG) : " + getTotalWeightKG() + "\n> Body Fat Mass (KG) : " + getBodyFatMassKG() + "\n> Minerals (KG): " + getMineralsKG()
                + "\n> Total Body Water : " + getTotalBodyWater() + "\n> Protein (KG) : " + "\n---------------------------------------------------------------\n");
    }

}

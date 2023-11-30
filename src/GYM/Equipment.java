package GYM;

public class Equipment {
    public String equipName;
    protected int equipCode;
    protected int quantity=0;
    public Equipment(String equipName, int equipCode){
        this.equipName=equipName;
        this.equipCode=equipCode;
        quantity++;
    }
}

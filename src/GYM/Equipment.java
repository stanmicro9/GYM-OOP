package GYM;

public class Equipment {
    public String equipName;
    private int equipCode;
    private int quantity=0;
    public Equipment(String equipName, int equipCode){
        this.equipName=equipName;
        this.equipCode=equipCode;
        quantity++;
    }

    public int getEquipCode() {
        return equipCode;
    }

    public void setEquipCode(int equipCode) {
        this.equipCode = equipCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

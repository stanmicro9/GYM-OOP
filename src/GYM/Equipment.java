package GYM;

import USERS.Customer;
import java.util.ArrayList;

public class Equipment {
    public String equipName;
    protected int equipCode;
    protected int quantity;
    public Equipment(String equipName,int quantity, ArrayList<Equipment> equipmentList){
        this.equipName=equipName;
        equipCode=generateAutoEquipsCode(equipmentList);
        this.quantity=quantity;
    }
    public static int generateAutoEquipsCode(ArrayList<Equipment> equipmentlist) {
        while (true) {
            int autoECode = (int)(0 + Math.random() * 100);

            boolean idExists = false;
            for (Equipment e : equipmentlist) {
                if (e.getEquipCode() == autoECode) {
                    idExists = true;
                    break; //exit the loop since the ID already exists w yrg3 y-generate bc it's a while(true) loop
                }
            }

            if (!idExists) {
                return autoECode; //return the ID if it doesn't exist in the list
            }
        }
    }

    public int getEquipCode() {
        return equipCode;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }
    public void setEquipCode(int equipCode) {
        this.equipCode = equipCode;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //for admin
    void displayInfo(ArrayList<Equipment> equipmentList){
        for (Equipment equips: equipmentList){
            System.out.println("\n\t\tEQUIPMENTS DETAILS : " + "\n---------------------------------------------------------------\n"
                    + "\n> Name : " + equips.equipName +"\n> Code : " + equips.getEquipCode()+ "\n> Quantity : " + equips.getQuantity() +
                    "\n---------------------------------------------------------------\n");
        }
    }
    //for customer
    public static void displayEquipmentNames(ArrayList<Equipment> equipmentList) {
        System.out.println("\n\t\tEQUIPMENTS LIST : " + "\n---------------------------------------------------------------\n");
        for (Equipment equipment : equipmentList) {
            System.out.println(equipment.equipName);
        }
    }

    public static Equipment getEquipByCode(ArrayList<Equipment> equipmentList, int equcode){
        for (Equipment equips: equipmentList){
            if (equips.getEquipCode()==equcode)
                return equips;
        }
        return null;
    }
}

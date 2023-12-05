package GYM;

import USERS.Customer;
import java.util.ArrayList;

public class Equipment {
    public String equipName;
    protected int equipCode;
    protected int quantity=1;
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
    public  static Equipment getequipmentbycode(ArrayList<Equipment> equipmentList,int code) {
        for (Equipment equipment : equipmentList) {
            if (equipment.getEquipCode() == code) {
                return equipment;
            }
        }
        return null;
    }

    public int getEquipCode() {
        return equipCode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    String displayInfo(int ID){
        return "\n\t\tEQUIPMENTS DETAILS : " + "\n---------------------------------------------------------------\n"
                + "\n\n> Name : " + equipName + "\n\n> Code : " + getEquipCode() + "\n\n> Quantity : " + getQuantity() +
                 "\n---------------------------------------------------------------\n" ;
    }
    public void displayEquipmentNames(ArrayList<Equipment> equipmentList) {
        System.out.println("Equipment list for " + equipName + ":");
        for (Equipment equipment : equipmentList) {
            System.out.println(equipment.equipName);
        }
    }
}

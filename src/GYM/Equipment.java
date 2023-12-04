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

    //for admin
    void displayInfo(ArrayList<Equipment> equipmentList){
        for (Equipment equips: equipmentList){
            System.out.println("\n\t\tEQUIPMENTS DETAILS : " + "\n---------------------------------------------------------------\n"
                    + "\n> Name : " + equips.equipName +"\n> Code : " + equips.getEquipCode()+ "\n> Quantity : " + equips.getQuantity() +
                    "\n---------------------------------------------------------------\n");
        }
    }
    //for customer
    public void displayEquipmentNames(ArrayList<Equipment> equipmentList) {
        System.out.println("\n\t\tEQUIPMENTS LIST : " + "\n---------------------------------------------------------------\n");
        for (Equipment equipment : equipmentList) {
            System.out.println(equipment.equipName);
        }
    }
}

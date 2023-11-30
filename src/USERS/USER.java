package USERS;
import java.io.Serializable;
import java.util.Scanner;

import org.jetbrains.annotations.*;
public abstract class USER implements Serializable{
    private String address;
    private String email;
    private String pass;
    String name;
    char gender;
    private int phoneNO;

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public int getPhoneNO() {
        return phoneNO;
    }
    public void setPhoneNO(int phoneNO) {
        this.phoneNO = phoneNO;
    }


    public USER(String address, String email, String name, String pass, char gender, int phoneNO){
        this.address=address;
        this.email=email;
        this.name=name;
        this.pass=pass;
        this.gender=gender;
        this.phoneNO=phoneNO;

    }


    public abstract boolean login(String username, String password);

    //@NotNull to indicate that a parameter or return value of a method should not be null
    //it  is a way to provide additional information to tools and other developers about the expected behavior of our code
    //to validate name:
    public static boolean validateName(@NotNull String name){
        //static: to be able to call wherever I want without the need to create an instance of that class
        int count;

        if(name.length() > 30){
            return false;
        }
        //to track invalid characters
        count = 0;
        for(int i =0; i < name.length(); i++)	{
            if (!(Character.isLetter(name.charAt(i)) || name.charAt(i) == '.'  || name.charAt(i) == ' ')){
                count++;
                break;
            }
        }
        if (count != 0){
            return false;
        }
        return true;
    }

    //to validate phone number:
    public static boolean validatePhone(int contactNumber){
        //convert the integer to a string for further checks (3shan a3rf astkhdm .length() w .charAt())
        String contactNumberStr = Integer.toString(contactNumber);
        if (!((contactNumberStr.length() == 11 && contactNumberStr.charAt(0) == '0'
                && contactNumberStr.charAt(1) == '1') && (contactNumberStr.charAt(2) == '0' || contactNumberStr.charAt(2) == '1' ||
                contactNumberStr.charAt(2) == '2' || contactNumberStr.charAt(2) == '5'))){
            return false;
        }
        return true;
    }

    //to validate email:
    public static boolean validateEmail(@NotNull String email) {
        if (!email.endsWith(".com")) {
            return false;
        }
        int atIndex = email.indexOf('@');

        //check if @ is present and comes before the last dot
        if (atIndex == -1 || atIndex >= email.length() - 5) {
            return false;
        }

        //check if there is at least one character before @ and after it
        if (atIndex == 0 || atIndex == email.length() - 1) {
            return false;
        }
        return true;
    }

    //to validate a non-spaces password
    public static boolean validatePassword(@NotNull String password) {
        if (password.contains(" ")) {
            System.out.println("Password should not contain spaces.");
            return false;
        }
        return true;
    }


    //default 3shan de info visible lely f nfs el package bs
    abstract String displayInfo(int ID);

}

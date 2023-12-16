package USERS;
import java.io.Serializable;
import java.util.Scanner;

import GYM.GYM;
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


    public static USER login(String username, String password){
        for (USER user : GYM.userList) {
            if (user.getName().equals(username)){
                if (user.getPass().equals(password)) {
                    System.out.println("\nLogin successful!\n");
                    return user;
                }
            }
        }

        //msh 3rfa a3ml system clear :(
        System.out.println("\nLogin failed. Invalid username or password.\n");
        return null;
    }

    //@NotNull to indicate that a parameter or return value of a method should not be null
    //it  is a way to provide additional information to tools and other developers about the expected behavior of our code
    //to validate name:
    public static boolean validateName(@NotNull String regName){
        //static: to be able to call wherever I want without the need to create an instance of that class

        for (USER user : GYM.userList) {
            if (user.name.equals(regName)) {
                return false;
            }
        }

        if(regName.length() > 30){
            return false;
        }
        //to track invalid characters
        int count=0;

        for(int i =0; i < regName.length(); i++)	{
            if (!(Character.isLetter(regName.charAt(i)) || regName.charAt(i) == '.')){
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
    public static boolean validatePhone(int regNumber){
        //check for it
        //convert the integer to a string for further checks (3shan a3rf astkhdm .length() w .charAt())
        String contactNumberStr = Integer.toString(regNumber);
        for (USER user : GYM.userList) {
            if (user.pass.equals(regNumber)) {
                return false;
            }
        }
//        if (!((contactNumberStr.length() == 11 && contactNumberStr.charAt(0) == '0'
//                && contactNumberStr.charAt(1) == '1') && (contactNumberStr.charAt(2) == '0' || contactNumberStr.charAt(2) == '1' ||
//                contactNumberStr.charAt(2) == '2' || contactNumberStr.charAt(2) == '5'))){
//            return false;
//        }
        return true;
    }

    //to validate email:
    public static boolean validateEmail(@NotNull String regEmail) {

        for (USER user : GYM.userList) {
            if (user.email.equals(regEmail)) {
                return false;
            }
        }

        if (!regEmail.endsWith(".com")) {
            return false;
        }
        int atIndex = regEmail.indexOf('@');

        //check if @ is present and comes before the last dot
        if (atIndex == -1 || atIndex >= regEmail.length() - 5) {
            return false;
        }

        //check if there is at least one character before @ and after it
        if (atIndex == 0 || atIndex == regEmail.length() - 1) {
            return false;
        }
        return true;
    }

    //to validate a non-spaces password
    public static boolean validatePassword(@NotNull String password) {
        if (password.contains(" ")) {
            System.out.println("\n\nPassword should not contain spaces.\n\n");
            return false;
        }
        return true;
    }



    //default 3shan de info visible lely f nfs el package bs
    abstract String displayInfo();

}

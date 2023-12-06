package GYM;
import USERS.*;
import SERVICES.*;

import java.util.ArrayList;
import java.util.Scanner;

public class GYM {
    public String name="";
    public String address;
    public int phoneNumber;
  //  ArrayList<Coach> coachList = new ArrayList<>();
    private Subscription[] subs=new Subscription[50];

    public Subscription[] getSubs() {
        return subs;
    }

    public void setSubs(Subscription[] subs) {
        this.subs = subs;
    }
    //lists methods register w login
    //object mno fl main

    //pass ll array list, hnkhli el lists static
    //upcasting lists ll customer and coach
    //
    public static ArrayList<USER> userList = new ArrayList<>();
    public static ArrayList<Equipment> equipmentList = new ArrayList<>();

    public void regCustomer(ArrayList<USER> userList){
        Scanner input=new Scanner(System.in);

        System.out.println("\nEnter Your Name: ");
        String regName=input.next();
        System.out.println("\nEnter Your address: ");
        String regAddress=input.next();
        System.out.println("\nEnter Your Phone Number: ");
        int regNumber=input.nextInt();
        System.out.println("\nEnter Your gender (F/M): ");
        char regGender=input.next().charAt(0);
        System.out.println("\nEnter Your age: "); //mmkn tb2a list of ages ranging from 12 to 100 and he chooses
        int regAge=input.nextInt();
        System.out.println("\nEnter Your Email: ");
        String regEmail=input.next();
        System.out.println("\nEnter Your Password: ");
        String regPassword=input.next();
        input.close();

        if(USER.validateName(regName) && USER.validateEmail(regEmail) && USER.validatePhone(regNumber) && USER.validatePassword(regPassword))
        {
            USER u=new Customer(regAddress,regEmail,regName,regPassword,regGender,regNumber,regAge);
            userList.add(u);
            System.out.println("registered successfully");
        }
        else if(!USER.validateName(regName)){
            System.out.println("invalid name please register again");
        }
        else if(!USER.validateEmail(regEmail)){
            System.out.println("invalid email please register again");
        }
        else if(!USER.validatePhone(regNumber)){
            System.out.println("invalid number please register again");
        }
        else if(!USER.validatePassword(regPassword)){
            System.out.println("invalid password please register again");
        }
    }
    //pass ll array list, hnkhli el lists static
    //upcasting lists ll customer and coach
    //



    public void regCoach(ArrayList<USER> userList){
        Scanner input=new Scanner(System.in);

        System.out.println("\nEnter Your Name: ");
        String regName=input.next();
        System.out.println("\nEnter Your address: ");
        String regAddress=input.next();
        System.out.println("\nEnter Your Phone Number: ");
        int regNumber=input.nextInt();
        System.out.println("\nEnter Your gender (F/M): ");
        char regGender=input.next().charAt(0);
        System.out.println("\nEnter Your Working hours: "); //mmkn tb2a list of ages ranging from 12 to 100 and he chooses
        int regWorkingHr=input.nextInt();
        System.out.println("\nEnter Your Email: ");
        String regEmail=input.next();
        System.out.println("\nEnter Your Password: ");
        String regPassword=input.next();
        input.close();

        if(USER.validateName(regName) && USER.validateEmail(regEmail) && USER.validatePhone(regNumber) && USER.validatePassword(regPassword))
        {
            USER u=new Coach(regAddress,regEmail,regName,regPassword,regGender,regNumber,regWorkingHr);
            userList.add(u);
            System.out.println("registered successfully");
        }
        else if(!USER.validateName(regName)){
            System.out.println("invalid name please register again");
        }
        else if(!USER.validateEmail(regEmail)){
            System.out.println("invalid email please register again");
        }
        else if(!USER.validatePhone(regNumber)){
            System.out.println("invalid number please register again");
        }
        else if(!USER.validatePassword(regPassword)){
            System.out.println("invalid password please register again");
        }
    }
    //pass ll array list, hnkhli el lists static
    //upcasting lists ll customer and coach
    //

}
package GYM;
import USERS.*;
import SERVICES.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public static void regCustomer(){
        Scanner input=new Scanner(System.in);

        System.out.println("\nName: ");
        String regName=input.next();
        System.out.println("Address: ");
        String regAddress=input.next();
        System.out.println("Phone Number: ");
        int regNumber=input.nextInt();
        System.out.println("Gender (F/M): "); //radio button..?
        char regGender=input.next().charAt(0);
        System.out.println("Age: "); //mmkn tb2a list of ages ranging from 12 to 100 and he chooses
        int regAge=input.nextInt();
        System.out.println("Email: ");
        String regEmail=input.next();
        System.out.println("Password: ");
        String regPassword=input.next();
        input.close();

        if(USER.validateName(regName) && USER.validateEmail(regEmail) && USER.validatePhone(regNumber) && USER.validatePassword(regPassword))
        {
            Scanner subsInput=new Scanner(System.in);

            System.out.println("\n\nEnter Subscription and Plan Details\n");
            GYM.coachesList();
            System.out.println("Choose a coach ID to get assigned to: ");
            int assignedCoachID=subsInput.nextInt();
            System.out.println("Enter plan start date (yyyy-MM-dd): ");
            String inputStartDate = subsInput.next();
            // Define a DateTimeFormatter for the expected date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            try {
                Customer newCustomer=new Customer(regAddress,regEmail,regName,regPassword,regGender,regNumber);
                int chosenBundle=Membership_plan.planOptions();
                System.out.println("\nEnter the number of months (1-12): m7dsh ydkhal 13, mt2rfonash b2a");
                int chosenMonths=subsInput.nextInt();
                Membership_plan chosenPlan=new Membership_plan(inputStartDate, chosenBundle, chosenMonths);
                Subscription newSubs=new Subscription(newCustomer.getCustomerID(), assignedCoachID, chosenPlan);
                for (int i=0;i<12;i++){
                    if (newCustomer.getSubs()!=null){

                    }
                }

                userList.add(newCustomer);
                System.out.println("\nRegistered successfully!\n\n");

            } catch (Exception e) {
                System.out.println("\nInvalid date format. Please enter date in yyyy-MM-dd format and try again.\n\n");
            }
        }
        else if(!USER.validateName(regName)){
            System.out.println("\nInvalid name please register again.\nName must not contain special characters and nor exceed 29 characters in length.\n\n");
        }
        else if(!USER.validateEmail(regEmail)){
            System.out.println("\nInvalid, email registered before or not written correctly!\nPlease register again.\n\n");
        }
        else if(!USER.validatePhone(regNumber)){
            System.out.println("\nInvalid, phone number registered before or not written correctly!\n11 digits form is needed.\nPlease register again.\n\n");
        }
        else if(!USER.validatePassword(regPassword)){
            System.out.println("\nPassword shouldn't contain spaces.\nPlease register again.\n\n");
        }
    }

    public static void regCoach(){
        Scanner input=new Scanner(System.in);

        System.out.println("\nName: ");
        String regName=input.next();
        System.out.println("Address: ");
        String regAddress=input.next();
        System.out.println("Phone Number: ");
        int regNumber=input.nextInt();
        System.out.println("Gender (F/M): "); //radio button..?
        char regGender=input.next().charAt(0);
        System.out.println("Working hours (maximum 10): ");
        int regWorkingHr=input.nextInt();
        System.out.println("Email: ");
        String regEmail=input.next();
        System.out.println("Password: ");
        String regPassword=input.next();
        input.close();

        if(USER.validateName(regName) && USER.validateEmail(regEmail) && USER.validatePhone(regNumber) && USER.validatePassword(regPassword))
        {
            Coach newCoach=new Coach(regAddress,regEmail,regName,regPassword,regGender,regNumber,regWorkingHr);
            userList.add(newCoach);
            System.out.println("\nRegistered successfully!\n\n");
        }
        else if(!USER.validateName(regName)){
            System.out.println("\nInvalid name please register again.\nName must not contain special characters and nor exceed 29 characters in length.\n\n");
        }
        else if(!USER.validateEmail(regEmail)){
            System.out.println("\nInvalid, email registered before or not written correctly!\nPlease register again.\n\n");
        }
        else if(!USER.validatePhone(regNumber)){
            System.out.println("\nInvalid, phone number registered before or not written correctly!\n11 digits form is needed.\nPlease register again.\n\n");
        }
        else if(!USER.validatePassword(regPassword)){
            System.out.println("\nPassword shouldn't contain spaces.\nPlease register again.\n\n");
        }
    }

    public static void coachesList(){
        for (USER user : GYM.userList) {
            if (user instanceof Coach){
                System.out.println("Coach " + user.getName() + "\tID: " + ((Coach) user).getCoachID() + "\n");
            }
        }
        System.out.println("\n\n");
    }

}
package GYM;

import USERS.*;
import SERVICES.*;
import java.util.ArrayList;
import java.util.Scanner;
import USERS.Customer;

public class GYM {
    public String name="GYM EL MOR3BEEEN";
    public String address;
    public int phoneNumber;
    private static Subscription[] gymSubscriptions=new Subscription[100];

    public static Subscription[] getGymSubscriptions() {
        return gymSubscriptions;
    }

    public void setGymSubscriptions(Subscription[] gymSubscriptions) {
        this.gymSubscriptions = gymSubscriptions;
    }

    public static ArrayList<USER> userList = new ArrayList<>();
    public static ArrayList<Equipment> equipmentList = new ArrayList<>();

    public static Scanner input = new Scanner(System.in);
    public static void regCustomer(){
        System.out.println("\nName: ");
        String regName=input.nextLine();
        System.out.println("Address: ");
        String regAddress=input.nextLine();
        //--------------
        input.nextLine();
        //--------------
        System.out.println("Phone Number: ");
        int regNumber=input.nextInt();
        System.out.println("Gender (F/M): ");
        char regGender=input.next().charAt(0);
        System.out.println("Age: ");
        int regAge=input.nextInt();
        System.out.println("Email: ");
        String regEmail=input.next();
        System.out.println("Password: ");
        String regPassword=input.next();

        if(USER.validateName(regName) && USER.validateEmail(regEmail) && USER.validatePhone(regNumber) && USER.validatePassword(regPassword))
        {
            Customer newCustomer=new Customer(regAddress,regEmail,regName,regPassword,regGender,regNumber);
            userList.add(newCustomer);
            System.out.println("Registration complete");

        }
        else if(!USER.validateName(regName)){
            System.out.println("\nInvalid name please try again.\nName must not contain special characters and nor exceed 29 characters in length.\n");
        }
        else if(!USER.validateEmail(regEmail)){
            System.out.println("\nInvalid, email registered before or not written correctly!\nPlease try again.\n");
        }
        else if(!USER.validatePhone(regNumber)){
            System.out.println("\nInvalid, phone number registered before or not written correctly!\n11 digits form is needed.\nPlease try again.\n");
        }
        else if(!USER.validatePassword(regPassword)){
            System.out.println("\nPassword shouldn't contain spaces.\nPlease try again.\n");
        }

    } //shaklaha 7lww awyyyyy <3, proud of myself walahy

    public static void regCoach(){
        System.out.println("\nName: ");
        String regName=input.nextLine();
        input.nextLine();
        System.out.println("Address: ");
        String regAddress=input.nextLine();
        System.out.println("Phone Number: ");
        int regNumber=input.nextInt();
        System.out.println("Gender (F/M): ");
        char regGender=input.next().charAt(0);
        System.out.println("Age: ");
        int regAge=input.nextInt();
        System.out.println("Working hours (maximum 10): ");
        int regWorkingHr=input.nextInt();
        System.out.println("Email: ");
        String regEmail=input.next();
        System.out.println("Password: ");
        String regPassword=input.next();

        if(USER.validateName(regName) && USER.validateEmail(regEmail) && USER.validatePhone(regNumber) && USER.validatePassword(regPassword))
        {
            Coach newCoach=new Coach(regAddress,regEmail,regName,regPassword,regGender,regNumber,regWorkingHr);
            userList.add(newCoach);
            System.out.println("\nOperation Done Successfully!\n");

            //System.out.println(userList);
        }
        else if(!USER.validateName(regName)){
            System.out.println("\nInvalid name please try again.\nName must not contain special characters and nor exceed 29 characters in length.\n");
        }
        else if(!USER.validateEmail(regEmail)){
            System.out.println("\nInvalid, email registered before or not written correctly!\nPlease try again.\n");
        }
        else if(!USER.validatePhone(regNumber)){
            System.out.println("\nInvalid, phone number registered before or not written correctly!\n11 digits form is needed.\nPlease try again.\n");
        }
        else if(!USER.validatePassword(regPassword)){
            System.out.println("\nPassword shouldn't contain spaces.\nPlease try again.\n");
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

    public static int addCustomerToSpecificCoach(Customer Customer){
        int assignedCoachID;

        while (true){
            GYM.coachesList();
            System.out.println("\nChoose a coach ID to get assigned to: ");
            assignedCoachID=input.nextInt();
            Coach assignedCoach=Coach.getCoachByID(assignedCoachID);
            Customer[] customersArray = assignedCoach.getCustomersArray();
            for (int i=0;i<10;i++){
                if (customersArray[9]!=null) {
                    System.out.println("\nThis coach is full, choose another one and try again.\n");
                    break;
                }
                else if (customersArray[i]==null){
                    assignedCoach.setCustomersArray(i,Customer);
                    return assignedCoachID;
                }
            }
        }
    }

    public static void Subscription(Customer customer, String inputStartDate){
        int chosenCoachID=GYM.addCustomerToSpecificCoach(customer);
        int chosenBundle= Membership_plan.planOptions();
        System.out.println("\nEnter the number of months (1-12): m7dsh ydkhal 13, mt2rfonash b2a");
        int chosenMonths=input.nextInt();
        Membership_plan chosenPlan=new Membership_plan(inputStartDate, chosenBundle, chosenMonths);
        Subscription newSubs=new Subscription(customer.getCustomerID(), chosenCoachID, chosenPlan);
        customer.setSubs(newSubs);
    }

    public static void storeGymSubscriptions(){
        int subscriptionsCount = 0;
        for (USER user : GYM.userList) {
            if (user instanceof Customer) {
                Customer customer = (Customer) user;
                Subscription[] customerSubs = customer.getSubs();

                for (int i = 0; i < customerSubs.length; i++) {
                    if (subscriptionsCount < gymSubscriptions.length) {
                        gymSubscriptions[subscriptionsCount++] = customerSubs[i];
                    } else {
                        System.out.println("Gym subscriptions array is full. Cannot add more subscriptions to the system.");
                        break;
                    }
                }

            }
        }
    }


//de hya hyaha el subscription bs feha checker zyada for indexing, h7tagha? idk yet
//    public static void chosenSubscription(Customer customer, String inputStartDate){
//        Scanner subsInput=new Scanner(System.in);
//
//        int index=-1;
//
//        int chosenCoachID=GYM.addCustomerToSpecificCoach(customer);
//        for(int i=0;i<12;i++){
//            if(customer.subs[i+1]==null){
//                index=i;
//            }
//        }
//        customer.subs[index+1].setCoachID(chosenCoachID);
//
//        int chosenBundle= Membership_plan.planOptions();
//        System.out.println("\nEnter the number of months (1-12): m7dsh ydkhal 13, mt2rfonash b2a");
//        int chosenMonths=subsInput.nextInt();
//        Membership_plan chosenPlan=new Membership_plan(inputStartDate, chosenBundle, chosenMonths);
//        Subscription newSubs=new Subscription(customer.getCustomerID(), chosenCoachID, chosenPlan);
//        customer.setSubs(newSubs);
//
//        subsInput.close();
//
//    }
}

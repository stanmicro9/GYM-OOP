package USERS;

import DATABASE.GymDataBase;
import GYM.GYM;

import java.util.ArrayList;
import java.util.Scanner;

public class Coach extends USER {
    int workingHours;
    int coachID;
    Customer[] customersArray=new Customer[10];
    int customerCounter;
    public int getWorkingHrs() {
        return workingHours;
    }
    public void setWorkingHrs(int workingHours) { this.workingHours = workingHours; }
    public void setCoachID(int coachID) {
        this.coachID = coachID;
    }
    public int getCoachID() {
        return coachID;
    }

    public Coach(String address, String email, String name, String pass, char gender, int phoneNO,int workingHours){
        super(address, email, name, pass, gender, phoneNO);
        this.workingHours=workingHours;
        coachID=generateAutoIdForCoach();
    }
    public static int generateAutoIdForCoach() {
        while (true) {
            int autoCoachId = (int)(100 + Math.random() * 110);
            boolean idExists = false;

            for (USER user : GYM.userList) {
                if (user instanceof Coach) {
                    Coach coach = (Coach) user; //downcasting
                    if (coach.getCoachID() == autoCoachId) {
                        idExists = true;
                        break; //exit the loop since the ID already exists w yrg3 y-generate bc it's a while(true) loop
                    }
                }
            }
            if (!idExists) {
                return autoCoachId; //return the ID if it doesn't exist in the list
            }
        }
    }

    public void ListOfCustomers() {
        System.out.println("\nCustomers for Coach " + name + " :\n");
        for (int i = 0; i < 10; i++) {
            if (customersArray[i]!=null){
                System.out.println("- " + customersArray[i].getName() + "\t" + customersArray[i].getCustomerID() + "\n");
            }
        }
    } /*checked*/
    public static Coach getCoachByID(int coachId) {
        for (USER user : GYM.userList) {
            if (user instanceof Coach) {
                Coach coach = (Coach) user; //downcasting
                if (coach.getCoachID()==(coachId)) {
                    return coach; // Return the coach if ID matches
                }
            }
        }
        return null; // Return null if coach with given ID is not found
    }
    //default 3shan de info lely f nfs el package bs
    @Override
    String displayInfo(){
        return "\n\t\tCoach's Details : " + "\n---------------------------------------------------------------\n"
                + "\n\n> Id : " + getCoachID() + "\n\n> Email : " + getEmail() + "\n\n> Name : " + getName() + "\n\n> Gender : " + getGender()
                + "\n\n> Phone Number : " + getPhoneNO() + "\n\n> Working Hours : " + workingHours +"\n---------------------------------------------------------------\n" ;
    } /*checked*/
    public String searchCustomerByName(String customerName){
        for (int i=0; i<10;i++){ //to check if the typed name is HIS customer or not
            if(customersArray[i].getName().equals(customerName)) {
                Customer customer = Customer.getCustomerByName(customerName);
                if (customer != null) {
                    return customer.displayInfo();
                }
                else return "\n\nCustomer with name " + customerName + " was not found in gym, please enter correct name\n\n";
            }
        }
        return "\n\nThis Customer is not a listed one of yours.\n\n";
    } /*checked*/
    public void displayFMCustomer() {
        if (customersArray[0]!=null){
            System.out.println("\nHere's your female customers list:\n\n");
            for (int i=0;i<10;i++) {
                if (customersArray[i].getGender() == 'F') {
                    System.out.println(customersArray[i].getName() + "\n");
                }
                else continue;
            }
            System.out.println("Here's your male customers list:\n\n");
            for (int i=0;i<10;i++) {
                if (customersArray[i].getGender() == 'M') {
                    System.out.println(customersArray[i].getName() + "\n");
                }
                else continue;
            }
        }
        else System.out.println("\nYou don't have customer's registered to your account.\n");
    } /*checked*/

    //for one of HIS customerS
    public void displayCustomersInbodyHistory(int customerID) {
        if (customersArray[0]!=null){ //exception handling?
            for (int i=0; i<10; i++) {
                if (customersArray[i].getCustomerID()==(customerID)){
                    System.out.println("Inbody History of Customer: " + customersArray[i].getName() + "\n\n");
                    if (customersArray[i].inbodies[0] != null) {
                        for (int j = 0; customersArray[i].inbodies[j] != null; j++) {
                            customersArray[i].inbodies[j].displayInbody();
                        }
                    } else System.out.println("This customer hasn't done any inbodies yet.");
                }
            }
        }
        else System.out.println("\nThere are no customers registered to your account.\n");
    } /*checked*/

    @Override
    public boolean login(String username, String password){
        for (USER user : GYM.userList) {
            if (user instanceof Coach) {
                Coach coach = (Coach) user; //downcasting
                if (coach.getName().equals(username)){
                    if (coach.getPass().equals(password)) {
                        System.out.println("\nLogin successful!\n");
                        return true;
                    }
                }
            }
        }
        //msh 3rfa a3ml system clear :(
        System.out.println("\nLogin failed. Invalid username or password.\n");
        return false;
    } /*checked*/

    public void CoachMainMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do{
            System.out.println("\n\t You logged in successfully !\t\n\n");
            System.out.println("Main Menu\n\n");
            System.out.println("1. List of your customers\n");
            System.out.println("2. Inbody history for a customer\n");
            System.out.println("3. Details of a specific customer\n");
            System.out.println("4. list of your female/male customers\n");
            System.out.println("5. Exit\n\n");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            Scanner input = new Scanner(System.in);


            switch (choice) {
                case 1:
                    System.out.println("\nYour customers: \n");
                    ListOfCustomers();
                    //method to get back ely hwa press kaza to go back


                    break;
                case 2:
                    System.out.println("\nInbody history for a customer: \n");
                    ListOfCustomers();
                    System.out.println("Enter the customer ID for an InBody history: ");
                    int chosenCustomerID = input.nextInt();
                    displayCustomersInbodyHistory(chosenCustomerID);
                    //method

                    break;
                case 3:
                    System.out.println("Details of customer: \n");
                    System.out.println("Please enter the customer name: "); //+validate
                    String chosenCustomerName=input.next();
                   // searchCustomerByName(customerList,chosenCustomerName); //hnsheel el list asln
                    //method

                    break;
                case 4:
                    System.out.println("The list of female/male customers: \n");
                    displayFMCustomer();
                    //method

                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 5); //y3ni eh?

        scanner.close();

    }

    public String displayInfoForCustomer(){
        return "\n\t\tYour Coach's Details : " + "\n---------------------------------------------------------------\n" + "\n\n> Name : " + getName() + "\n\n> Phone Number : " + getPhoneNO() + "\n\n> Working Hours : " + getWorkingHrs() +"\n---------------------------------------------------------------\n" ;

    }
}

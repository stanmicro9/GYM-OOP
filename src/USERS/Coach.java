package USERS;

import GYM.GYM;
import java.io.Serializable;
import static GYM.GYM.input;

public class Coach extends USER implements Serializable {
    int workingHours;
    int coachID;
    Customer[] customersArray=new Customer[10];
    int customerCounter; //for the method of sorting coaches in Admin class

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

    public void setCustomersArray(int index,Customer customer) {
        customersArray[index] =customer ;
    }

    public Customer[] getCustomersArray() {
        return customersArray;
    }

    public Coach(String address, String email, String name, String pass, char gender, int phoneNO, int workingHours){
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
    } //checked

    public void ListOfCustomers() {
        System.out.println("\nCustomers for Coach " + name + " :\n");
        for (int i = 0; i < 10; i++) {
            if (customersArray[i]!=null){
                System.out.println("- " + customersArray[i].getName() + "\t" + customersArray[i].getCustomerID() + "\n");
            }
        }
        System.out.println("Press enter to continue.....");
        input.nextLine();
    } //checked
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
    } //checked
    //default 3shan de info lely f nfs el package bs
    @Override
    void displayInfo(){
        System.out.println("\n\t\tCoach's Details : " + "\n---------------------------------------------------------------\n"
                + "\n\n> Id : " + getCoachID() + "\n\n> Email : " + getEmail() + "\n\n> Name : " + getName() + "\n\n> Gender : " + getGender()
                + "\n\n> Phone Number : " + getPhoneNO() + "\n\n> Working Hours : " + workingHours +"\n---------------------------------------------------------------\n");
    } //checked
    public void searchCustomerByName(String customerName){
        for (int i=0; i<10;i++){ //to check if the typed name is HIS customer or not
            if(customersArray[i].getName().equals(customerName)) {
                Customer customer = getCustomerByName(customerName);
                if (customer != null) {
                    customer.displayInfo();
                }
                else System.out.println("\n\nCustomer with name " + customerName + " was not found in gym, please enter correct name\n\n");
                break;
            }
        }
        System.out.println("\n\nThis Customer is not a listed one of yours.\n\n");
    } //checked
    public void displayFMCustomer() {
        if (customersArray[0]!=null){
            System.out.println("\nHere's your female customers list:");
            for (int i=0;i<customersArray.length;i++) {
                if (customersArray[i]!=null){
                    if (customersArray[i].getGender() == 'F' || customersArray[i].getGender() == 'f') {
                        System.out.println(customersArray[i].getName());
                    }
                    else continue;
                }
            }
            System.out.println("Here's your male customers list:");
            for (int i=0;i<10;i++) {
                if (customersArray[i]!=null){
                    if (customersArray[i].getGender() == 'M' || customersArray[i].getGender() == 'm') {
                        System.out.println(customersArray[i].getName() + "\n");
                    }
                    else continue;
                }
            }
        }
        else System.out.println("\nYou don't have customer's registered to your account.\n");
    } //checked

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
                    break;
                }
            }
        }
        else System.out.println("\nThere are no customers registered to your account.\n");
    } //checked

    public void CoachMainMenu(){
        System.out.println("\t You logged in successfully !\t");
        int choice;

        do{
            System.out.println("Main Menu\n...........");
            System.out.println("1. List of your customers");
            System.out.println("2. InBody history for a customer");
            System.out.println("3. Details of a specific customer");
            System.out.println("4. list of your female/male customers");
            System.out.println("5. Exit\n");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();


            switch (choice) {
                case 1:
                    System.out.println("Your customers:");
                    ListOfCustomers();
                    break;
                case 2:
                    System.out.println("InBody history for a customer:");
                    ListOfCustomers();
                    System.out.println("Enter the customer ID for an InBody history: ");
                    int chosenCustomerID = input.nextInt();
                    displayCustomersInbodyHistory(chosenCustomerID);
                    break;
                case 3:
                    System.out.println("Details of customer: ");
                    ListOfCustomers();
                    System.out.println("Please enter the customer name: "); //+validate
                    String chosenCustomerName=input.next();
                    searchCustomerByName(chosenCustomerName);
                    break;
                case 4:
                    System.out.println("The list of female/male customers:\n.........................");
                    displayFMCustomer();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 5);

    }//checked

    public void displayInfoForCustomer(){
        System.out.println("\n\t\tYour Coach's Details : " + "\n---------------------------------------------------------------\n" + "\n\n> " +
                "Name : " + getName() + "\n\n> Phone Number : " + getPhoneNO() +
                "\n\n> Working Hours : " + getWorkingHrs() +"\n---------------------------------------------------------------\n");

    } //checked

    public static Customer getCustomerByName(String name) {
        for (USER user : GYM.userList) {
            if (user instanceof Customer) {
                Customer customer = (Customer) user; //downcasting
                if (customer.getName().equals(name)) {
                    return customer; // Return the coach if ID matches
                }
            }
        }
        return null;
    } //checked
}

package USERS;

import java.util.ArrayList;

public class Coach extends USER {
    int workingHours;
    int coachID;
    Customer[] customersArray=new Customer[10];


    public void ListOfCustomers() {
        System.out.println("Customers for Coach " + name + ":");
        for (int i = 0; i < 10; i++) {
            System.out.println("- " + customersArray[i].getName());
        }
    }

    public void displayFMCustomer(ArrayList<Customer>customerList){
        for(Customer customer : customerList){
            if(customer.getGender()=='F'){
                System.out.println("Here's the coach's female customers list:");
                System.out.println(customer.getName());
            }
            else if(customer.getGender()=='M'){
                System.out.println("Here's the coach's male customers list:");
                System.out.println(customer.getName());
            }
        }
    }

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

    public Coach(String address, String email, String name, String pass, char gender, int phoneNO,int workingHours, ArrayList<Coach> coachlist){
        super(address, email, name, pass, gender, phoneNO);
        this.workingHours=workingHours;
        coachID=generateAutoIdForCoach(coachlist);
    }
    public static int generateAutoIdForCoach(ArrayList<Coach> coachlist) {
        while (true) {
            int autoCoachId = (int)(100 + Math.random() * 110);

            boolean idExists = false;
            for (Coach c : coachlist) {
                if (c.getCoachID() == autoCoachId) {
                    idExists = true;
                    break; //exit the loop since the ID already exists w yrg3 y-generate bc it's a while(true) loop
                }
            }

            if (!idExists) {
                return autoCoachId; //return the ID if it doesn't exist in the list
            }
        }
    }


    public static Coach getCoachByID(ArrayList<Coach> coachList, int coachId) {
        for (Coach coach : coachList) {
            if (coach.getCoachID() == coachId) {
                return coach; // Return the coach if ID matches
            }
        }
        return null; // Return null if coach with given ID is not found
    }
    //default 3shan de info lely f nfs el package bs
    @Override
    String displayInfo(String name){
        return "\n\t\tCoach's Details : " + "\n---------------------------------------------------------------\n"
                + "\n\n> Id : " + getCoachID() + "\n\n> Email : " + getEmail() + "\n\n> Name : " + getName() + "\n\n> Gender : " + getGender()
                + "\n\n> Phone Number : " + getPhoneNO() + "\n\n> Working Hours : " + workingHours +"\n---------------------------------------------------------------\n" ;
    }
    public String searchCustomerByName(ArrayList<Customer> customerList,String customerName){
        for (int i=0; i<10;i++){ //to check if the typed name is HIS customer or not
            if(customersArray[i].getName().equals(customerName)) {
                Customer customer = Customer.getCustomerByName(customerList, customerName);
                if (customer != null) {
                    return customer.displayInfo(customerName);
                }
                else return "\n\nCustomer with name " + customerName + " was not found in gym, please enter correct name\n\n";
            }
        }
        return "\n\nThis Customer is not a listed one of yours.\n\n";
    }

    @Override
    public boolean login(String username, String password){

        return false;
    }
}

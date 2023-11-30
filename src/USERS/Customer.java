package USERS;
import SERVICES.*;
import java.util.ArrayList;
public class Customer extends USER {

    ArrayList<InBody> inbodies;
    ArrayList<Subscription> subscriptions;

    private int age;
    private static int counter=0;
    private int customerID;
    public Customer(String address, String email, String name, String pass, char gender, int phoneNO,int age){
        super(address, email, name, pass, gender, phoneNO);
        counter++;
        customerID=counter;
        this.age=age;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void displayInfo(int ID){
        System.out.println("Customer's ID: "+getCustomerID());
        System.out.println("Customer's address: "+ getAddress());
        System.out.println("Customer's email: "+ getEmail());
        System.out.println("Customer's name: "+ getName());
        System.out.println("Customer's password: "+ getPass());
        System.out.println("Customer's gender: "+ getGender());
        System.out.println("Customer's phone number: "+ getPhoneNO());
    }
    //overridden
    public boolean login(String username, String password){
        return false;
    }
}

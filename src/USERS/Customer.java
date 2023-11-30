package USERS;
import java.util.ArrayList;
import DATABASE.*;
import SERVICES.InBody;
import SERVICES.Subscription;
public class Customer extends USER {

    InBody[] inbodies= new InBody[50];
    Subscription[] subs=new Subscription[50];
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
        String fileName = "CUSTOMER";
        ArrayList<Customer> customerList = GymDataBase.loadData(fileName);

        for (Customer c : customerList) {
            if (c.getName().equals(username) && c.getCustomerID().equals(password)) {
                System.out.println("Login successful!");
                return true;
            }
        }


        System.out.println("Login failed. Invalid username or password.");
        return false;
    }

    }


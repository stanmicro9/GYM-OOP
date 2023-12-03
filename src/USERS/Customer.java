package USERS;

import DATABASE.GymDataBase;
import SERVICES.InBody;
import SERVICES.Subscription;

import java.util.ArrayList;
public class Customer extends USER {

    InBody[] inbodies= new InBody[12];//12 nfs fkrt el subscription
    Subscription[] subs=new Subscription[12]; //lih eshtrak sana, w b3d kda el admin hyfdy el array w ybda2 mn el awl, to calculate income properly
    private int age;
    private int customerID;
    public Customer(String address, String email, String name, String pass, char gender, int phoneNO,int age,ArrayList<Customer> customerList){
        super(address, email, name, pass, gender, phoneNO);
        customerID=generateAutoIdForCustomer(customerList);
        this.age=age;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public int generateAutoIdForCustomer(ArrayList<Customer> customerlist) {
        while (true) {
            int autoCusId = (int)(10000 + Math.random() * 11000);

            boolean idExists = false;
            for (Customer C : customerlist) {
                if (C.getCustomerID() == autoCusId) {
                    idExists = true;
                    break; //exit the loop since the ID already exists w yrg3 y-generate bc it's a while(true) loop
                }
            }

            if (!idExists) {
                return autoCusId; //return the ID if it doesn't exist in the list
            }
        }
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    //default 3shan de info lely f nfs el package bs
    String displayInfo(String name){
        return "\n\t\tCustomer's Details : " + "\n---------------------------------------------------------------\n"
                + "\n\n> Id : " + getCustomerID() + "\n\n> Email : " + getEmail() + "\n\n> Name : " + getName() + "\n\n> Gender : " + getGender()
                + "\n\n> Phone Number : " + getPhoneNO()  +"\n---------------------------------------------------------------\n" ;
    }

    //by ID de bta3t eh?
    public static Customer getCustomerById( ArrayList<Customer> customerList,int id) {
        for (Customer customer : customerList) {
            if (customer.getCustomerID() == id) {
                return customer;
            }
        }
        return null;
    }
    public static Customer getCustomerByName(ArrayList<Customer> customerList,String name) {
        for (Customer customer : customerList) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }
    @Override
    public boolean login(String username, String password){
        String fileName = "CUSTOMER";
        ArrayList<Customer> customerList = GymDataBase.loadData(fileName);

        for (Customer c : customerList) {
            if (c.getName().equals(username))
                if (c.getPass().equals(password)) {
                    System.out.println("\nLogin successful!\n");
                    return true;
                }
        }
        //msh 3rfa a3ml system clear :(
        System.out.println("\nLogin failed. Invalid username or password.\n");
        return false;
    }

}


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

    //default 3shan de info lely f nfs el package bs
    String displayInfo(int ID){
        return "\n\t\tCoach's Details : " + "\n---------------------------------------------------------------\n"
                + "\n\n> Id : " + getCustomerID() + "\n\n> Email : " + getEmail() + "\n\n> Name : " + getName() + "\n\n> Gender : " + getGender()
                + "\n\n> Phone Number : " + getPhoneNO()  +"\n---------------------------------------------------------------\n" ;
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


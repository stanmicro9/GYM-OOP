package USERS;

import DATABASE.GymDataBase;
import SERVICES.InBody;
import SERVICES.Subscription;

import java.util.ArrayList;
import java.util.Scanner;

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

    public void CustomerMainMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do{
            System.out.println(" You logged in successfully !");
            System.out.println(" Main Menu");
            System.out.println("1. Your coach's information ");
            System.out.println("2. Display all gym equipments  ");
            System.out.println("3. Membership plan details ");
            System.out.println("4. Inbody info at specific date");
            System.out.println("5. Kilos to be reduced");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    System.out.println("Your coach's information: \n");
                    //coach info method
                    break;
                case 2:
                    System.out.println("Gym equipments: \n");
                    // gym equip method
                    break;
                case 3:
                    System.out.println("Your membership plan: \n");
                    // plan details method
                    break;
                case 4:
                    System.out.println("Your inbody info: \n");
                    // inbody info method
                    break;
                case 5:
                    System.out.println("Kilos to be reduced: \n");
                    // kilo to reduce method
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 6);

        scanner.close();

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

    public void displayCustomersInbodyHistory(ArrayList<Customer> customerList) {
        System.out.println("\nPlease enter the customer's id: ");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        Customer specificCustomer = Customer.getCustomerById(customerList, id);
        System.out.println("Inbody History of Customers:");

        for (Customer customer : customerList) {
            if (customer != null && customer.getCoachID() == coachID) {
                System.out.println("Customer ID: " + customer.getCustomerId());
                System.out.println("Inbody History: " + customer.getInbodyHistory());
                System.out.println("------------------------------------");
            }
}
}

    public void displayInbodyBYDate(InBody[] inBody,String Date) {
        for (int i = 0; i < 12; i++) {
            if (inBody[i].equals(Date)) {
                inBody[i].displayInbody();
            } else {
                System.out.println("Invalid Date");
            }
        }

    }
}


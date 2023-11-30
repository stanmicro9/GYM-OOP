package USERS;
import MAIN.*;
import GYM.Equipment;
import java.util.*;
import DATABASE.*;
import java.io.Serializable;
public class Admin  implements Serializable{
    private String username="admin";
    private String pass="admin";

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }
    public  void AdminMainMenu(Admin admin,ArrayList<Customer>customerList,ArrayList<Coach> coachlist,ArrayList<Equipment> equips) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do{
            System.out.println("logged in !");
            System.out.println("Admin Main Menu");
            System.out.println("1. Add ");
            System.out.println("2. Remove ");
            System.out.println("3. edit ");
            System.out.println("4. View Customers subscription"); //hya5od id el customer w ytl3 el subs bta3o
            System.out.println("5. View subscriptions //in a day or month");
            System.out.println("6. View a coach's customer"); //hayd5ol 3nd coach mo3yn yshof el customers bto3o
            System.out.println("7. View gym's income"); //in a month
            System.out.println("8. View coaches"); //sorted 3la 7sb 3adad el customers 3nd kol coach
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.println("Adding User...");
                    admin.addCustomer(customerList);

                    break;
                case 2:
                    System.out.println("Removing User...");
                    // Remove user logic goes here
                    break;
                case 3:
                    System.out.println("Viewing Users...");
                    // View users logic goes here
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 9);

        // Close the scanner to prevent resource leak
        scanner.close();
    }


    public boolean adminLogin(String name, String password){
        boolean loginSuccessful = false;
        if(name.equals(username)){
            if(password.equals(pass)){
                loginSuccessful= true;
            }
        }
        return loginSuccessful;
    }


    public void addCoach(ArrayList<Coach> coachlist){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter USERS.Coach's address: ");
        String Caddress=input.next();
        System.out.println("Enter USERS.Coach's email: ");
        String Cemail=input.next();
        System.out.println("Enter USERS.Coach's pass: ");
        String Cpass=input.next();
        System.out.println("Enter USERS.Coach's name: ");
        String Cname=input.next();
        System.out.println("Enter USERS.Coach's gender (F/M): ");
        char Cgender=input.next().charAt(0);
        System.out.println("Enter USERS.Coach's phone number: ");
        int CphoneNo=input.nextInt();
        System.out.println("Enter USERS.Coach's working hours (max 10): ");
        int CworkingHours=input.nextInt();
        input.close();

        Coach newCoach=new Coach(Caddress,Cemail,Cpass,Cname,Cgender,CphoneNo,CworkingHours);
        coachlist.add(newCoach);
        GymDataBase.saveData(coachlist, "COACHES");

    }
    public void addCustomer(ArrayList<Customer>customerList){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter USERS.Customer's address: ");
        String CusAddress=input.next();
        System.out.println("Enter USERS.Customer's email: ");
        String CusEmail=input.next();
        System.out.println("Enter USERS.Customer's pass: ");
        String CusPass=input.next();
        System.out.println("Enter USERS.Customer's name: ");
        String CusName=input.next();
        System.out.println("Enter USERS.Customer's gender (F/M): ");
        char CusGender=input.next().charAt(0);
        System.out.println("Enter USERS.Customer's phone number: ");
        int CusPhoneNo=input.nextInt();
        System.out.println("Enter USERS.Customer's age: ");
        int CusAge=input.nextInt();
        input.close();

        Customer c=new Customer(CusAddress,CusEmail,CusPass,CusName,CusGender,CusPhoneNo,CusAge);
        customerList.add(c);
        GymDataBase.saveData(customerList, "CUSTOMERS");


    }
    public void addEquip( ArrayList<Equipment> equips){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter equipment's name: ");
        String newEquipName=input.next();
        System.out.println("Enter equipment's code: ");
        int newEquipCode=input.nextInt();
        input.close();

        Equipment newEquipment=new Equipment(newEquipName,newEquipCode);
        equips.add(newEquipment);
        //f array wla file?
    }
    public void editCoach(int coachID){
        System.out.println("Please enter your id: ");
        Scanner input=new Scanner(System.in);
        int id= input.nextInt();
        if(id != Coach.coachID) {
            System.out.println("Invalid coach ID.");
            return;
        }
        System.out.println("Choose an attribute to edit:");
        System.out.println("1. Address");
        System.out.println("2. E-mail");
        System.out.println("3. Name");
        System.out.println("4. Password");
        System.out.println("5. Gender");
        System.out.println("6. Phone number");
        System.out.println("7. Working Hours");
        System.out.println("Enter your choice:");

        int choice = input.nextInt();
        input.nextLine(); // Consume newline character
        Coach c= new Coach("nozha","mariamsuperman@gmail.com","mariam","basbousa", 'f',010,8);

        switch (choice) {
            case 1:
                System.out.println("Enter new address:");
                String newAddress = input.nextLine();
                c.setAddress(newAddress);
                System.out.println("Address updated successfully.");
                break;
            case 2:
                System.out.println("Enter new email:");
                String newEmail = input.nextLine();
                c.setEmail(newEmail);
                System.out.println("Email updated successfully.");
                break;
            case 3:
                System.out.println("Enter new name:");
                String newName = input.nextLine();
                c.setName(newName);
                System.out.println("Name updated successfully.");
                break;
            case 4:
                System.out.println("Enter new password:");
                String newPassword = input.nextLine();
                c.setPass(newPassword);
                System.out.println("Password updated successfully.");
                break;
            case 5:
                System.out.println("Enter new gender:");
                char newGender = input.next().charAt(0);
                c.setGender(newGender);
                System.out.println("Gender updated successfully.");
                break;
            case 6:
                System.out.println("Enter new phone number:");
                int newPhonenum = input.nextInt();
                c.setPhoneNO(newPhonenum);
                System.out.println("Phone number updated successfully.");
                break;
            case 7:
                System.out.println("Enter new working hours:");
                int newWorkinghours = input.nextInt();
                c.setWorkingHrs(newWorkinghours);
                System.out.println("Phone number updated successfully.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    public void editCustomer(int customerID){

    }
    public void editEquip(int EquipCode){

    }
    public void deleteCoach(){

    }
    public void deleteCustomer(){

    }
    public void deleteEquip(){

    }

}

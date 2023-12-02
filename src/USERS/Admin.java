package USERS;
import GYM.GYM;
import MAIN.*;
import GYM.Equipment;
import java.util.*;
import DATABASE.*;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
public class Admin  implements Serializable{
    private String username;
    private String pass;
    //ely hyghyrhum hdrbo
    public Admin() {
        username="admin";
        pass="admin";
    }

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

    //@NotNull to indicate that a parameter or return value of a method should not be null
    //it  is a way to provide additional information to tools and other developers about the expected behavior of our code
    public boolean adminLogin(@NotNull String name, String password){
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
        System.out.println("\nEnter Coach's address: ");
        String Caddress=input.next();
        System.out.println("\nEnter Coach's email: ");
        String Cemail=input.next();
        System.out.println("\nEnter Coach's pass: ");
        String Cpass=input.next();
        System.out.println("\nEnter Coach's name: ");
        String Cname=input.next();
        System.out.println("\nEnter Coach's gender (F/M): ");
        char Cgender=input.next().charAt(0);
        System.out.println("\nEnter Coach's phone number: ");
        int CphoneNo=input.nextInt();
        System.out.println("\nEnter Coach's working hours (max 10): ");
        int CworkingHours=input.nextInt();
        input.close();

        Coach newCoach=new Coach(Caddress,Cemail,Cpass,Cname,Cgender,CphoneNo,CworkingHours,coachlist);
        coachlist.add(newCoach);
        GymDataBase.saveData(coachlist, "COACHES");

    }
    //lesa 3leha shwyt updates 3shan 7war el return
    public static void addCustomer(ArrayList<Customer>customerList){ //static 3shan htt7t fl customer's register
        Scanner input=new Scanner(System.in);

        System.out.println("\nEnter Customer's address: ");
        String CusAddress=input.next();
        System.out.println("\nEnter Customer's email: ");
        String CusEmail=input.next();
        boolean validE=USER.validateEmail(CusEmail);
        if (!validE) return;
        System.out.println("\nEnter Customer's pass: ");
        String CusPass=input.next();
        boolean validP=USER.validatePassword(CusPass);
        if (!validP) return;
        System.out.println("\nEnter Customer's name: ");
        String CusName=input.next();
        boolean validN=USER.validateName(CusName);
        if (!validN) return;
        System.out.println("\nEnter Customer's gender (F/M): ");
        char CusGender=input.next().charAt(0);
        System.out.println("\nEnter Customer's phone number: ");
        int CusPhoneNo=input.nextInt();
        boolean validPN=USER.validatePhone(CusPhoneNo);
        if (!validPN) return;
        System.out.println("\nEnter Customer's age: "); //mmkn tb2a list of ages ranging from 12 to 100 and he chooses
        int CusAge=input.nextInt();
        input.close();

        Customer c=new Customer(CusAddress,CusEmail,CusPass,CusName,CusGender,CusPhoneNo,CusAge,customerList);
        customerList.add(c);
        GymDataBase.saveData(customerList, "CUSTOMERS");
    }
    public void addEquip(ArrayList<Equipment> equips){ //equipmentList
        Scanner input=new Scanner(System.in);
        System.out.println("Enter equipment's name: ");
        String newEquipName=input.next();
        System.out.println("Enter equipment's code: ");
        int newEquipCode=input.nextInt();
        input.close();

        Equipment newEquipment=new Equipment(newEquipName,newEquipCode,equips);
        equips.add(newEquipment);
        GymDataBase.saveData(equips, "EQUIPMENTS");
    }

    public void editCoach(ArrayList<Coach> coachList,int coachID){
        System.out.println("Please enter your id: ");
        Scanner input=new Scanner(System.in);
        int id= input.nextInt();
        Coach specificCoach = Coach.getCoachByID(coachList,coachID);
        if (specificCoach != null) {
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

            switch (choice) {
                case 1:
                    System.out.println("Enter new address:");
                    String newAddress = input.nextLine();
                    specificCoach.setAddress(newAddress);
                    System.out.println("Address updated successfully.");
                    break;
                case 2:
                    System.out.println("Enter new email:");
                    String newEmail = input.nextLine();
                    specificCoach.setEmail(newEmail);
                    System.out.println("Email updated successfully.");
                    break;
                case 3:
                    System.out.println("Enter new name:");
                    String newName = input.nextLine();
                    specificCoach.setName(newName);
                    System.out.println("Name updated successfully.");
                    break;
                case 4:
                    System.out.println("Enter new password:");
                    String newPassword = input.nextLine();
                    specificCoach.setPass(newPassword);
                    System.out.println("Password updated successfully.");
                    break;
                case 5:
                    System.out.println("Enter new gender:");
                    char newGender = input.next().charAt(0);
                    specificCoach.setGender(newGender);
                    System.out.println("Gender updated successfully.");
                    break;
                case 6:
                    System.out.println("Enter new phone number:");
                    int newPhonenum = input.nextInt();
                    specificCoach.setPhoneNO(newPhonenum);
                    System.out.println("Phone number updated successfully.");
                    break;
                case 7:
                    System.out.println("Enter new working hours:");
                    int newWorkinghours = input.nextInt();
                    specificCoach.setWorkingHrs(newWorkinghours);
                    System.out.println("Phone number updated successfully.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        else System.out.println("Invalid email or password ");
    }
    public void editCustomer(int customerID){

    }
    public void editEquip(int EquipCode){

    }

    public String deleteCoach(@NotNull ArrayList<Coach> coachlist, int coachID){
        for(Coach c: coachlist){
            if(coachID == c.getCoachID()){
                coachlist.remove(c);
                return "\n\nCoach's -with ID "+ coachID+"- Data Removed\n\n";
            }
        }
        return "\n\nCoach with ID " + coachID + " was not found in gym.\n\n";
    }
    public String  deleteCustomer(@NotNull ArrayList<Customer> customerList, int customerID){
        for(Customer C: customerList){
            if(customerID == C.getCustomerID()){
                customerList.remove(C);
                return "\n\nCustomer's -with ID "+ customerID+"- Data Removed\n\n";
            }
        }
        return "\n\nCustomer with ID " + customerID + " was not found in gym.\n\n";
    }

    public String  deleteEquip(@NotNull ArrayList<Equipment> equipmentList, int equipCode){
        for(Equipment e: equipmentList){
            if(equipCode == e.getEquipCode()){
                equipmentList.remove(e);
                return "\n\nEquipment's -with ID "+ equipCode+"- Data Removed\n\n";
            }
        }
        return "\n\nEquipment with code " + equipCode + " was not found in gym.\n\n";
    }

}

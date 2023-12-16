package USERS;
import GYM.*;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import DATABASE.*;
import SERVICES.*;
import java.time.LocalDate;
import org.jetbrains.annotations.NotNull;
import java.time.Month; //fl gymIncome method
import java.io.Serializable;
import static GYM.GYM.input;
public class Admin  implements Serializable{
    private final String username;
    private final String pass;
    public Admin() {
        username="admin";
        pass="admin";
    }

    public String getUsername() {
        return username;
    }
    public String getPass() {
        return pass;
    }

    //@NotNull to indicate that a parameter or return value of a method should not be null
    //it  is a way to provide additional information to tools and other developers about the expected behavior of our code
    public boolean adminLogin(@NotNull String name, String password){
        boolean loginSuccessful = false;
        boolean validateName=USER.validateName(name);
        boolean validatePass=USER.validatePassword(password);
        if(validateName && validatePass){
            if(name.equals(username)){
                if(password.equals(pass)){
                    loginSuccessful= true;
                }
            }
        }
        return loginSuccessful;
    }

    public  void AdminMainMenu() {
        System.out.println("\n\nLogged in successfully!\n\n");
        int choice;

        do{
            System.out.println("Admin Main Menu\n---------------------------\n\n");
            System.out.println("1. Add\n");
            System.out.println("2. Remove\n");
            System.out.println("3. Edit\n");
            System.out.println("4. View a Customer Subscription\n"); //hya5od id el customer w ytl3 el subs bta3o
            System.out.println("5. View Subscriptions //in a day or month\n");
            System.out.println("6. View a Coach's Customers\n"); //hayd5ol 3nd coach mo3yn yshof el customers bto3o
            System.out.println("7. View Gym's Income\n"); //in a month
            System.out.println("8. View Top Coaches\n"); //sorted 3la 7sb 3adad el customers 3nd kol coach
            System.out.println("9. Log Out\n\n");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();


            switch (choice) {
                case 1:
                    System.out.println("1.Add Customer\n");
                    System.out.println("2.Add Coach\n");
                    System.out.println("3.Add Equipment\n");
                    //System.out.println("4. Return to the menu\n"); (ttzbt fl gui?)
                    int c2=input.nextInt();
                    if(c2==1){
                        addCustomer();

                    } else if (c2==2) {
                        addCoach();
                    }
                    else if(c2==3){
                        addEquip();
                    }
//                    else if(c2==4){
//                        AdminMainMenu();
//                    }
                    else
                    {
                        System.out.println("INVALID CHOICE\n TRY AGAIN LATER");
                        AdminMainMenu(); //httzbt fl gui eno y-go back br7to mn gher ma a-call el method gwa nfsaha?
                    }
                    break;
                case 2:
                    System.out.println("1.Remove Customer\n");
                    System.out.println("2.Remove Coach\n");
                    System.out.println("3.Remove Equipment\n");
                    int c3=input.nextInt();
                    if(c3==1){
                        int id=input.nextInt();
                        deleteCustomer(id);
                    } else if (c3==2) {
                        int id=input.nextInt();
                        deleteCoach(id);
                    }
                    else if(c3==3){
                        int code=input.nextInt();
                        deleteEquip(code);
                    }
//                    else if(c3==4){
//                        AdminMainMenu();
//                    }
                    else
                    {
                        System.out.println("INVALID CHOICE\n TRY AGAIN LATER");
                        AdminMainMenu(); //httzbt fl gui eno y-go back br7to mn gher ma a-call el method gwa nfsaha?
                    }
                    break;
                case 3:
                    System.out.println("1.Edit Customer\n");
                    System.out.println("2.Edit Coach\n");
                    System.out.println("3.Edit Equipment\n");
                    int c4=input.nextInt();

                    if(c4==1){

                        int id=input.nextInt();
                        editCustomer();

                    } else if (c4==2) {

                        int id=input.nextInt();
                        editCoach();

                    }
                    else if(c4==3){

                        int code=input.nextInt();
                        editEquip();
                    }
//                    else if(c4==4){
//                        AdminMainMenu();
//                    }
                    else
                    {
                        System.out.println("INVALID CHOICE\n TRY AGAIN LATER");
                        AdminMainMenu(); //msh 3yzeen kda, ttzbt fl gui isa
                    }
                    break;
                case 4:

                    System.out.println("ENTER CUSTOMER'S ID");
                    int id=input.nextInt();
                    historySubscription(id);
                    break;
                case 5:

                    customersSubscribedInGivenDate();
                    break;

                case 6:
                    displayCustomersForCoach();
                    break;

                case 7:
                    int m=input.nextInt();
                    gymIncome(m);
                    break;

                case 8:
                    displaySortedCoaches();
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 9);
    }


    public void addCoach(){
        GYM.regCoach();
    }
    public void addCustomer(){
        GYM.regCustomer();
    }
    //checker 3al name gwa add w edit equip eno msh mwgud abl kda
    public void addEquip(){ //equipmentList
        System.out.println("Enter equipment's name: ");
        String newEquipName=input.next();
        System.out.println("Enter equipment's quantity: ");
        int newEquipQuantity=input.nextInt();


        Equipment newEquipment=new Equipment(newEquipName,newEquipQuantity);
        GYM.equipmentList.add(newEquipment);
    }

    public static void editCoach() {
        System.out.println("\nPlease enter the coach's id: ");
        int id = input.nextInt();
        Coach specificCoach = Coach.getCoachByID(id);
        if (specificCoach != null) {
            System.out.println("Enter new address (press Enter to skip): ");
            String newAddress = input.nextLine();

            System.out.println("Enter new email (press Enter to skip): ");
            String newEmail = input.nextLine();

            System.out.println("Enter new name (press Enter to skip): ");
            String newName = input.nextLine();

            System.out.println("Enter new password (press Enter to skip): ");
            String newPassword = input.nextLine();

            System.out.println("Enter new gender (press Enter to skip): ");
            String genderInput = input.nextLine();
            char newGender = genderInput.isEmpty() ? specificCoach.getGender() : genderInput.charAt(0);

            System.out.println("Enter new phone number (press Enter to skip): ");
            String phoneInput = input.nextLine();
            int newPhonenum = phoneInput.isEmpty() ? specificCoach.getPhoneNO() : Integer.parseInt(phoneInput);

            System.out.println("Enter new working hours (press Enter to skip): ");
            String workingHoursInput = input.nextLine();
            int newWorkinghours = workingHoursInput.isEmpty() ? specificCoach.getWorkingHrs() : Integer.parseInt(workingHoursInput);

            // Update attributes if values were provided
            if (!newAddress.isEmpty()) {
                specificCoach.setAddress(newAddress);
                System.out.println("Address updated successfully.");
            }
            if (!newEmail.isEmpty()) {
                specificCoach.setEmail(newEmail);
                System.out.println("Email updated successfully.");
            }
            if (!newName.isEmpty()) {
                specificCoach.setName(newName);
                System.out.println("Name updated successfully.");
            }
            if (!newPassword.isEmpty()) {
                specificCoach.setPass(newPassword);
                System.out.println("Password updated successfully.");
            }
            if (!genderInput.isEmpty()) {
                specificCoach.setGender(newGender);
                System.out.println("Gender updated successfully.");
            }
            if(!phoneInput.isEmpty()) {
                specificCoach.setPhoneNO(newPhonenum);
                System.out.println("Phone number updated successfully.");
            }
            if(!workingHoursInput.isEmpty()){
                specificCoach.setWorkingHrs(newWorkinghours);
                System.out.println("Working Hours updated successfully.");
            }
        } else {
            System.out.println("Invalid coach ID.");
        }
    }
    public void editCustomer(){
        System.out.println("\nPlease enter the customer's id: ");
        int id = input.nextInt();
        Customer specificCustomer = Customer.getCustomerById(id);
        if (specificCustomer != null) {
            System.out.println("Enter new address (press Enter to skip): ");
            String newAddress = input.nextLine();

            System.out.println("Enter new email (press Enter to skip): ");
            String newEmail = input.nextLine();

            System.out.println("Enter new name (press Enter to skip): ");
            String newName = input.nextLine();

            System.out.println("Enter new password (press Enter to skip): ");
            String newPassword = input.nextLine();

            System.out.println("Enter new gender (press Enter to skip): ");
            String genderInput = input.nextLine();
            char newGender = genderInput.isEmpty() ? specificCustomer.getGender() : genderInput.charAt(0);

            System.out.println("Enter new phone number (press Enter to skip): ");
            String phoneInput = input.nextLine();
            int newPhonenum = phoneInput.isEmpty() ? specificCustomer.getPhoneNO() : Integer.parseInt(phoneInput);

            System.out.println("Enter new working hours (press Enter to skip): ");

            // Update attributes if values were provided
            if (!newAddress.isEmpty()) {
                specificCustomer.setAddress(newAddress);
                System.out.println("Address updated successfully.");
            }
            if (!newEmail.isEmpty()) {
                specificCustomer.setEmail(newEmail);
                System.out.println("Email updated successfully.");
            }
            if (!newName.isEmpty()) {
                specificCustomer.setName(newName);
                System.out.println("Name updated successfully.");
            }
            if (!newPassword.isEmpty()) {
                specificCustomer.setPass(newPassword);
                System.out.println("Password updated successfully.");
            }
            if (!genderInput.isEmpty()) {
                specificCustomer.setGender(newGender);
                System.out.println("Gender updated successfully.");
            }
            if(!phoneInput.isEmpty()) {
                specificCustomer.setPhoneNO(newPhonenum);
                System.out.println("Phone number updated successfully.");
            }
        } else {
            System.out.println("Invalid customer ID.");
        }
    }
    public void editEquip() {
        System.out.println("\nEnter the equipment code you want to edit: ");
        int equcode = input.nextInt();
        Equipment specificequ = Equipment.getEquipByCode(equcode);
        if (specificequ != null) {
            System.out.println("Enter new Name (press Enter to skip) ");
            String newName = input.nextLine();
            System.out.println("Enter new quantity  (press Enter to skip) ");
            String inputQuantity = input.nextLine();
            int newQuantity = inputQuantity.isEmpty() ? specificequ.getQuantity() : Integer.parseInt(inputQuantity);
            if (!newName.isEmpty()) {
                for (Equipment equipment : GYM.equipmentList) {
                    if (equipment.equipName.equals(newName)) {
                        System.out.println("THE EQUIPMENT IS ALREADY EXIST ");
                    } else {
                        specificequ.equipName = newName;
                    }
                }
                System.out.println(" Equipment name updated successfully.");
            }
            if(!inputQuantity.isEmpty()){
                specificequ.setQuantity(newQuantity);
                System.out.println( "Equipment Quantity updated successfully.");
            }
        }
        else {
            System.out.println("Invalid Equipment code .");
        }
    }

    public String deleteCoach(int coachID) {
        for (USER user : GYM.userList) {
            if (user instanceof Coach) {
                Coach coach = (Coach) user; //downcasting
                if (coach.getCoachID()==coachID) {
                    GYM.userList.remove(coach);
                    return "\n\nCoach's -with ID " + coachID + "- Data Removed\n\n";
                }
            }
        }
        return "\n\nCoach with ID " + coachID + " was not found in gym.\n\n";
    }
    public String  deleteCustomer(int customerID){
        for (USER user : GYM.userList) {
            if (user instanceof Customer) {
                Customer customer = (Customer) user; //downcasting
                if (customer.getCustomerID()==customerID) {
                    GYM.userList.remove(customer);
                    return "\n\nCoach's -with ID " + customerID + "- Data Removed\n\n";
                }
            }
        }
        return "\n\nCoach with ID " + customerID + " was not found in gym.\n\n";
    }
    public String  deleteEquip(int equipCode){
        for(Equipment e: GYM.equipmentList){
            if(e.getEquipCode()==equipCode){
                GYM.equipmentList.remove(e);
                return "\n\nEquipment's -with ID "+ equipCode+"- Data Removed\n\n";
            }
        }
        return "\n\nEquipment with code " + equipCode + " was not found in gym.\n\n";
    }

    private String gymIncome(int month){
        GYM.storeGymSubscriptions();
        LocalDate currentDate = LocalDate.now();
        String lines = "--------------------------------";
        StringBuilder Income = new StringBuilder("\n Date : " + currentDate + "\n"+lines+ "\n");
        Subscription[] gymSubs=GYM.getGymSubscriptions();
        for (int i = 0; i < 12; i++) {
            if (gymSubs[i].plan.getStartDate().getMonth()== Month.of(month)) {
                Income.append(gymSubs[i].plan.getPrice());
            }
        }
        return Income.toString();
    }
    public void displayCustomersForCoach() { //display coaches ids and names to choose one
        System.out.println("\nPlease enter the coach's ID you want to view his customers: ");
        int id = input.nextInt();
        Coach specificCoach = Coach.getCoachByID(id);

        if (specificCoach!=null){
            specificCoach.ListOfCustomers(); //exception handling?
        }
        else System.out.println("\nThis coach doesn't exist! Please enter a valid ID.\n");
    }
    public void customersSubscribedInGivenDate() {
        Subscription[] subsarray = GYM.getGymSubscriptions();

        System.out.println("Please enter specific date:");
        System.out.print("Enter the month (1-12): ");
        int month = input.nextInt();
        System.out.print("Press Enter to skip, or enter the day: ");
        String dayInput = input.next();

        if (dayInput != null) {
            int day = Integer.parseInt(dayInput);
            for (int i = 0; i < 100; i++) {
                if (subsarray[i] != null) {
                    if (day == subsarray[i].plan.getStartDate().getDayOfMonth() && month == subsarray[i].plan.getStartDate().getMonthValue()) {
                        Customer customer = Customer.getCustomerById(subsarray[i].getCustomerID());
                        customer.displayInfo();
                    }
                }

            }

        } else {
            for (int i = 0; i < 100; i++) {
                if (subsarray[i] != null) {
                    if (month == subsarray[i].plan.getStartDate().getMonthValue()) {
                        Customer customer = Customer.getCustomerById(subsarray[i].getCustomerID());
                        customer.displayInfo();

                    }
                }
            }
        }
    }

    public void historySubscription(int id){
        Customer customer=Customer.getCustomerById(id);
        // Check if customer exists
        if (customer != null) {
            if (customer.subs.length == 0) {
                System.out.println("No subscriptions found for customer with ID: " + id);
            } else {
                // Iterate over subscriptions and display them
                for (Subscription subscription : customer.subs) {
                    subscription.displaySubscription();
                }
            }
        } else {
            System.out.println("Customer not found with ID: " + id);
        }

    }

    public void displaySortedCoaches(){
        ArrayList<Integer> counterList = new ArrayList<>();
        ArrayList<Coach> newCoachList = new ArrayList<>();
        ArrayList<Coach> onlyCoachesList = new ArrayList<>();
        for (USER user : GYM.userList) {
            if (user instanceof Coach) {
                Coach coach = (Coach) user; //downcasting
                onlyCoachesList.add(coach);
            }
        }
        //-----------------------------------------------------

        for (USER user : GYM.userList) {
            if (user instanceof Coach) {
                Coach coach = (Coach) user; //downcasting
                for (int j = 0; j <= 10; j++)
                {
                    if (coach.customersArray[j] != null)
                    {
                        coach.customerCounter++;

                    }
                    else
                    {
                        break;
                    }
                }
                counterList.add(coach.customerCounter);
            }
        }
        //-----------------------------------------------------
        counterList.sort(Collections.reverseOrder());
        //-----------------------------------------------------
        Outerloop: for (Integer integer : counterList)
        {
            for (USER user : GYM.userList) {
                if (user instanceof Coach) {
                    Coach coach = (Coach) user; //downcasting
                    if (integer == coach.customerCounter)
                    {
                        newCoachList.add(coach);
                        if (newCoachList.size()==onlyCoachesList.size())
                        {
                            break Outerloop;
                        }
                    }
                    else
                    {
                        continue ;
                    }
                }
            }

        }
        //-------------------------------------------------------------
        int display;
        for (Coach CO:newCoachList)
        {
            display= newCoachList.indexOf(CO);
            display++;
            System.out.println(display+"-"+CO.getName());

        }
    }
}

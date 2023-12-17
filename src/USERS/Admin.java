package USERS;
import GYM.*;

import java.util.*;
import SERVICES.*;
import java.time.LocalDate;
import org.jetbrains.annotations.NotNull;
import java.time.Month;
import java.io.Serializable;
import static GYM.GYM.input;
import GYM.Equipment.*;

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
        if(validateName){
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
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("3. Edit");
            System.out.println("4. View a Customer Subscription"); //hya5od id el customer w ytl3 el subs bta3o
            System.out.println("5. View Subscriptions //in a day or month");
            System.out.println("6. View a Coach's Customers"); //hayd5ol 3nd coach mo3yn yshof el customers bto3o
            System.out.println("7. View Gym's Income"); //in a month
            System.out.println("8. View Top Coaches"); //sorted 3la 7sb 3adad el customers 3nd kol coach
            System.out.println("9. Log Out\n");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();


            switch (choice) {
                case 1:
                    System.out.println("1.Add Customer");
                    System.out.println("2.Add Coach");
                    System.out.println("3.Add Equipment");
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
                    else
                    {
                        System.out.println("INVALID CHOICE\n TRY AGAIN LATER");
                    }
                    break;
                case 2:
                    System.out.println("1.Remove Customer");
                    System.out.println("2.Remove Coach");
                    System.out.println("3.Remove Equipment");
                    int c3=input.nextInt();
                    if(c3==1){
                        displayCustomersForViewing();
                        System.out.println("Enter the customer ID: ");
                        int id=input.nextInt();
                        deleteCustomer(id);
                    } else if (c3==2) {
                        displayCoachesForViewing();
                        System.out.println("Enter the coach ID: ");
                        int id=input.nextInt();
                        deleteCoach(id);
                    }
                    else if(c3==3){
                        for (Equipment equipment : GYM.equipmentList) {
                            System.out.println(equipment.equipName + equipment.getEquipCode());
                        }
                        System.out.println("Enter the equipment code: ");
                        int code=input.nextInt();
                        deleteEquip(code);
                    }
                    else
                    {
                        System.out.println("INVALID CHOICE\n TRY AGAIN LATER");
                    }
                    break;
                case 3:
                    System.out.println("1.Edit Customer");
                    System.out.println("2.Edit Coach");
                    System.out.println("3.Edit Equipment");
                    int c4=input.nextInt();

                    if(c4==1){
                        displayCustomersForViewing();
                        editCustomer();

                    } else if (c4==2) {
                        displayCoachesForViewing();
                        editCoach();

                    }
                    else if(c4==3){
                        for (Equipment equipment : GYM.equipmentList) {
                            System.out.println(equipment.equipName + equipment.getEquipCode());
                        }
                        editEquip();
                    }
                    else
                    {
                        System.out.println("INVALID CHOICE\n TRY AGAIN LATER");
                    }
                    break;
                case 4:
                    displayCustomersForViewing();
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
                    System.out.println("Enter the month: ");
                    int m=input.nextInt();
                    String income=gymIncome(m);
                    System.out.println("Gym Income for this month is: " + income);
                    break;

                case 8:
                    System.out.println("\t\tTop Coaches\t\t");
                    displaySortedCoaches();
                    break;
                case 9:
                    System.out.println("Exiting...");
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
    public void addEquip(){ //equipmentList
        boolean checker=false;
        System.out.println("Enter equipment's name: ");
        input.nextLine();
        String newEquipName=input.nextLine();
        System.out.println("Enter equipment's quantity: ");
        int newEquipQuantity=input.nextInt();

//        for (Equipment equipment : GYM.equipmentList) {
//            if (equipment.equipName.equals(newEquipName)) {
//                checker=true;
//                System.out.println("THE EQUIPMENT ALREADY EXISTS! PLEASE TRY AGAIN.");
//                break;
//            }
//        }
        Equipment newEquipment=new Equipment(newEquipName,newEquipQuantity);
        GYM.equipmentList.add(newEquipment);
        System.out.println("Equipment added successfully!");
    }

    public static void editCoach() {
        System.out.println("\nEnter the coach ID you want to edit: ");
        int id = input.nextInt();
        Coach specificCoach = Coach.getCoachByID(id);
        if (specificCoach != null) {
            System.out.println("Enter new address (press Enter to skip): ");
            input.nextLine();
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
                if (USER.validateEmail(newEmail)){
                    specificCoach.setEmail(newEmail);
                    System.out.println("Email updated successfully.");
                }
                else System.out.println("This email already exists! Please try again.");

            }
            if (!newName.isEmpty()) {
                if (USER.validateName(newName)){
                    specificCoach.setName(newName);
                    System.out.println("Name updated successfully.");
                }
                else System.out.println("This name already exists! Please try again.");
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
                if (USER.validatePhone(newPhonenum)){
                    specificCoach.setPhoneNO(newPhonenum);
                    System.out.println("Phone number updated successfully.");
                }
                else System.out.println("This phone number already exists! Please try again.");
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
        System.out.println("\nEnter the customer ID you want to edit: ");
        int id = input.nextInt();
        Customer specificCustomer = getCustomerById(id);
        if (specificCustomer != null) {
            System.out.println("Enter new address (press Enter to skip): ");
            input.nextLine();
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


            // Update attributes if values were provided
            if (!newAddress.isEmpty()) {
                specificCustomer.setAddress(newAddress);
                System.out.println("Address updated successfully.");
            }
            if (!newEmail.isEmpty()) {
                if (USER.validateEmail(newEmail)) {
                    specificCustomer.setEmail(newEmail);
                    System.out.println("Email updated successfully.");
                }
                else System.out.println("This email already exists! Please try again.");

            }
            if (!newName.isEmpty()) {
                if (USER.validateName(newName)) {
                    specificCustomer.setName(newName);
                    System.out.println("Name updated successfully.");
                }
                else System.out.println("This name already exists! Please try again.");

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
                if (USER.validatePhone(newPhonenum)){
                    specificCustomer.setPhoneNO(newPhonenum);
                    System.out.println("Phone number updated successfully.");
                }
                else System.out.println("This phone number already exists! Please try again.");

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
            input.nextLine();
            String newName = input.nextLine();

            System.out.println("Enter new quantity  (press Enter to skip) ");
            String inputQuantity = input.nextLine();
            int newQuantity = inputQuantity.isEmpty() ? specificequ.getQuantity() : Integer.parseInt(inputQuantity);

            if (!newName.isEmpty()) {
                for (Equipment equipment : GYM.equipmentList) {
                    if (equipment.equipName.equals(newName)) {
                        System.out.println("THE EQUIPMENT ALREADY EXISTS! PLEASE TRY AGAIN.");
                    } else {
                        specificequ.setEquipName(newName);
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

    public void deleteCoach(int coachID) {
        for (USER user : GYM.userList) {
            if (user instanceof Coach) {
                Coach coach = (Coach) user; //downcasting
                if (coach.getCoachID()==coachID) {
                    GYM.userList.remove(coach);
                    System.out.println("Coach's -with ID " + coachID + "- Data Removed");
                }
            }
        }
        System.out.println("Coach with ID " + coachID + " was not found in gym.");
    }
    public void  deleteCustomer(int customerID){
        for (USER user : GYM.userList) {
            if (user instanceof Customer) {
                Customer customer = (Customer) user; //downcasting
                if (customer.getCustomerID()==customerID) {
                    GYM.userList.remove(customer);
                    System.out.println("Coach's -with ID " + customerID + "- Data Removed");
                }
            }
        }
        System.out.println("Coach with ID " + customerID + " was not found in gym.");
    }
    public void  deleteEquip(int equipCode){
        for(Equipment e: GYM.equipmentList){
            if(e.getEquipCode()==equipCode){
                GYM.equipmentList.remove(e);
                System.out.println("Equipment's -with ID "+ equipCode+"- Data Removed");
            }
        }
        System.out.println("Equipment with code " + equipCode + " was not found in gym.");
    }

    private String gymIncome(int month){
        GYM.storeGymSubscriptions();
        LocalDate currentDate = LocalDate.now();
        String lines = "--------------------------------";
        StringBuilder Income = new StringBuilder("$");
        Subscription[] gymSubs=GYM.getGymSubscriptions();
        for (int i = 0; i < gymSubs.length; i++) {
            if (gymSubs[i]!=null){
                if (gymSubs[i].plan.getStartDate().getMonth()== Month.of(month)) {
                    Income.append(gymSubs[i].plan.getPrice());
                }
            }
            else break;
        }
        return Income.toString();
    }
    public void displayCustomersForCoach() { //display coaches ids and names to choose one
        displayCoachesForViewing();
        System.out.println("Please enter the coach's ID you want to view his customers: ");
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
                        Customer customer = getCustomerById(subsarray[i].getCustomerID());
                        customer.displayInfo();
                    }
                }

            }

        } else {
            for (int i = 0; i < 100; i++) {
                if (subsarray[i] != null) {
                    if (month == subsarray[i].plan.getStartDate().getMonthValue()) {
                        Customer customer = getCustomerById(subsarray[i].getCustomerID());
                        customer.displayInfo();

                    }
                }
            }
        }
    }

    public void historySubscription(int id){
        Customer customer=getCustomerById(id);
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

    public static Customer getCustomerById(int id) {
        for (USER user : GYM.userList) {
            if (user instanceof Customer) {
                Customer customer = (Customer) user; //downcasting
                if (customer.getCustomerID()==(id)) {
                    return customer; // Return the coach if ID matches
                }
            }
        }
        return null; // Return null if coach with given ID is not found
    }

    void displayCoachesForViewing(){
        System.out.println("Coaches List");
        for (USER user : GYM.userList) {
            if (user instanceof Coach) {
                Coach coach = (Coach) user; //downcasting
                System.out.println("---------------------------------------------------------------\n"
                        + "\t\t> Id : " + coach.getCoachID() + "\t> Name : " + coach.getName());
            }
        }
    }

    void displayCustomersForViewing(){
        System.out.println("Customers List");
        for (USER user : GYM.userList) {
            if (user instanceof Customer) {
                Customer customer = (Customer) user; //downcasting
                System.out.println("---------------------------------------------------------------\n"
                        + "\t\t> Id : " + customer.getCustomerID() + "\t> Name : " + customer.getName());
            }
        }
    }
}

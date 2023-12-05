package USERS;
import GYM.GYM;
import MAIN.*;
import GYM.Equipment;
import java.util.*;
import DATABASE.*;
import java.time.LocalDate;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
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


    Scanner scanner = new Scanner(System.in);
    public  void AdminMainMenu(Admin admin,ArrayList<Customer>customerList,ArrayList<Coach> coachlist,ArrayList<Equipment> equips) {
        Scanner scanner = new Scanner(System.in);
        int c;

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
            c = scanner.nextInt();


            switch (c) {
                case 1:
                    System.out.println("1.Add Customer\n");
                    System.out.println("2.Add Coach\n");
                    System.out.println("3.Add Equipment\n");
                    int c2=scanner.nextInt();
                    if(c2==1){
                        admin.addCustomer(customerList);
                    } else if (c2==2) {
                        admin.addCoach(coachlist);
                    }
                    else if(c2==3){
                        admin.addEquip(equips);
                    }
                    else
                    {
                        System.out.println("INVALID CHOICE\n TRY AGAIN LATER");
                        AdminMainMenu(admin,customerList,coachlist,equips);
                    }
                    break;
                case 2:
                    System.out.println("1.Remove Customer\n");
                    System.out.println("2.Remove Coach\n");
                    System.out.println("3.Remove Equipment\n");
                    int c3=scanner.nextInt();
                    if(c3==1){
                        int id=scanner.nextInt();
                        admin.deleteCustomer(customerList,id);
                    } else if (c3==2) {
                        int id=scanner.nextInt();
                        admin.deleteCoach(coachlist,id);
                    }
                    else if(c3==3){
                        int code=scanner.nextInt();
                        admin.deleteEquip(equips,code);
                    }
                    else
                    {
                        System.out.println("INVALID CHOICE\n TRY AGAIN LATER");
                        AdminMainMenu(admin,customerList,coachlist,equips);
                    }
                    break;
                case 3:
                    System.out.println("1.Edit Customer\n");
                    System.out.println("2.Edit Coach\n");
                    System.out.println("3.Edit Equipment\n");
                    int c4=scanner.nextInt();

                    if(c4==1){

                        int id=scanner.nextInt();
                        admin.editCustomer(customerList);

                    } else if (c4==2) {

                        int id=scanner.nextInt();
                        admin.editCoach(coachlist);

                    }
                    else if(c4==3){

                        int code=scanner.nextInt();
                        admin.editEquip(equips);
                    }
                    else
                    {
                        System.out.println("INVALID CHOICE\n TRY AGAIN LATER");
                        AdminMainMenu(admin,customerList,coachlist,equips);
                    }
                    break;
                case 4:

                    System.out.println("ENTER CUSTOMER'S ID");
                    int id=scanner.nextInt();
                    // call method el view subs
                    break;
                case 5:

                    //call method el subs in day/month
                    break;

                case 6:

                    int m=scanner.nextInt();
                    admin.gymIncome(customerList,m);
                    break;

                case 7:

                    //sorted insah'allah yehia hy3mlha
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (c != 9);

        // Close the scanner to prevent resource leak
        scanner.close();
    }

    //@NotNull to indicate that a parameter or return value of a method should not be null
    //it  is a way to provide additional information to tools and other developers about the expected behavior of our code
    public boolean adminLogin( @NotNull String name, String password){
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
        System.out.println("\nEnter Coach's working hours (max 10): "); //check 3al hour enha msh akbr mn 10 w msh 0
        //nfs el check fl reg
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
    //checker 3al name gwa add w edit equip eno msh mwgud abl kda
    public void addEquip(ArrayList<Equipment> equips){ //equipmentList
        Scanner input=new Scanner(System.in);
        System.out.println("Enter equipment's name: ");
        String newEquipName=input.next();
        System.out.println("Enter equipment's quantity: ");
        int newEquipQuantity=input.nextInt();
        input.close();

        Equipment newEquipment=new Equipment(newEquipName,newEquipQuantity,equips);
        equips.add(newEquipment);
        GymDataBase.saveData(equips, "EQUIPMENTS");
    }

    //enter to skip bdal switch cases
    public static void editCoach(ArrayList<Coach> coachList) {
        System.out.println("\nPlease enter the coach's id: ");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        Coach specificCoach = Coach.getCoachByID(coachList, id);
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
    public void editCustomer(ArrayList<Customer> customerList){
        System.out.println("\nPlease enter the customer's id: ");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        Customer specificCustomer = Customer.getCustomerById(customerList, id);
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
            String ageInput = input.nextLine();
            int newAge = ageInput.isEmpty() ? specificCustomer.getAge() : Integer.parseInt(ageInput);

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
            if(!ageInput.isEmpty()){
                specificCustomer.setAge(newAge);
                System.out.println("Age updated successfully.");
            }
        } else {
            System.out.println("Invalid customer ID.");
        }


    }
    public void editEquip(ArrayList<Equipment> equipmentList) {
        System.out.println(" Enter the equipment code:\n ");
        Scanner input = new Scanner(System.in);
        int equcode = input.nextInt();
        Equipment specificequ = Equipment.getequipmentbycode(equipmentList, equcode);
        if (specificequ != null) {
            System.out.println("Enter new Name (press Enter to skip) ");
            String newName = input.nextLine();
            System.out.println("Enter new quantity  (press Enter to skip) ");
            String inputQuantity = input.nextLine();
            int newQuantity = inputQuantity.isEmpty() ? specificequ.getQuantity() : Integer.parseInt(inputQuantity);
            if (!newName.isEmpty()) {
                for (Equipment equipment : equipmentList) {
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

    private String gymIncome(@NotNull ArrayList<Customer> customerList, int month){
        LocalDate currentDate = LocalDate.now();
        String lines = "--------------------------------";
        StringBuilder Income = new StringBuilder("\n Date : " + currentDate + "\n"+lines+ "\n");
        for(Customer C : customerList){
            Income.append(C.subs[month].plan.getPrice());
        }
        return Income.toString();
    }

    public void displayCustomersForCoach( ArrayList<Coach> coachList) {
        System.out.println("\nPlease enter the coach's id: ");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        Coach specificCoach = Coach.getCoachByID(coachList, id);
        specificCoach.ListOfCustomers();

    }





}

package USERS;

import DATABASE.GymDataBase;
import GYM.Equipment;
import GYM.GYM;
import SERVICES.InBody;
import SERVICES.Membership_plan;
import SERVICES.Subscription;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.io.Serializable;
import static GYM.GYM.input;

public class Customer extends USER implements Serializable {
    InBody[] inbodies= new InBody[12];//12 nfs fkrt el subscription
    public Subscription[] subs=new Subscription[12]; //lih eshtrak sana, w b3d kda el admin hyfdy el array w ybda2 mn el awl, to calculate income properly
    private int customerID;
    public Customer(String address, String email, String name, String pass, char gender, int phoneNO){
        super(address, email, name, pass, gender, phoneNO);
        customerID=generateAutoIdForCustomer();
    }

    public Subscription[] getSubs() {
        return subs;
    }

    public void setSubs(Subscription subs) {
        for (int i=0;i<12;i++){
            if (this.subs[i]==null) this.subs[i] = subs;
        }
    }
    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void CustomerMainMenu(){
        int choice;

        do{
            System.out.println(" You logged in successfully !");
            System.out.println(" Main Menu\n...........");
            System.out.println("1. Your coach's information");
            System.out.println("2. Display all gym equipments");
            System.out.println("3. Membership plan details");
            System.out.println("4. InBody info at specific date");
            System.out.println("5. Kilos to be reduced");
            System.out.println("6. Subscription and renewal");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();


            switch (choice) {
                case 1:
                    System.out.println("Your coach's information: \n");
                    displayYourCoachInfo();
                    break;
                case 2:
                    System.out.println("Gym equipments: \n");
                    displayEquips();
                    break;
                case 3:
                    System.out.println("Your membership plan: \n");
                    displayPlan();
                    break;
                case 4:
                    System.out.println("Your inbody info: \n");
                    System.out.println("Enter the date (format: YYYY-MM-DD): ");
                    String date=input.next();
                    displayInbodyByDate(date);
                    break;

                case 5:
                    System.out.println("Enter desired weight (KG): ");
                    int desiredWeight=input.nextInt();
                    System.out.println("Kilos to be reduced: \n");
                    displayWeightLoss(desiredWeight);
                    break;

                case 6:
                    System.out.println("\n\nEnter Subscription and Plan Details");
                    System.out.println("\nEnter plan start date (yyyy-MM-dd): ");
                    String inputStartDate = input.next();
                    //Define a DateTimeFormatter for the expected date format
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    //GYM.Subscription(getCustomerById(customerID),inputStartDate);
                    renewSubscription(getCustomerById(getCustomerID()));

                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 7);

    }

    //for admin, btgm3 start date for that customer in the iteration
    //de eh shoghletha ya mariam?
    public ArrayList<LocalDate> getSubscriptionsStartDate(){
        ArrayList<LocalDate> startDates = new ArrayList<>();
        for(int i=0;i<12;i++){
            if(subs[i]!=null){
                startDates.add(subs[i].plan.getStartDate());
            }
        }
        return startDates;
    }

    public int generateAutoIdForCustomer() {
        while (true) {
            int autoCusId = (int)(10000 + Math.random() * 11000);
            boolean idExists = false;

            for (USER user : GYM.userList) {
                if (user instanceof Customer) {
                    Customer customer = (Customer) user; //downcasting
                    if (customer.getCustomerID() == autoCusId) {
                        idExists = true;
                        break; //exit the loop since the ID already exists w yrg3 y-generate bc it's a while(true) loop
                    }
                }
            }
            if (!idExists) {
                return autoCusId; //return the ID if it doesn't exist in the list
            }
        }
    }

    //default 3shan de info lely f nfs el package bs
    String displayInfo(){
        return "\n\t\tCustomer's Details : " + "\n---------------------------------------------------------------\n"
                + "\n\n> Id : " + getCustomerID() + "\n\n> Email : " + getEmail() + "\n\n> Name : " + getName() + "\n\n> Gender : " + getGender()
                + "\n\n> Phone Number : " + getPhoneNO()  +"\n---------------------------------------------------------------\n" ;
    }

    //for admin to edit customer
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
    //for coach
    public static Customer getCustomerByName(String name) {
        for (USER user : GYM.userList) {
            if (user instanceof Customer) {
                Customer customer = (Customer) user; //downcasting
                if (customer.getName().equals(name)) {
                    return customer; // Return the coach if ID matches
                }
            }
        }
        return null;
    }
    public void displayEquips(){
        Equipment.displayEquipmentNames();
    }

    //customer displaying his own history at a specific date
    public void displayInbodyByDate(String date) {
        System.out.println("\nYour InBody history for " + date + "\n------------------------------------\n\n");
        boolean exist=false;
        //parse the string date into a LocalDate in order to compare it in the step ahead
        LocalDate parsedDate = LocalDate.parse(date);
        for (int i=0;i<12;i++){
            if (inbodies[i].getDate().equals(parsedDate)){
                inbodies[i].displayInbody();
                exist=true;
            }
        }
        if (!exist) System.out.println("There is no InBody history for such date\n\n");
    }

    public void displayYourCoachInfo(){
        int index=-1;

        for(int i=0;i<12;i++){
            if(subs[i+1]==null){
                index=i;
            }
        }

        int coachID=subs[index].getCoachID();
        Coach myCoach=Coach.getCoachByID(coachID);
        myCoach.displayInfoForCustomer();
    }

    public void displayWeightLoss(int desiredWeight) {
        int lastindex=0;
        int weightLossPercentage;
        int weightLossKilos;
        for (int j = 0; j <= 12; j++) {
            if (inbodies[j] != null) {
                lastindex++;

            } else {
                break;
            }
        }
        weightLossPercentage = Math.abs((desiredWeight- inbodies[lastindex].getTotalWeightKG())/(desiredWeight*100));
        weightLossKilos= inbodies[lastindex].getTotalWeightKG()*weightLossPercentage;

        System.out.println("\nThe Percentage of weight loss to reach Desired Weight: "+weightLossPercentage);
        System.out.println("\nThe amount of kilos for Weight Loss: "+weightLossKilos);
    }

    public void displayPlan(){ //to display CURRENT plan
        int index=-1;
        for(int i=0;i<12;i++){
            if(subs[i+1]==null){
                index=i;
            }
        }
        subs[index].plan.displayPlan();
    }

    public void renewSubscription(Customer customer) { //subscribe and renew
        int index=-1;
        for(int i=0;i<12;i++){
            if(subs[i+1]==null){
                index=i;
            }
        }

        LocalDate currentdate= LocalDate.now();
        if(currentdate.isAfter(subs[index].plan.getEndDate()) || subs[0]==null){
            System.out.println("Do you want to subscribe? (yes/no): ");
            String renewChoice = input.next();

            if ("yes".equalsIgnoreCase(renewChoice)) {
                System.out.println("\nPlease enter the start date: ");
                String startDate=input.next();

                // Define a DateTimeFormatter for the expected date format
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                try { //7sa hena fe 7aga n2sa bs m3rfsh eh hya
                    GYM.Subscription(customer, startDate);
                    System.out.println("Subscription renewed successfully!");
                } catch (DateTimeParseException e) {
                    System.out.println("\nInvalid date format. Please register again.\n");
                }

            } else {
                System.out.println("Renewal cancelled.");
            }
        }
    }

    public void AddingInbody(){

        int index=-1;
        for(int i=0;i<12;i++){
            if(inbodies[i+1]==null){
                index=i;
            }
        }
        LocalDate today = LocalDate.now();
        long daysDifference = ChronoUnit.DAYS.between(inbodies[index].getDate(), today);
        if(daysDifference<30){
            int result = 30 - (int) daysDifference;
            System.out.println("SORRY,YOU CAN'T DO INBODY NOW BUT YOU CAN DO IN :"+result+"DAYS");

        }

        else if(daysDifference>30 || inbodies[index+1]==null){
            System.out.println("Enter Your Height: ");
            int  newHeight = input.nextInt();
            inbodies[index+1].setHeightM(newHeight);

            System.out.println("Enter new Weight: ");
            int newWeight = input.nextInt();
            inbodies[index+1].setTotalWeightKG(newWeight);

            System.out.println("Enter Your bodyfat: ");
            int newBodyFat = input.nextInt();
            inbodies[index+1].setBodyFatMassKG(newBodyFat);

            System.out.println("Enter Your Minerals: ");
            int newMinerals = input.nextInt();
            inbodies[index+1].setMineralsKG(newMinerals);

            System.out.println("Enter Your Body Water: ");
            int newBodyWater = input.nextInt();
            inbodies[index+1].setTotalBodyWater(newBodyWater);
            System.out.println("Enter Your Protein: ");
            int newProtein = input.nextInt();
            inbodies[index+1].setProteinKG(newProtein);
            System.out.println("Enter today's date: ");
            String Input = input.nextLine();
            inbodies[index+1].setDate(Input);

        }
    }

}

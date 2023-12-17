package USERS;

import GYM.Equipment;
import GYM.GYM;
import SERVICES.InBody;
import SERVICES.Subscription;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
            if (this.subs[i]==null) {
                this.subs[i] = subs;
                break;
            }
        }
    }
    public int getCustomerID() {
        return customerID;
    }
//    public void setCustomerID(int customerID) {
//        this.customerID = customerID;
//    }

    public void CustomerMainMenu(){
        System.out.println(" You logged in successfully !");
        int choice;

        do{
            System.out.println("\t...........Main Menu...........");
            System.out.println("1. Your coach's information");
            System.out.println("2. Display all gym equipments");
            System.out.println("3. Membership plan details");
            System.out.println("4. Add new InBody");
            System.out.println("5. InBody info at specific date");
            System.out.println("6. Kilos to be reduced");
            System.out.println("7. Renewal");
            System.out.println("8. display info");
            System.out.println("9. Exit");
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
                    AddingInbody();
                    break;

                case 5:
                    System.out.println("Your inbody info:");
                    System.out.println("Enter the date (format: YYYY-MM-DD):");
                    String date=input.next();
                    displayInbodyByDate(date);
                    break;

                case 6:
                    displayWeightLoss();
                    break;

                case 7:
//                    System.out.println("\n\nEnter Subscription and Plan Details");
//                    System.out.println("\nEnter plan start date (yyyy-MM-dd): ");
//                    String inputStartDate = input.next();
                    //Define a DateTimeFormatter for the expected date format
                    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    //GYM.Subscription(getCustomerById(customerID),inputStartDate);
                    renewSubscription(Admin.getCustomerById(getCustomerID()));

                    break;

                case 8:
                    displayInfo();
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 9);

    } //checked


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
    } //checked

    //default 3shan de info lely f nfs el package bs
    @Override
    void displayInfo(){
        System.out.println("\n\t\tCustomer's Details : " + "\n---------------------------------------------------------------\n"
                + "\n\n> Id : " + getCustomerID() + "\n\n> Email : " + getEmail() + "\n\n> Name : " + getName() + "\n\n> Gender : " + getGender()
                + "\n\n> Phone Number : " + getPhoneNO()  +"\n---------------------------------------------------------------\n");
    } //checked


    public void displayEquips(){
        Equipment.displayEquipmentNames();
    } //checked

    //customer displaying his own history at a specific date
    public void displayInbodyByDate(String date) {
        System.out.println("Your InBody history for " + date + "\n------------------------------------\n");
        boolean exist=false;
        //parse the string date into a LocalDate in order to compare it in the step ahead
        LocalDate parsedDate = LocalDate.parse(date);
        for (int i=0;i<12;i++){
            if (inbodies[i]!=null){
                if (inbodies[i].getDate().equals(parsedDate)){
                    inbodies[i].displayInbody();
                    exist=true;
                }
            }
        }
        if (!exist) System.out.println("There is no InBody history for such date\n\n");
        System.out.println("Press enter to continue.....");
        input.nextLine();
        input.nextLine();
    } //checked

    public void displayYourCoachInfo(){
        int index=0;

        for(int i=0;i<12;i++){
            if(subs[i]==null){
                index=i-1;
                break;
            }
        }

        int coachID=subs[index].getCoachID();
        Coach myCoach=Coach.getCoachByID(coachID);
        assert myCoach != null;
        myCoach.displayInfoForCustomer();
        System.out.println("Press enter to continue.....");
        input.nextLine();
        input.nextLine();
    } //checked

    public void displayWeightLoss() {
        if (inbodies[0]!=null){
            int lastindex=0;
            double targetWeight;
            double weightLossPercentage;
            double weightLoss;

            for (int j = 0; j < 12; j++) {
                if (inbodies[j] != null) {
                    lastindex=j;

                } else {
                    break;
                }
            }
            double initialWeight=inbodies[lastindex].getTotalWeightKG();

            System.out.println("Your total weight now is: " + initialWeight);
            targetWeight = InBody.calculateTargetWeight(inbodies[lastindex].getHeightM());
            System.out.println("Your target weight is: " + targetWeight);
            weightLoss = initialWeight - targetWeight;
            System.out.println("The amount of kilos for Weight Loss: "+weightLoss);
            weightLossPercentage=(weightLoss/initialWeight)*100;
            System.out.println("The Percentage of weight loss to reach Desired Weight: "+weightLossPercentage + "%");
        }
        else System.out.println("No inbody registered yet!");

        System.out.println("Press enter to continue.....");
        input.nextLine();
        input.nextLine();
    } //checked

    public void displayPlan(){ //to display CURRENT plan
        int index = 0;

        for (int i = 0; i < 12; i++) {
            if (subs[i] != null) {
                index = i+1;
                break;
            }
        }

        System.out.println(index);

        //System.out.println(index-1);
        subs[index].plan.displayPlan();
        System.out.println("Press enter to continue.....");
        input.nextLine();
        input.nextLine();
    } //checked
    public void AddingInbody(){
        if (inbodies[0]!=null){
            int index=0;

            for(int i=0;i<12;i++){
                if(subs[i]==null){
                    index=i-1;
                    break;
                }
            }

            LocalDate today = LocalDate.now();
            long daysDifference = ChronoUnit.DAYS.between(inbodies[index].getDate(), today);
            if(daysDifference<30){
                int result = 30 - (int) daysDifference;
                System.out.println("SORRY,YOU CAN'T DO INBODY NOW BUT YOU CAN DO IN : "+result+" DAYS");

            }

            else if(daysDifference>30 || inbodies[index+1]==null){
                inbodies[index+1]=new InBody();
                System.out.println("Enter today's date (YYYY-MM-DD): ");
                String Input = input.next();
                inbodies[index+1].setDate(Input);

                System.out.println("Enter Your Height M : ");
                double  newHeight = input.nextDouble();
                inbodies[index+1].setHeightM(newHeight);

                System.out.println("Enter new Weight KG : ");
                double newWeight = input.nextDouble();
                inbodies[index+1].setTotalWeightKG(newWeight);

                System.out.println("Enter Your body fat KG : ");
                double newBodyFat = input.nextDouble();
                inbodies[index+1].setBodyFatMassKG(newBodyFat);

                System.out.println("Enter Your Minerals KG : ");
                double newMinerals = input.nextDouble();
                inbodies[index+1].setMineralsKG(newMinerals);

                System.out.println("Enter Your Body Water : ");
                double newBodyWater = input.nextDouble();
                inbodies[index+1].setTotalBodyWater(newBodyWater);

                System.out.println("Enter Protein KG : ");
                double newProtein = input.nextDouble();
                inbodies[index+1].setProteinKG(newProtein);
                System.out.println("InBody added successfully!");
            }
        }
        else {
            inbodies[0]=new InBody();
            System.out.println("Enter today's date (YYYY-MM-DD): ");
            String Input = input.next();
            inbodies[0].setDate(Input);

            System.out.println("Enter Height M : ");
            double  newHeight = input.nextDouble();
            inbodies[0].setHeightM(newHeight);

            System.out.println("Enter Weight KG : ");
            double newWeight = input.nextDouble();
            inbodies[0].setTotalWeightKG(newWeight);

            System.out.println("Enter body fat KG : ");
            double newBodyFat = input.nextDouble();
            inbodies[0].setBodyFatMassKG(newBodyFat);

            System.out.println("Enter Minerals KG : ");
            double newMinerals = input.nextDouble();
            inbodies[0].setMineralsKG(newMinerals);

            System.out.println("Enter Body Water : ");
            double newBodyWater = input.nextDouble();
            inbodies[0].setTotalBodyWater(newBodyWater);

            System.out.println("Enter Protein KG : ");
            double newProtein = input.nextDouble();
            inbodies[0].setProteinKG(newProtein);
            System.out.println("InBody added successfully!");
        }
    } //checked

    public void renewSubscription(Customer customer) {
        int index = 0;

        for (int i = 0; i < 12; i++) {
            if (subs[i] != null) {
                index = i+1;
                break;
            }
        }

        subs[index]=new Subscription();
        LocalDate currentdate= LocalDate.now();
        if(currentdate.isAfter(subs[index-1].plan.getEndDate())){
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


    //for admin, btgm3 start date for that customer in the iteration
    //de eh shoghletha ya mariam? m3rfsh
    public ArrayList<LocalDate> getSubscriptionsStartDate(){
        ArrayList<LocalDate> startDates = new ArrayList<>();
        for(int i=0;i<12;i++){
            if(subs[i]!=null){
                startDates.add(subs[i].plan.getStartDate());
            }
        }
        return startDates;
    }
}

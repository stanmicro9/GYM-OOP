package MAIN;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import javax.swing.*; //for GUI
import DATABASE.GymDataBase;
import GYM.Equipment;
import USERS.*;

public class Main extends JForm{ //mlkosh d3wa leha 3laqa bl GUI
    static Scanner in=new Scanner(System.in);
    public static int menu()
    {
        int choice;
        System.out.println("WELCOME TO GYM SYSTEM!\n");
        System.out.println("---------------------------\n");
        System.out.println("Main Menu\n");
        System.out.println("---------------------------\n");
        System.out.println("1-Register\n");
        System.out.println("2-Login\n\n" );
        System.out.println("Your choice: ");
        choice = in.nextInt();

        return choice;
    }
    public static void main(String[] args) {
        ArrayList<Customer> customerList = new ArrayList<>();
        ArrayList<Coach> coachList = new ArrayList<>();
        ArrayList<Equipment> equipmentList=new ArrayList<>();
        Admin admin = new Admin();
      /*  Coach newCoach = new Coach("Address", "Email", "Name", "Password", 'M', 123456789, 40, coachList);
        coachList.add(newCoach);
        Customer newCustomer = new Customer("Address2", "Email2", "Name2", "Password2", 'M', 123456789, 40, customerList);
        customerList.add(newCustomer);
        Equipment newEquipment = new Equipment("Address",  123456789, equipmentList);
        equipmentList.add(newEquipment);
*/


      int choice= menu();
        switch (choice){
            case 1:
                System.out.println("1. REGISTER AS COACH\n");
                System.out.println("2. REGISTER AS CUSTOMER\n");
                int choice2=in.nextInt();
                if(choice2==1){
                    //call l register as coach
                }
                else if (choice2==2){
                    //call  register customer
                }
                else{
                    System.out.println("INVALID CHOICE....\n please try again");
                    //3ayza arg3o y5tar tanyy
                }
                break;

            case 2:
                System.out.println("");

        }








  /*      //-----------------------------------
        int choice;
        String choice2;

        while (true)
        {
            choice = menu();

            if (choice == 1) // law el user e5tar register
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();

                System.out.println("Registration\t"+"(Press '0' to go back)"+"\n------------------------------------------\n");
                System.out.println("\nAre you a customer or a coach ? (Enter C or M) \n");
                choice2 = in.next();

                if (choice2.equals("C") || choice2.equals("c"))
                {
                    admin.addCustomer(customerList);
                }
                else if (choice2.equals("M") || choice2.equals("m"))
                {
                    admin.addCoach(coachList);
                }
                else if (choice2.equals("0"))
                {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    menu();
                }
                else
                {
                    System.out.println("Invalid choice,Try again!\n");
                }
                //system(pause)
                System.out.println("Press Any Key To Continue...");
                new java.util.Scanner(System.in).nextLine();
                //system(clear)
                System.out.print("\033[H\033[2J");
                System.out.flush();
                continue;
            }
            else if (choice == 2) // el user e5tar login
            {
                String username;
                String password;
                boolean CustomerStatus;
                boolean CoachStatus;
                boolean AdminStatus;
                //--------------------------------------------
                System.out.println("Login" + "\n-----------------------------\n");
                System.out.println("Enter Your Username: ");
                username = in.next();
                System.out.println("Enter Your Password: ");
                password = in.next();



                CustomerStatus = Customer.login(username, password);
                CoachStatus = Coach.login(username, password);
                AdminStatus = admin.adminLogin(username, password);

                if (CustomerStatus && !CoachStatus && !AdminStatus) {
                    //customermenu();
                } else if (!CustomerStatus && CoachStatus && !AdminStatus) {
                    //coachmenu();
                } else if (!CustomerStatus && !CoachStatus && AdminStatus) {
                    admin.AdminMainMenu(admin,customerList,coachList,equipmentList);
                } else
                {
                    System.out.println("Invalid Username,Try Again!\n");

                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    menu(); // hyrg3 tany lel main function 3shan ne3yd el process
                }


            }
            else
            {
                System.out.println("INVALID CHOICE");
                //system(pause)
                System.out.println("Press Any Key To Continue...");
                new java.util.Scanner(System.in).nextLine();
                //system(clear)
                System.out.print("\033[H\033[2J");
                System.out.flush();
                menu();
            }
        }*/

    }

    }

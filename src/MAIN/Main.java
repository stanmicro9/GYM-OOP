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
        menu();

        ArrayList<Customer> customerList = new ArrayList<>();
        ArrayList<Coach> coachList = new ArrayList<>();
        ArrayList<Equipment> equips=new ArrayList<>();
        Admin Admin=new Admin();


        Customer customer=new Customer("Tag Sultan","malakbatman@gmail.com","malak","shosho", 'f',011,20);
       Coach coach= new Coach("nozha","mariamsuperman@gmail.com","mariam","basbousa", 'f',010,8);
        coachList.add(coach);
        customerList.add(customer);
        Admin admin = new Admin();
        //-----------------------------------
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



                CustomerStatus = customer.login(username, password);
                CoachStatus = coach.login(username, password);
                AdminStatus = admin.adminLogin(username, password);

                if (CustomerStatus && !CoachStatus && !AdminStatus) {
                    //customermenu();
                } else if (!CustomerStatus && CoachStatus && !AdminStatus) {
                    //coachmenu();
                } else if (!CustomerStatus && !CoachStatus && AdminStatus) {
                    admin.AdminMainMenu(admin,customerList,coachList,equips);
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
        }

    }

    }

package MAIN;

import DATABASE.GymDataBase;
import GYM.GYM;
import SERVICES.Membership_plan;
import USERS.Admin;
import USERS.Coach;
import USERS.Customer;
import USERS.USER;
import java.util.Scanner;
import static GYM.GYM.input;
import static GYM.GYM.userList;
import static GYM.GYM.equipmentList;

public class Main extends JForm{


    public static void main(String[] args) {
        userList=GymDataBase.loadData("Users");
        equipmentList=GymDataBase.loadData("Equipments");

        Admin admin = new Admin();
        GYM gym = new GYM();

        int choice1;
        System.out.println("WELCOME TO GYM SYSTEM!\n");
        System.out.println("---------------------------\n");


        outerloop:
        while (true) {
            System.out.println("Main Menu");
            System.out.println("---------------------------");
            System.out.println("1- Register");
            System.out.println("2- Login");
            System.out.println("3- Exit Program\n");
            System.out.println("Your choice: ");
            choice1 = input.nextInt();

            switch (choice1) {
                case 1:
                    System.out.println("\n1. REGISTER AS COACH");
                    System.out.println("2. REGISTER AS CUSTOMER");
                    int choiceR = input.nextInt();
                    if (choiceR == 1) {
                        gym.regCoach();

                    } else if (choiceR == 2) {
                        gym.regCustomer();
                    } else {
                        System.out.println("INVALID CHOICE....\nPlease try again\n\n");

                    }
                    break;

                case 2:
                    System.out.println("1.LOG IN AS A USER");
                    System.out.println("2.LOG IN AS AN ADMIN");
                    int choiceL = input.nextInt();

                    if (choiceL == 1) {
                        System.out.println("\nUSERNAME: ");
                        String enteredUsername = input.next();
                        System.out.println("PASSWORD: ");
                        String enteredPassword = input.next();
                        USER enteredUser = USER.login(enteredUsername, enteredPassword);
                        if (enteredUser instanceof Customer) {
                            Customer enteredCustomer = (Customer) enteredUser; //down-casting
                            System.out.println("\n\nWelcome " + enteredUsername + "\n");
                            enteredCustomer.CustomerMainMenu();
                        } else if (enteredUser instanceof Coach) {
                            Coach enteredCoach = (Coach) enteredUser; //down-casting
                            System.out.println("\n\nWelcome " + enteredUsername + "\n");
                            enteredCoach.CoachMainMenu();
                        }
                    } else if (choiceL == 2) {
                        String enteredUsername = input.next();
                        String enteredPassword = input.next();
                        boolean checked = admin.adminLogin(enteredUsername, enteredPassword);
                        if (checked) admin.AdminMainMenu();
                        else {
                            System.out.println("\nIncorrect username or password, please try again.\n\n\n");
                        }
                    } else {
                        System.out.println("INVALID CHOICE....\n please try again\n\n\n");
                    }

                    break;

                case 3:
                    GymDataBase.saveData(userList, "Users");
                    GymDataBase.saveData(equipmentList, "Equipments");
                    System.out.println("Exiting program...");
                    break outerloop;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

 /*testing
   Coach newCoach = new Coach("Address", "Email", "Name", "Password", 'M', 123456789, 40, coachList);
        coachList.add(newCoach);
        Customer newCustomer = new Customer("Address2", "Email2", "Name2", "Password2", 'M', 123456789, 40, customerList);
        customerList.add(newCustomer);
        Equipment newEquipment = new Equipment("Address",  123456789, equipmentList);
        equipmentList.add(newEquipment);
*/



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

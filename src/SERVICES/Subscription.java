package SERVICES;

import USERS.*;
import SERVICES.Membership_plan;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Subscription {
    protected int customerID;
    protected int coachID;
    public Membership_plan plan;

    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public int getCoachID() {
        return coachID;
    }
    public void setCoachID(int coachID) {
        this.coachID = coachID;
    }

    public Subscription(int customerID, int coachID, Membership_plan plan){
        this.customerID=customerID;
        this.coachID=coachID;
        this.plan=plan;
    }
    public void displaySubscription(){
        System.out.println("Customer id : "+getCustomerID()+"\nCoach id : "+getCoachID()+"\nMembership_plan: ");
        plan.displayPlan();
    }

    public void renewSubscription() {
        LocalDate currentDate = LocalDate.now();

        if (currentDate.isAfter(plan.getEndDate())) {
            Scanner input = new Scanner(System.in);
            System.out.println("Your subscription has expired. Do you want to renew? (yes/no): ");
            String renewChoice = input.next();

            if ("yes".equalsIgnoreCase(renewChoice)) {
                // Handle the renewal logic here
                System.out.println("Subscription renewed successfully!");
            } else {
                System.out.println("Renewal cancelled.");
            }
        }
        else {
            throw new IllegalStateException("You cannot renew before your current subscription expires.");
        }
    }
}

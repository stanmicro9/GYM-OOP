package SERVICES;
import USERS.*;

import SERVICES.Membership_plan;

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
}

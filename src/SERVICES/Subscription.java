package SERVICES;
import USERS.*;

import SERVICES.Membership_plan;

public class Subscription {
    protected int customerID;
    protected int coachID;
    public Membership_plan plan;

    public Subscription(int customerID,int coachID,Membership_plan plan){
        this.customerID=customerID;
        this.coachID=coachID;
        this.plan=plan;
    }
}

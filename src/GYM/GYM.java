package GYM;
import USERS.*;
import SERVICES.*;

import java.util.ArrayList;

public class GYM {
    public String name="";
    public String address;
    public int phoneNumber;
    public Equipment[] equips=new Equipment[50];
    ArrayList<Coach> coachList = new ArrayList<>();
    private Subscription[] subs=new Subscription[50];

    public Subscription[] getSubs() {
        return subs;
    }

    public void setSubs(Subscription[] subs) {
        this.subs = subs;
    }
}

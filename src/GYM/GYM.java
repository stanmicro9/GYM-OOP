package GYM;
import USERS.*;
import SERVICES.*;
import java.util.ArrayList;

public class GYM {
    public String name="";
    public String address;
    public int phoneNumber;
    public ArrayList<Equipment> equips;
    public ArrayList<Coach> coachlist;
    private Subscription[] subs=new Subscription[50];

    public Subscription[] getSubs() {
        return subs;
    }

    public void setSubs(Subscription[] subs) {
        this.subs = subs;
    }
}

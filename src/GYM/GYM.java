package GYM;
import USERS.*;
import SERVICES.*;

public class GYM {
    public String name;
    public String address;
    public int phoneNumber;
    public Equipment[] equips=new Equipment[50];
    public Coach[] coaches=new Coach[50];
    private Subscription[] subs=new Subscription[50];

    public Subscription[] getSubs() {
        return subs;
    }

    public void setSubs(Subscription[] subs) {
        this.subs = subs;
    }
}

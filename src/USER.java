import com.sun.jdi.event.StepEvent;

public abstract class USER {

    private int ID;
    private String address;
    private String email;
    private String pass;
    protected String name;
    protected char gender;
    protected int phoneNO;



    public USER(String address, String email, String name, String pass, char gender, int phoneNO){
        this.address=address;
        this.email=email;
        this.name=name;
        this.pass=pass;
        this.gender=gender;
        this.phoneNO=phoneNO;

    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    //mmkn nshelhum
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public int getPhoneNO() {
        return phoneNO;
    }
    public void setPhoneNO(int phoneNO) {
        this.phoneNO = phoneNO;
    }

    public abstract void login(String username, String password);
    public abstract void displayInfo(int ID);

}

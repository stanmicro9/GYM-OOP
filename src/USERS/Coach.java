package USERS;

public class Coach extends USER {
    protected int workingHours;
    public Coach(int ID,String address, String email, String name, String pass, char gender, int phoneNO,int workingHours){
        super(address, email, name, pass, gender, phoneNO);
        this.workingHours=workingHours;
    }
    public void displayInfo(int ID){
        System.out.println("USERS.Coach's ID: "+ getID());
        System.out.println("USERS.Coach's address: "+ getAddress());
        System.out.println("USERS.Coach's email: "+ getEmail());
        System.out.println("USERS.Coach's name: "+ getName());
        System.out.println("USERS.Coach's password: "+ getPass());
        System.out.println("USERS.Coach's gender: "+ getGender());
        System.out.println("USERS.Coach's phone number: "+ getPhoneNO());
        System.out.println("USERS.Coach's working hours: "+workingHours);
    }

    public  void login(String username, String password){

    }
}

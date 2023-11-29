public class Coach extends USER{
    protected int workingHours;
    public Coach(String address, String email, String name, String pass, char gender, int phoneNO,int workingHours){
        super(address, email, name, pass, gender, phoneNO);
        this.workingHours=workingHours;
    }
    public void displayInfo(int ID){
        System.out.println("Coach's ID: "+ getID());
        System.out.println("Coach's address: "+ getAddress());
        System.out.println("Coach's email: "+ getEmail());
        System.out.println("Coach's name: "+ getName());
        System.out.println("Coach's password: "+ getPass());
        System.out.println("Coach's gender: "+ getGender());
        System.out.println("Coach's phone number: "+ getPhoneNO());
        System.out.println("Coach's working hours: "+workingHours);
    }
}

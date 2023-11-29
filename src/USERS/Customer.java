package USERS;

public class Customer extends USER {

    protected InBody[] inbodies= new InBody[50];
    protected Subscription[] subs=new Subscription[50];
    private int age;
    public Customer(int ID,String address, String email, String name, String pass, char gender, int phoneNO,int age){
        super(address, email, name, pass, gender, phoneNO);
        this.age=age;
    }
    public void displayInfo(int ID){
        System.out.println("USERS.Customer's ID: "+getID());
        System.out.println("USERS.Customer's address: "+ getAddress());
        System.out.println("USERS.Customer's email: "+ getEmail());
        System.out.println("USERS.Customer's name: "+ getName());
        System.out.println("USERS.Customer's password: "+ getPass());
        System.out.println("USERS.Customer's gender: "+ getGender());
        System.out.println("USERS.Customer's phone number: "+ getPhoneNO());
    }
    public  void login(String username, String password){

    }
}

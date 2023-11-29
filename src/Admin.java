import java.util.*;
public class Admin{
    private String username="mariam";
    private String pass="mariam";
    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public boolean adminLogin(String name, String password){
        boolean loginSuccessful = false;
        if(name.equals(username)){
            if(password.equals(pass)){
                loginSuccessful= true;
            }
        }
        return loginSuccessful;
    }


    public void addCoach(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Coach's address: ");
        String Caddress=input.next();
        System.out.println("Enter Coach's email: ");
        String Cemail=input.next();
        System.out.println("Enter Coach's pass: ");
        String Cpass=input.next();
        System.out.println("Enter Coach's name: ");
        String Cname=input.next();
        System.out.println("Enter Coach's gender (F/M): ");
        char Cgender=input.next().charAt(0);
        System.out.println("Enter Coach's phone number: ");
        int CphoneNo=input.nextInt();
        System.out.println("Enter Coach's working hours (max 10): ");
        int CworkingHours=input.nextInt();
        input.close();

        Coach newCoach=new Coach(Caddress,Cemail,Cpass,Cname,Cgender,CphoneNo,CworkingHours);
        //f array wla files?
    }
    public void addCustomer(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Customer's address: ");
        String CusAddress=input.next();
        System.out.println("Enter Customer's email: ");
        String CusEmail=input.next();
        System.out.println("Enter Customer's pass: ");
        String CusPass=input.next();
        System.out.println("Enter Customer's name: ");
        String CusName=input.next();
        System.out.println("Enter Customer's gender (F/M): ");
        char CusGender=input.next().charAt(0);
        System.out.println("Enter Customer's phone number: ");
        int CusPhoneNo=input.nextInt();
        System.out.println("Enter Customer's age: ");
        int CusAge=input.nextInt();
        input.close();

        Customer newCustomer=new Customer(CusAddress,CusEmail,CusPass,CusName,CusGender,CusPhoneNo,CusAge);
        //f array wla files?
    }
    public void addEquip(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter equipment's name: ");
        String newEquipName=input.next();
        System.out.println("Enter equipment's code: ");
        int newEquipCode=input.nextInt();
        input.close();

        Equipment newEquipment=new Equipment(newEquipName,newEquipCode);
        //f array wla file?
    }
    public void editCoach(int coachID){
        Scanner input=new Scanner(System.in);
        System.out.println("Please enter your id: ");
        int id= input.nextInt();
        Coach c=new Coach();
        c.displayInfo(id);


    }
    public void editCustomer(int customerID){

    }
    public void editEquip(int EquipCode){

    }
    public void deleteCoach(){

    }
    public void deleteCustomer(){

    }
    public void deleteEquip(){

    }

}

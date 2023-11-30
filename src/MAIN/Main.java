package MAIN;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import GYM.Equipment;
import USERS.*;
public class Main {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        ArrayList<USER> users = new ArrayList<>();
        Admin admin = new Admin();
        System.out.println("username :");
        String user=in.next();
        System.out.println("password :");
        String pass=in.next();
        if(admin.adminLogin(user,pass)){
            admin.AdminMainMenu(admin,users);
        }else{
            System.out.println("Wrong data,please try again..");
        }




    }
}
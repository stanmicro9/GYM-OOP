package MAIN;

import USERS.Admin;
import USERS.USER;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        Admin A =new Admin();
        System.out.println("Username :");
        String user=in.next();
        System.out.println("password :");
        String password=in.next();
         A.adminLogin(user,password);
         if( A.adminLogin(user,password)){
             A.addCustomer();
         }


    }
}
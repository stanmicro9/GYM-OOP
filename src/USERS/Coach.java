package USERS;

import java.util.ArrayList;

public class Coach extends USER {
    int workingHours;
    private static int counter=0;
    protected static int coachID;

    public Coach(String address, String email, String name, String pass, char gender, int phoneNO,int workingHours){
        super(address, email, name, pass, gender, phoneNO);
        counter++;
        coachID=counter;
        this.workingHours=workingHours;
    }

    public void setCoachID(int coachID) {
        this.coachID = coachID;
    }
    public int getCoachID() {
        return coachID;
    }

    public static Coach getCoachByID(ArrayList<Coach> coachList, int coachId) {
        for (Coach coach : coachList) {
            if (coach.getCoachID() == coachId) {
                return coach; // Return the coach if ID matches
            }
        }
        return null; // Return null if coach with given ID is not found
    }


    //default 3shan de info lely f nfs el package bs
    @Override
    String displayInfo(int ID){
        return "\n\t\tCoach's Details : " + "\n---------------------------------------------------------------\n"
                + "\n\n> Id : " + getCoachID() + "\n\n> Email : " + getEmail() + "\n\n> Name : " + getName() + "\n\n> Gender : " + getGender()
                + "\n\n> Phone Number : " + getPhoneNO() + "\n\n> Working Hours : " + workingHours +"\n---------------------------------------------------------------\n" ;
    }
    public int getWorkingHrs() {
        return workingHours;
    }
    public void setWorkingHrs(int workingHours) { this.workingHours = workingHours; }

    @Override
    public boolean login(String username, String password){

        return false;
    }
}

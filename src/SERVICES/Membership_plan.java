package SERVICES;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Membership_plan {
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected int monthlyPlan;
    protected int numOfMonths;
    protected double price = 0;

    public Membership_plan(String startDate, int monthlyPlan, int numOfMonths) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.startDate = LocalDate.parse(startDate, formatter);
        this.monthlyPlan = monthlyPlan;
        this.numOfMonths = numOfMonths;
        calculateEndDate();
        price=calculatePlanPrice(numOfMonths,monthlyPlan);
    }

    public LocalDate  getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }

    public int getMonthlyPlan() {
        return monthlyPlan;
    }

    public void setMonthlyPlan(int monthlyPlan) {
        this.monthlyPlan = monthlyPlan;
    }

    public int getNumOfMonths() {
        return numOfMonths;
    }

    public void setNumOfMonths(int numOfMonths) {
        this.numOfMonths = numOfMonths;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int planOptions() {
        Scanner choice=new Scanner(System.in);
        int planChoice;
        do {
            System.out.println("\n\nChoose a plan Bundle:");
            System.out.println("1. BUNDLE1---> 3 days/months");
            System.out.println("2. BUNDLE2---> 6 days/months");
            planChoice=choice.nextInt();
            if (planChoice==1) return 3;
            else if (planChoice==2) return 6;

        } while (!(planChoice==1 || planChoice==2));

        return -1; //would never happen
    }

    public void displayPlan() {
        System.out.println("\nMonthly Plan\n\n");
        System.out.println("\nStart Date: " + getStartDate());
        System.out.println("\nNumber of Months: " + getNumOfMonths());
        System.out.println("\nDays per week: " + getMonthlyPlan());
        System.out.println("\nPrice: " + getPrice() + "$");
    }

    private void calculateEndDate() {
        if (numOfMonths > 0) {
            endDate = startDate.plusMonths(numOfMonths);
        } else {
            throw new IllegalArgumentException("Invalid number of months. Please enter a positive value.");
        }
    }

    public double calculatePlanPrice(int months,int Bundle){
        if (Bundle==3){
            setPrice(months*800);
            for (int i=1;i<13;i++){
                if (i==months){
                    if (i>=3 && i<=6)
                        setPrice(i*(800-(0.15 * 800)));

                    else if (i>6 && i<=9)
                        setPrice(i*(800-(0.25 * 800)));

                    else if (i>9 && i<=12)
                        setPrice(i*(800-(0.50 * 800)));
                }
            }
            if (months>12) {
                setNumOfMonths(12);
                setPrice(12*(800-(0.50 * 800)));
            }
            else if (months<1) {
                setNumOfMonths(1);
            }
        }

        else if (Bundle==6){
            setPrice(months*1600);
            for (int i=1;i<13;i++){
                if (i==months){
                    if (i>=3 && i<=6)
                        setPrice(i*(1600-(0.15 * 1600)));

                    else if (i>6 && i<=9)
                        setPrice(i*(1600-(0.25 * 1600)));

                    else if (i>9 && i<=12)
                        setPrice(i*(1600-(0.50 * 1600)));
                }
            }
            if (months>12) {
                setNumOfMonths(12);
                setPrice(12*(1600-(0.50 * 1600)));
            }
            else if (months<1) {
                setNumOfMonths(1);
            }
        }
        return getPrice();
    }



    // Getter for endDate
    // Other methods and attributes remain the same

    public static void main(String[] args) {
        Membership_plan plan = new Membership_plan("1 december", 0, 0);
        Scanner scanner = new Scanner(System.in);

        //plan.PlanOptions();
        int choice = scanner.nextInt();

        if (choice == 1) {
            plan.setNumOfMonths(3);
            plan.setMonthlyPlan(3);
        } else if (choice == 2) {
            plan.setNumOfMonths(6);
            plan.setMonthlyPlan(6);
        } else {
            System.out.println("Invalid choice. Exiting...");
            return;
        }

        System.out.println("Selected Plan:");
        plan.displayPlan();
    }
    //ana katba el main hena 3shan khoft ahotaha hnak ma3 el zahma//
//seboha f halha law smahto//
//okay babe enty bra7tek <3
}

package SERVICES;

import java.util.Scanner;

public class Membership_plan {
    protected int startDate;
    protected int monthlyPlan;
    protected int numOfMonths;
    protected int price = 0;

    public Membership_plan(int startDate, int monthlyPlan, int numOfMonths) {
        this.startDate = startDate;
        this.monthlyPlan = monthlyPlan;
        this.numOfMonths = numOfMonths;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void displayPlanOptions() {
        System.out.println("Choose a plan duration:");
        System.out.println("1. 3 months");
        System.out.println("2. 6 months");
    }

    public void displayPlan() {
        System.out.println("Monthly Plan");
        System.out.println("Start Date: " + getStartDate());
        System.out.println("Number of Months: " + getNumOfMonths());
        System.out.println("Days per week: " + getMonthlyPlan());
        System.out.println("Price: $" + getPrice());
    }

    public static void main(String[] args) {
        Membership_plan plan = new Membership_plan(1, 0, 0);
        Scanner scanner = new Scanner(System.in);

        plan.displayPlanOptions();
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
}
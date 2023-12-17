package SERVICES;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static GYM.GYM.input;

public class Membership_plan implements Serializable{
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getMonthlyPlan() {
        return monthlyPlan;
    }

    public LocalDate getEndDate() {
        return endDate;
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
        int planChoice;
        do {
            System.out.println("\n\nChoose a plan Bundle:");
            System.out.println("1. BUNDLE1---> 3 days/months");
            System.out.println("2. BUNDLE2---> 6 days/months");
            planChoice=input.nextInt();

            if (planChoice==1) return 3;
            else if (planChoice==2) return 6;

        } while (!(planChoice==1 || planChoice==2));

        return -1; //would never happen
    } //checked

    public void displayPlan() {
        System.out.println("\nMonthly Plan\n\n");
        System.out.println("\nStart Date: " + getStartDate());
        System.out.println("\nNumber of Months: " + getNumOfMonths());
        System.out.println("\nDays per week: " + getMonthlyPlan());
        System.out.println("\nPrice: " + getPrice() + "$");
    }

    public void calculateEndDate() {
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

}

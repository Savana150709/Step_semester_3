package Inheritance.assignment_problems;
import java.util.Scanner;

abstract class Customer {
    protected double amount;
    public Customer(double amount) {
        this.amount = amount;
    }
    public abstract double calculateFinalAmount();
}

class Student extends Customer {
    public Student(double amount) { super(amount); }
    @Override public double calculateFinalAmount() { return amount * 0.90; }
}

class Staff extends Customer {
    public Staff(double amount) { super(amount); }
    @Override public double calculateFinalAmount() { return amount * 0.95; }
}

class Guest extends Customer {
    public Guest(double amount) { super(amount); }
    @Override public double calculateFinalAmount() { return amount + 10.0; }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Customer customer;

            switch (type) {
                case "STUDENT": customer = new Student(amount); break;
                case "STAFF": customer = new Staff(amount); break;
                case "GUEST": customer = new Guest(amount); break;
                default: continue;
            }

            double finalAmount = customer.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f\n", type, finalAmount);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}

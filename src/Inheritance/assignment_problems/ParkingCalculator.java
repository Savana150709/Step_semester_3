package Inheritance.assignment_problems;
import java.util.Scanner;

abstract class Vehicle {
    protected int hours;
    public Vehicle(int hours) { this.hours = hours; }
    public abstract double calculateCharge();
}

class Bike extends Vehicle {
    public Bike(int hours) { super(hours); }
    @Override public double calculateCharge() { return hours * 10.0; }
}

class Car extends Vehicle {
    public Car(int hours) { super(hours); }
    @Override public double calculateCharge() {
        return hours == 1 ? 30.0 : 30.0 + (hours - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    public Truck(int hours) { super(hours); }
    @Override public double calculateCharge() {
        return Math.max(100.0, hours * 50.0);
    }
}

public class ParkingCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            Vehicle vehicle;

            switch (type) {
                case "BIKE": vehicle = new Bike(hours); break;
                case "CAR": vehicle = new Car(hours); break;
                case "TRUCK": vehicle = new Truck(hours); break;
                default: continue;
            }

            double charge = vehicle.calculateCharge();
            grandTotal += charge;
            System.out.printf("%s: %.2f\n", type, charge);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}

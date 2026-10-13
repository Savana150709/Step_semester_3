package Inheritance.assignment_problems;
import java.util.Scanner;

abstract class Room {
    protected int units;
    public Room(int units) { this.units = units; }
    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) { super(units); }
    @Override public double calculateBill() { return units * 8.0; }
}

class SharedRoom extends Room {
    private int occupants;
    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }
    @Override public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class AcRoom extends Room {
    public AcRoom(int units) { super(units); }
    @Override public double calculateBill() {
        return (units * 10.0) + 200.0;
    }
}

public class HostelElectricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Room room;

            if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                room = new SharedRoom(units, occupants);
            } else if (type.equals("AC")) {
                room = new AcRoom(units);
            } else {
                room = new SingleRoom(units);
            }

            double bill = room.calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f\n", type, bill);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}

package Abstraction.class_problems;
import java.util.Scanner;

abstract class Connection {
    protected int units;
    public Connection(int units) { this.units = units; }
    public abstract double calculateBill();
}

class HomeConnection extends Connection {
    public HomeConnection(int units) { super(units); }
    @Override public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
}

class ShopConnection extends Connection {
    public ShopConnection(int units) { super(units); }
    @Override public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

class FactoryConnection extends Connection {
    public FactoryConnection(int units) { super(units); }
    @Override public double calculateBill() {
        return Math.max(1000.0, units * 6.0);
    }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Connection conn;

            if (type.equals("HOME")) {
                conn = new HomeConnection(units);
            } else if (type.equals("SHOP")) {
                conn = new ShopConnection(units);
            } else {
                conn = new FactoryConnection(units);
            }

            double bill = conn.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f\n", type, bill);
        }
        System.out.printf("Total: %.2f\n", total);
    }
}

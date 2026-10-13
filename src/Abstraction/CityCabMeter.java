package Abstraction;
import java.util.Scanner;

interface NightService {
    double applyNightSurcharge(double fare);
}

abstract class Cab {
    protected double km;
    protected String time;

    public Cab(double km, String time) {
        this.km = km;
        this.time = time;
    }

    public abstract double getRatePerKm();

    public double calculateBaseFare() {
        double fare = km * getRatePerKm();
        return Math.max(100.0, fare);
    }
}

class MiniCab extends Cab {
    public MiniCab(double km, String time) { super(km, time); }
    @Override public double getRatePerKm() { return 10.0; }
}

class SedanCab extends Cab implements NightService {
    public SedanCab(double km, String time) { super(km, time); }
    @Override public double getRatePerKm() { return 14.0; }
    @Override public double applyNightSurcharge(double fare) { return time.equals("NIGHT") ? fare * 1.20 : fare; }
}

class SuvCab extends Cab implements NightService {
    public SuvCab(double km, String time) { super(km, time); }
    @Override public double getRatePerKm() { return 18.0; }
    @Override public double applyNightSurcharge(double fare) { return time.equals("NIGHT") ? fare * 1.20 : fare; }
}

public class CityCabMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String cabType = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;
            if (cabType.equals("MINI")) {
                cab = new MiniCab(km, time);
            } else if (cabType.equals("SEDAN")) {
                cab = new SedanCab(km, time);
            } else {
                cab = new SuvCab(km, time);
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(cabType + ": night service not available");
                continue;
            }

            double fare = cab.calculateBaseFare();
            if (cab instanceof NightService) {
                fare = ((NightService) cab).applyNightSurcharge(fare);
            }

            total += fare;
            System.out.printf("%s: %.2f\n", cabType, fare);
        }
        System.out.printf("Total: %.2f\n", total);
    }
}

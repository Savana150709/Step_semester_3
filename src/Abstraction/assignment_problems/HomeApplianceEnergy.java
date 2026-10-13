package Abstraction.assignment_problems;
import java.util.Scanner;

interface SaverModeSupport {
    double applySaverMode(double units);
}

abstract class Appliance {
    protected double hours;
    protected String mode;

    public Appliance(double hours, String mode) {
        this.hours = hours;
        this.mode = mode;
    }

    public abstract double getPowerWatts();

    public double calculateUnits() {
        return (getPowerWatts() * hours) / 1000.0;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours, String mode) { super(hours, mode); }
    @Override public double getPowerWatts() { return 150.0; }
}

class AcAppliance extends Appliance implements SaverModeSupport {
    public AcAppliance(double hours, String mode) { super(hours, mode); }
    @Override public double getPowerWatts() { return 1500.0; }
    @Override public double applySaverMode(double units) { return units * 0.75; }
}

class TvAppliance extends Appliance {
    public TvAppliance(double hours, String mode) { super(hours, mode); }
    @Override public double getPowerWatts() { return 100.0; }
}

class Washer extends Appliance implements SaverModeSupport {
    public Washer(double hours, String mode) { super(hours, mode); }
    @Override public double getPowerWatts() { return 500.0; }
    @Override public double applySaverMode(double units) { return units * 0.75; }
}

public class HomeApplianceEnergy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            String mode = sc.hasNext("SAVER") ? sc.next() : "NORMAL";

            Appliance app;
            if (type.equals("FRIDGE")) {
                app = new Fridge(hours, mode);
            } else if (type.equals("AC")) {
                app = new AcAppliance(hours, mode);
            } else if (type.equals("TV")) {
                app = new TvAppliance(hours, mode);
            } else {
                app = new Washer(hours, mode);
            }

            if (mode.equals("SAVER") && !(app instanceof SaverModeSupport)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = app.calculateUnits();
            if (mode.equals("SAVER") && app instanceof SaverModeSupport) {
                units = ((SaverModeSupport) app).applySaverMode(units);
            }

            double cost = units * 8.0;
            totalCost += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f\n", type, units, cost);
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
    }
}
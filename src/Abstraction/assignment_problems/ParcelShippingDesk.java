package Abstraction.assignment_problems;
import java.util.Scanner;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }
    @Override public double calculateCharge() { return 40.0 + (10.0 * weightKg); }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }
    @Override public double calculateCharge() { return 80.0 + (15.0 * weightKg); }
    @Override public double calculateInsurance(double declaredValue) { return 0.02 * declaredValue; }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }
    @Override public double calculateCharge() { return (40.0 + (10.0 * weightKg)) + 50.0; }
    @Override public double calculateInsurance(double declaredValue) { return 0.02 * declaredValue; }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel parcel;
            if (type.equals("STANDARD")) {
                parcel = new StandardParcel(weight, value);
            } else if (type.equals("EXPRESS")) {
                parcel = new ExpressParcel(weight, value);
            } else {
                parcel = new FragileParcel(weight, value);
            }

            double charge = parcel.calculateCharge();
            double insurance = 0.0;
            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel).calculateInsurance(value);
            }
            double total = charge + insurance;
            grandTotal += total;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", type, charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
    }
}

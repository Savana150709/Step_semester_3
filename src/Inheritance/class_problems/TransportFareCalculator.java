package Inheritance.class_problems;
import java.util.*;
abstract class TransportJourney {
    protected double distance;

    public TransportJourney(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
}
class BusJourney extends TransportJourney {
    public BusJourney(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0); // Max fare capped at 10.0
    }
}

class TrainJourney extends TransportJourney {
    public TrainJourney(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class MetroJourney extends TransportJourney {
    private double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        double baseCalc = 1.50 + (0.20 * distance);
        return baseCalc * peakHourFactor;
    }
}
class TransportFactory {
    public static TransportJourney createJourney(String[] parts) {
        String type = parts[0].toUpperCase();
        double distance = Double.parseDouble(parts[1]);

        switch (type) {
            case "BUS":
                return new BusJourney(distance);
            case "TRAIN":
                return new TrainJourney(distance);
            case "METRO":
                double peakFactor = Double.parseDouble(parts[2]);
                return new MetroJourney(distance, peakFactor);
            default:
                throw new IllegalArgumentException("Unknown transport type: " + type);
        }
    }
}

public class TransportFareCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<String> types = new ArrayList<>();
        List<TransportJourney> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            types.add(parts[0]);
            journeys.add(TransportFactory.createJourney(parts));
        }

        double grandTotalFare = 0.0;
        for (int i = 0; i < n; i++) {
            double fare = journeys.get(i).calculateFare();
            grandTotalFare += fare;
            System.out.printf("%s: %.2f\n", types.get(i), fare);
        }

        System.out.printf("Total: %.2f\n", grandTotalFare);
        sc.close();
    }
}
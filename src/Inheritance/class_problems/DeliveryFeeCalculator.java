package Inheritance.class_problems;
import java.util.*;

// Abstract Base Class
abstract class DeliveryRequest {
    protected double weight;
    protected double distance;

    public DeliveryRequest(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();
}

// Concrete Implementations
class StandardDelivery extends DeliveryRequest {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends DeliveryRequest {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 15.0 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery extends DeliveryRequest {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

// Factory Pattern
class DeliveryFactory {
    public static DeliveryRequest createDelivery(String[] parts) {
        String type = parts[0].toUpperCase();
        double weight = Double.parseDouble(parts[1]);
        double distance = Double.parseDouble(parts[2]);

        switch (type) {
            case "STANDARD":
                return new StandardDelivery(weight, distance);
            case "EXPRESS":
                return new ExpressDelivery(weight, distance);
            case "INTERNATIONAL":
                double customsFee = Double.parseDouble(parts[3]);
                return new InternationalDelivery(weight, distance, customsFee);
            default:
                throw new IllegalArgumentException("Unknown delivery type: " + type);
        }
    }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<String> types = new ArrayList<>();
        List<DeliveryRequest> deliveries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            types.add(parts[0]);
            deliveries.add(DeliveryFactory.createDelivery(parts));
        }

        double grandTotalFee = 0.0;
        for (int i = 0; i < n; i++) {
            double fee = deliveries.get(i).calculateFee();
            grandTotalFee += fee;
            System.out.printf("%s: %.2f\n", types.get(i), fee);
        }

        System.out.printf("Total: %.2f\n", grandTotalFee);
        sc.close();
    }
}

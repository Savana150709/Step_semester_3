package Abstraction.class_problems;
import java.util.Scanner;

abstract class TravelBooking {
    protected double distanceKm;
    protected static final double BOOKING_FEE = 50.0; // Written in one place

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract double calculateBaseFare();

    public double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) { super(distanceKm); }
    @Override public double calculateBaseFare() { return distanceKm * 2.0; }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) { super(distanceKm); }
    @Override public double calculateBaseFare() { return distanceKm * 1.5; }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) { super(distanceKm); }
    @Override public double calculateBaseFare() { return 2500.0 + (distanceKm * 4.0); }
}

public class TravelBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            TravelBooking booking;

            if (mode.equals("BUS")) {
                booking = new BusBooking(distance);
            } else if (mode.equals("TRAIN")) {
                booking = new TrainBooking(distance);
            } else {
                booking = new FlightBooking(distance);
            }

            double total = booking.calculateTotal();
            System.out.printf("%s: %.2f\n", mode, total);
        }
    }
}

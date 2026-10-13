package Abstraction.assignment_problems;
import java.util.Scanner;

abstract class MovieTicket {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.0; // Written in one place

    public MovieTicket(int count) {
        this.count = count;
    }

    public abstract double getTicketPrice();

    public double calculateTotal() {
        return (getTicketPrice() + CONVENIENCE_FEE) * count;
    }
}

class RegularTicket extends MovieTicket {
    public RegularTicket(int count) { super(count); }
    @Override public double getTicketPrice() { return 150.0; }
}

class PremiumTicket extends MovieTicket {
    public PremiumTicket(int count) { super(count); }
    @Override public double getTicketPrice() { return 250.0; }
}

class ReclinerTicket extends MovieTicket {
    public ReclinerTicket(int count) { super(count); }
    @Override public double getTicketPrice() { return 400.0; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            MovieTicket ticket;

            if (seat.equals("REGULAR")) {
                ticket = new RegularTicket(count);
            } else if (seat.equals("PREMIUM")) {
                ticket = new PremiumTicket(count);
            } else {
                ticket = new ReclinerTicket(count);
            }

            double amount = ticket.calculateTotal();
            totalCollected += amount;
            System.out.printf("%s: %.2f\n", seat, amount);
        }
        System.out.printf("Total: %.2f\n", totalCollected);
    }
}

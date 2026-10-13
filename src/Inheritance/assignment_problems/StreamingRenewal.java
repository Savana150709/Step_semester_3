package Inheritance.assignment_problems;
import java.time.LocalDate;
import java.util.Scanner;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;
    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }
    public abstract LocalDate calculateRenewalDate();
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override public LocalDate calculateRenewalDate() { return startDate.plusDays(30); }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override public LocalDate calculateRenewalDate() { return startDate.plusDays(90); }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override public LocalDate calculateRenewalDate() { return startDate.plusDays(365); }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());
            SubscriptionPlan plan;

            switch (type) {
                case "BASIC": plan = new BasicPlan(name, startDate); break;
                case "STANDARD": plan = new StandardPlan(name, startDate); break;
                case "PREMIUM": plan = new PremiumPlan(name, startDate); break;
                default: continue;
            }

            LocalDate renewalDate = plan.calculateRenewalDate();
            System.out.println(name + ": " + renewalDate);
        }
    }
}

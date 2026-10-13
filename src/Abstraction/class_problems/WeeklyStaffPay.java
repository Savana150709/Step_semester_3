package Abstraction.class_problems;
import java.util.Scanner;

abstract class StaffMember {
    protected String name;
    public StaffMember(String name) { this.name = name; }
    public abstract double calculatePay();
}

class FullTimeStaff extends StaffMember {
    private double weeklySalary;
    public FullTimeStaff(String name, double weeklySalary) { super(name); this.weeklySalary = weeklySalary; }
    @Override public double calculatePay() { return weeklySalary; }
}

class HourlyStaff extends StaffMember {
    private double hours, rate;
    public HourlyStaff(String name, double hours, double rate) { super(name); this.hours = hours; this.rate = rate; }
    @Override public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * rate * 1.5);
        }
    }
}

class InternStaff extends StaffMember {
    private double stipend;
    public InternStaff(String name, double stipend) { super(name); this.stipend = stipend; }
    @Override public double calculatePay() { return stipend; }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalPayroll = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            StaffMember staff;

            if (type.equals("FULLTIME")) {
                staff = new FullTimeStaff(name, sc.nextDouble());
            } else if (type.equals("HOURLY")) {
                staff = new HourlyStaff(name, sc.nextDouble(), sc.nextDouble());
            } else {
                staff = new InternStaff(name, sc.nextDouble());
            }

            double pay = staff.calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f\n", name, pay);
        }
        System.out.printf("Total Payroll: %.2f\n", totalPayroll);
    }
}

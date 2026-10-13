package Abstraction.assignment_problems;
import java.util.Scanner;

interface BusUser {
    double getTransportFee();
}

abstract class Student {
    protected String name;
    public Student(String name) { this.name = name; }
    public abstract double calculateTuition();
}

class DayScholar extends Student implements BusUser {
    public DayScholar(String name) { super(name); }
    @Override public double calculateTuition() { return 40000.0; }
    @Override public double getTransportFee() { return 12000.0; }
}

class Hosteller extends Student {
    public Hosteller(String name) { super(name); }
    @Override public double calculateTuition() { return 40000.0 + 60000.0; }
}

class ScholarStudent extends Student implements BusUser {
    public ScholarStudent(String name) { super(name); }
    @Override public double calculateTuition() { return 20000.0; }
    @Override public double getTransportFee() { return 12000.0; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student student;

            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else {
                student = new ScholarStudent(name);
            }

            double fee = student.calculateTuition();
            if (student instanceof BusUser) {
                fee += ((BusUser) student).getTransportFee();
            }

            totalCollected += fee;
            System.out.printf("%s: %.2f\n", name, fee);
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
    }
}

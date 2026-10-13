package Inheritance.assignment_problems;
import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double salary;
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double salary) { super(name, salary); }
    @Override public double calculateBonus() { return salary * 0.10; }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double salary) { super(name, salary); }
    @Override public double calculateBonus() { return salary * 0.05; }
}

class Intern extends Employee {
    public Intern(String name, double salary) { super(name, salary); }
    @Override public double calculateBonus() { return 2000.0; }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            Employee emp;

            switch (type) {
                case "FULLTIME": emp = new FullTimeEmployee(name, salary); break;
                case "PARTTIME": emp = new PartTimeEmployee(name, salary); break;
                case "INTERN": emp = new Intern(name, salary); break;
                default: continue;
            }

            double bonus = emp.calculateBonus();
            grandTotal += bonus;
            System.out.printf("%s: %.2f\n", name, bonus);
        }
        System.out.printf("Total Bonus: %.2f\n", grandTotal);
    }
}

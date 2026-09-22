package Encapsulation.class_problems;

public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    public String getId() {
        return this.id;
    }

    public double getSavings() {
        return this.savings;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.savings += amount;
            System.out.println("deposit(" + (int)amount + ") -> savings = " + (int)this.savings);
        }
    }

    public void withdraw(double amount) {
        if (amount > this.savings) {
            System.out.println("withdraw(" + (int)amount + ") -> rejected, savings stays " + (int)this.savings);
        } else if (amount > 0) {
            this.savings -= amount;
            System.out.println("withdraw(" + (int)amount + ") -> savings = " + (int)this.savings);
        }
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
    }
}

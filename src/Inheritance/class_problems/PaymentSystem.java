package Inheritance.class_problems;

import java.util.*;

abstract class PaymentMethod {
    protected double amount;

    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    public abstract double calculateAdjustedAmount();
}
class CardPayment extends PaymentMethod {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.02; // 2% fee
    }
}

class WalletPayment extends PaymentMethod {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.01; // 1% fee
    }
}

class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount; // No fee
    }
}

class PaymentFactory {
    public static PaymentMethod createPayment(String type, double amount) {
        switch (type.toUpperCase()) {
            case "CARD":
                return new CardPayment(amount);
            case "WALLET":
                return new WalletPayment(amount);
            case "BANKTRANSFER":
                return new BankTransferPayment(amount);
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        List<String> types = new ArrayList<>();
        List<PaymentMethod> transactions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            types.add(type);
            transactions.add(PaymentFactory.createPayment(type, amount));
        }

        double grandTotal = 0.0;
        for (int i = 0; i < n; i++) {
            double adjustedAmount = transactions.get(i).calculateAdjustedAmount();
            grandTotal += adjustedAmount;
            System.out.printf("%s: %.2f\n", types.get(i), adjustedAmount);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}

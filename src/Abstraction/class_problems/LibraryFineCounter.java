package Abstraction.class_problems;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;
    public LibraryItem(String title, int daysLate) { this.title = title; this.daysLate = daysLate; }
    public abstract double calculateFine();
}

class Book extends LibraryItem {
    public Book(String title, int daysLate) { super(title, daysLate); }
    @Override public double calculateFine() { return daysLate * 2.0; }
}

class Dvd extends LibraryItem {
    public Dvd(String title, int daysLate) { super(title, daysLate); }
    @Override public double calculateFine() { return Math.min(50.0, daysLate * 5.0); }
}

class Magazine extends LibraryItem {
    public Magazine(String title, int daysLate) { super(title, daysLate); }
    @Override public double calculateFine() { return daysLate * 1.0; }
}

public class LibraryFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalFines = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();
            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title, daysLate);
            } else if (type.equals("DVD")) {
                item = new Dvd(title, daysLate);
            } else {
                item = new Magazine(title, daysLate);
            }

            double fine = item.calculateFine();
            totalFines += fine;
            System.out.printf("%s: %.2f\n", title, fine);
        }
        System.out.printf("Total Fines: %.2f\n", totalFines);
    }
}

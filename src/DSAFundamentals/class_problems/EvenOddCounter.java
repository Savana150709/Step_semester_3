package DSAFundamentals.class_problems;
import java.util.Scanner;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // Clean and parse array input like [3, 8, 12, 5, 7, 10]
        input = input.replaceAll("[\\[\\]\\s]", "");
        if (input.isEmpty()) return;

        String[] parts = input.split(",");
        int evenCount = 0, oddCount = 0;

        for (String part : parts) {
            int num = Integer.parseInt(part);
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);
    }
}

package DSAFundamentals.class_problems;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String word = sc.next();
            String reversed = new StringBuilder(word).reverse().toString();

            if (word.equalsIgnoreCase(reversed)) {
                System.out.println(word + " - palindrome");
            } else {
                System.out.println(reversed + " - not a palindrome");
            }
        }
    }
}

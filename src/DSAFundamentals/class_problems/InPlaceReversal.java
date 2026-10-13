package DSAFundamentals.class_problems;
import java.util.Arrays;
import java.util.Scanner;

public class InPlaceReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        input = input.replaceAll("[\\[\\]\\s]", "");
        if (input.isEmpty()) {
            System.out.println("[]");
            return;
        }

        String[] parts = input.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        // In-place reversal using two pointers
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        System.out.println(Arrays.toString(arr));
    }
}

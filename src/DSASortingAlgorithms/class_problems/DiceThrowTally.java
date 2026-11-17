package DSASortingAlgorithms.class_problems;
import java.util.Arrays;

public class DiceThrowTally {

    public static int[] diceSort(int[] rolls) {
        // Step 1: Create a count array of size 7 to store frequencies of numbers 1 to 6
        int[] count = new int[7];

        for (int roll : rolls) {
            if (roll >= 1 && roll <= 6) {
                count[roll]++;
            }
        }

        // Step 2: Print the counts for each number from 1 to 6
        System.out.print("Counts: ");
        for (int v = 1; v <= 6; v++) {
            System.out.print(v + ":" + count[v] + " ");
        }
        System.out.println();

        // Step 3: Reconstruct the sorted array based on the counts
        int[] sortedRolls = new int[rolls.length];
        int index = 0;

        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sortedRolls[index++] = v;
            }
        }

        return sortedRolls;
    }

    public static void main(String[] args) {
        // Sample Input
        int[] rolls1 = {4, 1, 6, 4, 2, 1, 4};
        System.out.println("--- Sample Input ---");
        int[] result1 = diceSort(rolls1);
        System.out.println("Sorted: " + Arrays.toString(result1));

        // Custom Input
        int[] customRolls = {3, 5, 2, 3, 6, 1, 3, 5};
        System.out.println("\n--- Custom Input ---");
        int[] resultCustom = diceSort(customRolls);
        System.out.println("Sorted: " + Arrays.toString(resultCustom));
    }
}
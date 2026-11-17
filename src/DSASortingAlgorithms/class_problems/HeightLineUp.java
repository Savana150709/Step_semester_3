package DSASortingAlgorithms.class_problems;
import java.util.Arrays;

public class HeightLineUp {

    public static void lineUp(int[] heights) {
        int pass = 1;
        boolean swapped;

        do {
            swapped = false;
            for (int j = 0; j < heights.length - 1; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            pass++;

        } while (swapped);
    }

    public static void main(String[] args) {
        System.out.println("--- Sample Input 1 ---");
        int[] heights1 = {4, 2, 5, 1};
        lineUp(heights1);

        System.out.println("\n--- Sample Input 2 ---");
        int[] heights2 = {1, 3, 2, 4};
        lineUp(heights2);

        System.out.println("\n--- Custom Input ---");
        int[] customHeights = {5, 3, 1, 4, 2};
        lineUp(customHeights);
    }
}
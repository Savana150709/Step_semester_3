package DSAFundamentals.assignment_problems;
import java.util.Arrays;

public class BusiestBusRow {

    public static int[] busiestRow(int[][] grid) {
        int maxTotal = -1;
        int bestRowIndex = 0;

        for (int i = 0; i < grid.length; i++) {
            int currentRowTotal = 0;
            for (int j = 0; j < grid[i].length; j++) {
                currentRowTotal += grid[i][j];
            }

            // Strictly greater ensures that in case of a tie,
            // the earlier (smaller index) row is retained.
            if (currentRowTotal > maxTotal) {
                maxTotal = currentRowTotal;
                bestRowIndex = i;
            }
        }

        return new int[] { bestRowIndex, maxTotal };
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 0, 1},
                {3, 3, 1},
                {1, 1, 1}
        };

        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}

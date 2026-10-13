package DSAFundamentals.assignment_problems;
import java.util.Arrays;

public class ExamScoreBandCounter {

    // Find the first index where score >= target
    private static int findFirstGreaterThanOrEqual(int[] scores, int target) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Find the first index where score > target
    private static int findFirstGreaterThan(int[] scores, int target) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int countInBand(int[] scores, int low, int high) {
        int startIndex = findFirstGreaterThanOrEqual(scores, low);
        int endIndex = findFirstGreaterThan(scores, high);
        return endIndex - startIndex;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        System.out.println(countInBand(scores, 42, 58)); // Expected: 6
        System.out.println(countInBand(scores, 90, 100)); // Expected: 0
    }
}

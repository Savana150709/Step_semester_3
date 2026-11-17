package DSASortingAlgorithms.class_problems;
public class QueueOrderChecker {

    public static int firstBreak(int[] tokens) {
        if (tokens == null || tokens.length <= 1) {
            return -1;
        }

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i; // Returns the index of the first token smaller than the one before it
            }
        }

        return -1; // Returns -1 if the queue is in order
    }

    public static void main(String[] args) {
        // Sample Input 1
        int[] tokens1 = {3, 5, 5, 8, 6, 9};
        int result1 = firstBreak(tokens1);
        System.out.println("Sample 1 Result Index: " + result1); // Expected: 4

        // Sample Input 2
        int[] tokens2 = {1, 2, 2, 7};
        int result2 = firstBreak(tokens2);
        System.out.println("Sample 2 Result Index: " + result2); // Expected: -1

        // Custom Input
        int[] customTokens = {4, 7, 7, 10, 8, 12, 11};
        int resultCustom = firstBreak(customTokens);
        System.out.println("Custom Input Result Index: " + resultCustom); // Expected: 4 (8 comes after 10)
    }
}
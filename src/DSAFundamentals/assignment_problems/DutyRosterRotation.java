package DSAFundamentals.assignment_problems;
import java.util.Arrays;

public class DutyRosterRotation {

    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        k = k % n; // Remove full turns to avoid redundant shifts

        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            rotated[newIndex] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        String[] names1 = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names1, 2))); // [D, E, A, B, C]

        String[] names2 = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names2, 7))); // [D, E, A, B, C]
    }
}

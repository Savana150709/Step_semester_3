package DSASortingAlgorithms.class_problems;
import java.util.Arrays;

public class LibraryBookShelf {

    public static void shelf(int[] books) {
        for (int i = 1; i < books.length; i++) {
            int key = books[i];
            int j = i - 1;
            while (j >= 0 && books[j] > key) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = key;
            System.out.println("After placing " + key + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Sample Input ---");
        int[] books1 = {30, 10, 40, 20};
        shelf(books1);

        System.out.println("\n--- Custom Input ---");
        int[] customBooks = {50, 20, 40, 10, 30};
        shelf(customBooks);
    }
}
package Inheritance.class_problems;
import java.util.*;
import java.time.LocalDate;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract int getBorrowDurationDays();

    public String calculateDueDate(LocalDate startDate) {
        LocalDate dueDate = startDate.plusDays(getBorrowDurationDays());
        return dueDate.toString();
    }
}
class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    @Override
    public int getBorrowDurationDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }

    @Override
    public int getBorrowDurationDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    @Override
    public int getBorrowDurationDays() {
        return 3;
    }
}
class LibraryItemFactory {
    public static LibraryItem createItem(String type, String title) {
        switch (type.toUpperCase()) {
            case "BOOK":
                return new Book(title);
            case "DVD":
                return new DVD(title);
            case "MAGAZINE":
                return new Magazine(title);
            default:
                throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }
}

public class LibraryDueDate {
    private static final LocalDate BASE_DATE = LocalDate.parse("2023-10-26");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = Integer.parseInt(sc.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String type = line.substring(0, line.indexOf(" ")).trim();
            String title = line.substring(line.indexOf(" ") + 1).replace("\"", "").trim();

            items.add(LibraryItemFactory.createItem(type, title));
        }

        for (LibraryItem item : items) {
            System.out.printf("%s: %s\n", item.getTitle(), item.calculateDueDate(BASE_DATE));
        }

        sc.close();
    }
}

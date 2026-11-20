package DSA.class_problems;
// File Name: BookCopyFinder.java
public class BookCopyFinder {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static String find(Node head, String id) {
        int position = 1;
        int firstPosition = -1;
        int copies = 0;

        Node current = head;
        while (current != null) {
            if (current.data != null && current.data.equals(id)) {
                if (firstPosition == -1) {
                    firstPosition = position;
                }
                copies++;
            }
            position++;
            current = current.next;
        }

        if (copies == 0) {
            return id + " not found";
        }
        return id + " first at position " + firstPosition + ", copies: " + copies;
    }

    public static Node build(String[] books) {
        if (books == null || books.length == 0) {
            return null;
        }
        Node head = new Node(books[0]);
        Node current = head;
        for (int i = 1; i < books.length; i++) {
            current.next = new Node(books[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        String[] books = {"B12", "B07", "B30", "B07", "B45", "B07"};
        Node trolley = build(books);

        // Sample 1
        System.out.println(find(trolley, "B07"));

        // Sample 2
        System.out.println(find(trolley, "B99"));
    }
}
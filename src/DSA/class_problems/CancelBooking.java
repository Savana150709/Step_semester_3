package DSA.class_problems;
// File Name: CancelBooking.java
public class CancelBooking {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node removeFirst(Node head, String booking) {
        if (head == null) {
            System.out.println(booking + " not found");
            return null;
        }

        // Case 1: Match is at the head
        if (head.data != null && head.data.equals(booking)) {
            return head.next;
        }

        // Case 2: Search for match after head, stopping at the node just before it
        Node current = head;
        while (current.next != null) {
            if (current.next.data != null && current.next.data.equals(booking)) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }

        // Case 3: Not found
        System.out.println(booking + " not found");
        return head;
    }

    public static Node build(String[] bookings) {
        if (bookings == null || bookings.length == 0) {
            return null;
        }
        Node head = new Node(bookings[0]);
        Node current = head;
        for (int i = 1; i < bookings.length; i++) {
            current.next = new Node(bookings[i]);
            current = current.next;
        }
        return head;
    }

    public static void printChain(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Sample 1
        Node b1 = build(new String[]{"104", "101", "107", "101"});
        b1 = removeFirst(b1, "101");
        printChain(b1);

        // Sample 2
        Node b2 = build(new String[]{"104", "101", "107"});
        b2 = removeFirst(b2, "104");
        printChain(b2);

        // Sample 3
        Node b3 = build(new String[]{"104", "101"});
        b3 = removeFirst(b3, "200");
        printChain(b3);
    }
}
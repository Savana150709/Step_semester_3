package DSA.class_problems;
public class BusRoute {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node build(String[] stops) {
        if (stops == null || stops.length == 0) {
            return null;
        }

        Node head = new Node(stops[0]);
        Node current = head;

        for (int i = 1; i < stops.length; i++) {
            current.next = new Node(stops[i]);
            current = current.next;
        }

        return head;
    }

    public static void printRoute(Node head) {
        if (head == null) {
            System.out.println("null");
            System.out.println("Stops: 0, First: none, Last: none");
            return;
        }

        String first = head.data;
        String last = head.data;
        int count = 0;

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            last = current.data;
            count++;
            current = current.next;
        }
        System.out.println("null");
        System.out.println("Stops: " + count + ", First: " + first + ", Last: " + last);
    }

    public static void main(String[] args) {
        String[] sample1 = {"Tambaram", "Guindy", "TNagar", "Central"};
        Node route1 = build(sample1);
        printRoute(route1);

        String[] sample2 = {"Potheri"};
        Node route2 = build(sample2);
        printRoute(route2);
    }
}

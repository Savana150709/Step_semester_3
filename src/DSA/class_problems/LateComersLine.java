package DSA.class_problems;
// File Name: LateComersLine.java
public class LateComersLine {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node addFirst(Node head, String name) {
        Node newNode = new Node(name);
        newNode.next = head;
        return newNode;
    }

    public static Node addLast(Node head, String name) {
        Node newNode = new Node(name);
        if (head == null) {
            return newNode;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public static void printLine(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Sample 1: line = Asha -> Ravi
        Node line1 = null;
        line1 = addLast(line1, "Asha");
        line1 = addLast(line1, "Ravi");

        line1 = addFirst(line1, "Neha");
        line1 = addLast(line1, "Kiran");
        line1 = addFirst(line1, "Mohan");
        printLine(line1);

        // Sample 2: line = (empty)
        Node line2 = null;
        line2 = addLast(line2, "Pooja");
        line2 = addFirst(line2, "Arun");
        printLine(line2);
    }
}
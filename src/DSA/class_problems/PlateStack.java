package DSA.class_problems;
// File Name: PlateStack.java
public class PlateStack {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public PlateStack() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(String plate) {
        Node newNode = new Node(plate);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("push " + plate + " -> top " + head.data + ", size " + size);
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("pop -> stack is empty");
            return null;
        }
        String popped = head.data;
        head = head.next;
        size--;
        System.out.println("pop -> " + popped + ", size " + size);
        return popped;
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("peek -> stack is empty");
            return null;
        }
        System.out.println("peek -> " + head.data);
        return head.data;
    }

    public static void main(String[] args) {
        PlateStack stack = new PlateStack();
        stack.push("P1");
        stack.push("P2");
        stack.peek();
        stack.pop();
        stack.push("P3");
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("isEmpty -> " + stack.isEmpty());
    }
}
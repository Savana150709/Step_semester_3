package Encapsulation.assignment_problems;

public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public String getId() {
        return this.id;
    }

    public String getColor() {
        return this.color;
    }

    public void next() {
        if (this.color.equals("RED")) {
            this.color = "GREEN";
        } else if (this.color.equals("GREEN")) {
            this.color = "YELLOW";
        } else if (this.color.equals("YELLOW")) {
            this.color = "RED";
        }
        System.out.println("t.next() -> \"" + this.color + "\"");
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("t.getColor() -> \"" + t.getColor() + "\"");
        t.next();
        t.next();
        t.next();
    }
}

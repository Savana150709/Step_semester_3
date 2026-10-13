package Abstraction.class_problems;
import java.util.Scanner;

abstract class Plot {
    protected String owner;
    public Plot(String owner) { this.owner = owner; }
    public abstract double calculateArea();
}

class CirclePlot extends Plot {
    private double radius;
    public CirclePlot(String owner, double radius) { super(owner); this.radius = radius; }
    @Override public double calculateArea() { return Math.PI * radius * radius; }
}

class RectanglePlot extends Plot {
    private double length, width;
    public RectanglePlot(String owner, double length, double width) { super(owner); this.length = length; this.width = width; }
    @Override public double calculateArea() { return length * width; }
}

class TrianglePlot extends Plot {
    private double base, height;
    public TrianglePlot(String owner, double base, double height) { super(owner); this.base = base; this.height = height; }
    @Override public double calculateArea() { return 0.5 * base * height; }
}

public class GardenPlotReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalArea = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            Plot plot;

            if (shape.equals("CIRCLE")) {
                plot = new CirclePlot(owner, sc.nextDouble());
            } else if (shape.equals("RECTANGLE")) {
                plot = new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble());
            } else {
                plot = new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble());
            }

            double area = plot.calculateArea();
            totalArea += area;
            System.out.printf("%s (%s): %.2f\n", owner, shape, area);
        }
        System.out.printf("Total Area: %.2f\n", totalArea);
    }
}

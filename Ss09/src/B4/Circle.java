package B4;

import java.util.Scanner;

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    public void setRadius(Scanner sc) {
        System.out.print("Radius: ");
        this.radius = sc.nextDouble();
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
    public void display() {
        System.out.println("Radius: " + this.radius);
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
    }
}

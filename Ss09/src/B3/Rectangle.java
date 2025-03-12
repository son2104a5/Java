package B3;

import java.util.Scanner;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public void setWidthHeight(Scanner sc) {
        System.out.print("Width: ");
        this.width = sc.nextDouble();
        System.out.print("Height: ");
        this.height = sc.nextDouble();
    }

    public double getArea() {
        return width * height;
    }
    public double getPerimeter() {
        return 2 * (width + height);
    }
    public void display() {
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
}

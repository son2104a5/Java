package B10;

public class Circle extends Shape {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Hình tròn: " + name + ", Bán kính: " + radius +
                ", Diện tích: " + calculateArea() +
                ", Chu vi: " + calculatePerimeter();
    }
}


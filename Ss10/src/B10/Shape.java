package B10;

public class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    public double calculateArea() {
        return 0.0;
    }

    public double calculatePerimeter() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Hình: " + name + ", Diện tích: " + calculateArea() + ", Chu vi: " + calculatePerimeter();
    }
}


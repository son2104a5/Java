package B10;

public class Triangle extends Shape {
    private double a, b, c;

    public Triangle(String name, double a, double b, double c) {
        super(name);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculateArea() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return "Tam giác: " + name +
                ", Cạnh a: " + a + ", b: " + b + ", c: " + c +
                ", Diện tích: " + calculateArea() +
                ", Chu vi: " + calculatePerimeter();
    }
}


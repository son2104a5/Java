package B10;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Hình chữ nhật: " + name +
                ", Rộng: " + width + ", Cao: " + height +
                ", Diện tích: " + calculateArea() +
                ", Chu vi: " + calculatePerimeter();
    }
}


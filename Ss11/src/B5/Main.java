package B5;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        Square square = new Square(3.5);

        circle.setColor("Red");
        rectangle.setColor("Blue");
        square.setColor("Green");

        circle.displayInfo();
        rectangle.displayInfo();
        square.displayInfo();
    }
}
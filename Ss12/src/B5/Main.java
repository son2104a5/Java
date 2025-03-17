package B5;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];

        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Square(3);

        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Diện tích hình " + (i + 1) + ": " + shapes[i].area());
        }
    }
}


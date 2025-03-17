package B4;

public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Circle(5);
        Shape shape2 = new Rectangle(4, 6);

        System.out.println("Overriding - Diện tích hình tròn: " + shape1.area());
        System.out.println("Overriding - Diện tích hình chữ nhật: " + shape2.area());

        Shape shape = new Shape();
        System.out.println("Overloading - Diện tích hình tròn (radius = 7): " + shape.area(7));
        System.out.println("Overloading - Diện tích hình chữ nhật (4 x 8): " + shape.area(4, 8));
    }
}

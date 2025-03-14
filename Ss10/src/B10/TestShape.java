package B10;

public class TestShape {
    public static void main(String[] args) {
        Shape circle = new Circle("Hình tròn A", 5.0);
        Shape rectangle = new Rectangle("Hình chữ nhật B", 4.0, 6.0);
        Shape triangle = new Triangle("Tam giác C", 3.0, 4.0, 5.0);

        System.out.println("=== Thông tin từng hình ===");
        System.out.println(circle.toString());
        System.out.println(rectangle.toString());
        System.out.println(triangle.toString());

        System.out.println("\n=== Duyệt danh sách hình ===");
        Shape[] shapes = {circle, rectangle, triangle};
        for (Shape shape : shapes) {
            System.out.println(">> " + shape.name);
            System.out.println("Diện tích: " + shape.calculateArea());
            System.out.println("Chu vi: " + shape.calculatePerimeter());
            System.out.println();
        }
    }
}


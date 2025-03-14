package B5;

public class TestShape {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Cylinder cylinder = new Cylinder(5, 8);

        System.out.println("Area: " + circle.getArea());
        System.out.println("Volume: " + cylinder.getVolume());
    }
}

package B5;

public class Circle {
    private double radius;

    public Circle () {}
    public Circle (double radius) {
        this.radius = radius;
    };

    public double getRadius () {
        return radius;
    }

    public void setRadius (double radius) {
        this.radius = radius;
    }

    public double getArea () {
        return Math.PI * radius * radius;
    }
}

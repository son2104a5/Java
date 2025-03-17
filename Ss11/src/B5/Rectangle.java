package B5;

public class Rectangle implements Colorable {
    private double width;
    private double height;
    private String color;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public void displayInfo() {
        System.out.println("Rectangle - Width: " + width + ", Height: " + height + ", Color: " + color);
    }
}


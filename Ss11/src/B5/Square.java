package B5;

public class Square implements Colorable {
    private double side;
    private String color;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public void displayInfo() {
        System.out.println("Square - Side: " + side + ", Color: " + color);
    }
}
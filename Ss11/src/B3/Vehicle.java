package B3;

public class Vehicle {
    private String name;
    private int speed;

    public Vehicle () {}

    public Vehicle(String name, int speed) {}

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getSpeed () {
        return speed;
    }

    public void setSpeed (int speed) {
        this.speed = speed;
    }

    public void displayInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Speed: " + getSpeed());
    }

    public void start() {
        System.out.println("Vehicle is starting.....");
    }
}

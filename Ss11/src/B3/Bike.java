package B3;

public class Bike extends Vehicle {
    public Bike () {
    }

    public Bike (String name, int speed) {
        super(name, speed);
    }

    public void displayInfo() {
        System.out.println("Name: " + super.getName());
        System.out.println("Speed: " + super.getSpeed());
    }
}

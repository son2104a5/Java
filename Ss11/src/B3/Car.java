package B3;

public class Car extends Vehicle {
    public Car () {
    }

    public Car (String name, int speed) {
        super(name, speed);
    }

    public void displayInfo() {
        System.out.println("Name: " + super.getName());
        System.out.println("Speed: " + super.getSpeed());
    }
}

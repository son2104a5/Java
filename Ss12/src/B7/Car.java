package B7;

public class Car extends Vehicle {
    @Override
    public String move() {
        return "Car is moving fast";
    }

    @Override
    public String sound() {
        return "Vroom";
    }
}


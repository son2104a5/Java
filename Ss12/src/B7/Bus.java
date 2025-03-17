package B7;

public class Bus extends Vehicle {
    @Override
    public String move() {
        return "Bus is moving at medium speed";
    }

    @Override
    public String sound() {
        return "Honk Honk";
    }
}


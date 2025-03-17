package B9;

public class Bike extends Vehicle {
    public Bike(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println(name + " di chuyển chậm.");
    }

    @Override
    public void sound() {
        System.out.println(name + " phát ra âm thanh: Ring Ring");
    }
}


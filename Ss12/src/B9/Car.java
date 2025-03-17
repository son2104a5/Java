package B9;

public class Car extends Vehicle {
    public Car(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println(name + " di chuyển nhanh trên mặt đất.");
    }

    @Override
    public void sound() {
        System.out.println(name + " phát ra âm thanh: Vroom");
    }
}


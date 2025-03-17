package B9;

public class Bus extends Vehicle {
    private int seats;

    public Bus(String name, int seats) {
        super(name);
        this.seats = seats;
    }

    @Override
    public void move() {
        System.out.println(name + " di chuyển với tốc độ trung bình trên mặt đất. Số ghế: " + seats);
    }

    @Override
    public void sound() {
        System.out.println(name + " phát ra âm thanh: Honk");
    }
}


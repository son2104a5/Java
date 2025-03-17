package B9;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("Xe hơi");
        Vehicle bike = new Bike("Xe đạp");
        Vehicle bus = new Bus("Xe buýt", 45);
        Vehicle airplane = new Airplane("Máy bay", 10000);

        Vehicle[] vehicles = {car, bike, bus, airplane};

        System.out.println("=== Mô phỏng hành động và âm thanh của phương tiện ===");
        for (Vehicle v : vehicles) {
            v.move();
            v.sound();
            System.out.println();
        }

        System.out.println("=== Tính khoảng cách di chuyển bằng Overloading ===");
        car.move(2, 80);
        bike.move(3, 15);
        bus.move(1, 60);
        airplane.move(5, 700);
    }
}

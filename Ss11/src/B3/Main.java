package B3;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Bike bike = new Bike();

        car.setName("Lamboghini Aventador");
        car.setSpeed(360);
        bike.setName("Thống nhất");
        bike.setSpeed(10);

        car.start();
        car.displayInfo();
        bike.start();
        bike.displayInfo();
    }
}

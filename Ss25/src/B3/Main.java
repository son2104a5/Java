package B3;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car.CarBuilder()
                .setEngine("V8 Turbo")
                .setSeats(4)
                .setColor("Red")
                .build();

        Car car2 = new Car.CarBuilder()
                .setEngine("Electric")
                .setSeats(2)
                .setColor("Blue")
                .build();

        System.out.println(car1);
        System.out.println(car2);
    }
}

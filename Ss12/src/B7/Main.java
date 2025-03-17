package B7;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car();
        vehicles[1] = new Bike();
        vehicles[2] = new Bus();

        for (Vehicle v : vehicles) {
            System.out.println("Move: " + v.move());
            System.out.println("Sound: " + v.sound());
            System.out.println("------------------------");
        }
    }
}

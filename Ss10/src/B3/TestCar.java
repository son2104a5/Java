package B3;

import java.time.LocalDateTime;
import java.util.Scanner;

public class TestCar {
    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now();
        int currentYear = today.getYear();
        Scanner sc = new Scanner(System.in);
        Car car = new Car("Toyota", "Corrola", 2012);
        System.out.println(car.getMake());
        System.out.println(car.getModel());
        System.out.println(car.getYear());

        System.out.print("Nhập năm: ");
        car.setYear(sc.nextInt(), currentYear);
    }
}

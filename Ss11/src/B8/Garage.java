package B8;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private List<Car> cars;

    public Garage() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void operateCars() {
        for (Car car : cars) {
            car.start();
            car.stop();
            if (car instanceof Refuelable) {
                ((Refuelable) car).refuel();
            }
            System.out.println();
        }
    }
}

package B8;

public abstract class Car {
    protected String model;
    protected int year;
    protected double price;

    public Car(String model, int year, double price) {
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public abstract void start();
    public abstract void stop();
}


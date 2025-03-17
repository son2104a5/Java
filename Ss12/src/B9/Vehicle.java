package B9;

public abstract class Vehicle {
    protected String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public abstract void move();
    public abstract void sound();

    public void move(int time, int speed) {
        int distance = time * speed;
        System.out.println(name + " đã di chuyển được " + distance + " km trong " + time + " giờ với tốc độ " + speed + " km/h.");
    }
}
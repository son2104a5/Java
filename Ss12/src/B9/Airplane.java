package B9;

public class Airplane extends Vehicle {
    private int altitude;

    public Airplane(String name, int altitude) {
        super(name);
        this.altitude = altitude;
    }

    @Override
    public void move() {
        System.out.println(name + " bay trên không trung ở độ cao " + altitude + " mét.");
    }

    @Override
    public void sound() {
        System.out.println(name + " phát ra âm thanh: Whoosh");
    }
}


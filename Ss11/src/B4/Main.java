package B4;

public class Main {
    public static void main(String[] args) {
        Electronic[] devices = new Electronic[3];
        devices[0] = new TV();
        devices[1] = new Radio();
        devices[2] = new TV();

        System.out.println("=== Bật thiết bị ===");
        for (Electronic device : devices) {
            device.turnOn();
        }

        System.out.println("\n=== Tắt thiết bị ===");
        for (Electronic device : devices) {
            device.turnOff();
        }
    }
}


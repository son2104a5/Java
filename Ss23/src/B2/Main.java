package B2;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable(), "ThreadB2");
        thread.start();
    }
}

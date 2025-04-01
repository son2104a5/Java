package B4;

public class Main {
    public static void main(String[] args) {
        NumberThread thread1 = new NumberThread();
        MyThread thread2 = new MyThread("Thread 2 đang chạy....");
        MyThread thread3 = new MyThread("Thread 3 đang chạy....");
        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
        thread3.start();
    }
}

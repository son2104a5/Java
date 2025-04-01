package B3;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new AlphabetThread(sharedResource);
        Thread thread2 = new AlphabetThread(sharedResource);

        System.out.println("Luồng 1:");
        thread1.start();

        System.out.println("Luồng 2:");
        thread2.start();
    }
}

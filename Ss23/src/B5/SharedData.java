package B5;

public class SharedData {
    private String message;
    private boolean hasMessage = false;

    public synchronized void writeMessage(String msg) {
        while (hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        message = msg;
        hasMessage = true;
        System.out.println("Writer: Đã gửi tin nhắn - " + msg);
        notify();
    }

    public synchronized void readMessage() {
        while (!hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Reader: Đã nhận tin nhắn - " + message);
        hasMessage = false;
        notify();
    }
}

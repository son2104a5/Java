package B6;

public class Main {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Thread 1");
        MyThread thread2 = new MyThread("Thread 2");
        MyThread thread3 = new MyThread("Thread 3");

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

// => Độ ưu tiên của luồng không đảm bảo 100% thứ tự thực hiện, vì:
// - Độ ưu tiên chỉ là một gợi ý, không phải là một quy tắc bắt buộc.
// - Bộ lập lịch của JVM không đảm bảo rằng luồng có mức ưu tiên cao sẽ chạy trước.
// - Hệ thống xử lý luồng còn phụ thuộc vào hệ điều hành, số lõi CPU, tải hệ thống, và cách JVM lập lịch.

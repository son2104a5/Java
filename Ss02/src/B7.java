import java.util.Scanner;

public class B7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập thời gian ban đầu (giờ phút giây): ");
        int hour1 = sc.nextInt();
        int minute1 = sc.nextInt();
        int second1 = sc.nextInt();

        System.out.print("Nhập thời gian cần cộng (giờ phút giây): ");
        int hour2 = sc.nextInt();
        int minute2 = sc.nextInt();
        int second2 = sc.nextInt();

        int totalSeconds1 = hour1 * 3600 + minute1 * 60 + second1;
        int totalSeconds2 = hour2 * 3600 + minute2 * 60 + second2;
        int totalSeconds = totalSeconds1 + totalSeconds2;

        int finalHour = totalSeconds / 3600;
        int finalMinute = (totalSeconds % 3600) / 60;
        int finalSecond = totalSeconds % 60;

        System.out.printf("Tổng thời gian: %d giờ %d phút %d giây\n", finalHour, finalMinute, finalSecond);

        sc.close();
    }
}

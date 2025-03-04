import java.util.Scanner;

public class B6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month = sc.nextInt();

        switch (month) {
            case 1, 3, 5 ,7, 8, 10, 12:
                System.out.println("Có 31 ngày");
                break;
            case 4, 6, 9, 11:
                System.out.println("Có 30 ngày");
                break;
            case 2:
                System.out.println("Có 28 hoặc 29 ngày");
                break;
            default:
                System.out.println("Tháng không hợp lệ");
                break;
        }
    }
}

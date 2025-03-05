import java.util.Scanner;

public class B3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Số không hợp lệ");
        } else {
            System.out.printf("Bảng cửu chương %d:\n", n);
            for (int i = 1; i <= 10; i++) {
                System.out.printf("%d x %d = %d\n", n, i, n*i);
            }
        }
    }
}

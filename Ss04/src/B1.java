import java.util.Scanner;

public class B1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số nguyên: ");
        int n = sc.nextInt();
        int result = 0;

        if (n <= 0) {
            System.out.println("Số nhập vào không hợp lệ");
        } else {
            for (int i = 0; i < n; i++) {
                result += i+1;
            }
        }
        System.out.printf("Tổng các số từ 1 đến %d là: %d", n, result);
    }
}

import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        do {
            System.out.print("Nhập số phần tử của mảng: ");
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Kích thước không hợp lệ");
            }
        } while (n <= 0);

        int[] arr = new int[n];
        int sum = 0;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d] = ", i);
            arr[i] = sc.nextInt();
            if (arr[i] % 3 == 0) {
                sum += arr[i];
                found = true;
            }
        }

        if (found) {
            System.out.println("Tổng = " + sum);
        } else {
            System.out.println("Không có số chia hết cho 3");
        }
    }
}

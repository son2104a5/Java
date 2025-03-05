import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số nguyên: ");
        int n = sc.nextInt();
        int check = 0;

        if (n < 2) {
            System.out.println("Không phải số nguyên tố");
        } else {
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    check++;
                }
            }
            if (check == 2) {
                System.out.printf("%d là số nguyên tố", n);
            }
        }
    }
}

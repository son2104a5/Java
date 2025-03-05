import java.util.Scanner;

public class B6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = Long.parseLong(sc.nextLine());
        int sum = 0;

        while (n > 0) {
            long digit = n % 10;
            sum += digit;
            n /= 10;
        }
        System.out.printf("Tổng các chữ số là: %d", sum);
    }
}

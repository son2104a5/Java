import java.util.Scanner;

public class B7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("nhập một số nguyên dương n: ");
        int n = sc.nextInt();

        System.out.print("Các số Happy nhỏ hơn hoặc bằng " + n + " là: ");

        for (int i = 1; i <= n; i++) {
            if (isHappy(i)) {
                System.out.print(i + " ");
            }
        }

        sc.close();
    }

    public static boolean isHappy(int num) {
        int slow = num;
        int fast = sumOfSquares(num);

        while (fast != 1 && slow != fast) {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        }

        return fast == 1;
    }

    public static int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}

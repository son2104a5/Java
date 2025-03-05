import java.util.Scanner;

public class B8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        while (true) {
            System.out.print("nhập một số nguyên dương n: ");
            n = sc.nextInt();
            if (n > 0) break;
            System.out.println("Số nhập vào không hợp lệ! Hãy nhập lại.");
        }

        System.out.print("Các số Armstrong nhỏ hơn hoặc bằng " + n + " là: ");

        for (int i = 1; i <= n; i++) {
            if (isArmstrong(i)) {
                System.out.print(i + " ");
            }
        }

        sc.close();
    }

    public static boolean isArmstrong(int num) {
        int originalNum = num;
        int sum = 0;
        int numDigits = countDigits(num);

        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            sum += power(digit, numDigits);
            temp /= 10;
        }

        return sum == originalNum;
    }

    public static int countDigits(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public static int power(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }
}

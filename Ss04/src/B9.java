import java.util.Scanner;

public class B9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N;
        while (true) {
            System.out.print("Nhập một số nguyên dương N: ");
            N = sc.nextInt();
            if (N > 0) break;
            System.out.println("Số nhập vào không hợp lệ! Hãy nhập lại.");
        }

        System.out.print("Các số Palindrome nhỏ hơn hoặc bằng " + N + " là: ");

        for (int i = 1; i <= N; i++) {
            if (isPalindrome(i)) {
                System.out.print(i + " ");
            }
        }

        sc.close();
    }

    public static boolean isPalindrome(int num) {
        int originalNum = num;
        int reversedNum = 0;

        while (num > 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }

        return originalNum == reversedNum;
    }
}

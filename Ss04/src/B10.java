import java.util.Scanner;

public class B10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice, num;
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Kiểm tra số nguyên tố");
            System.out.println("2. Kiểm tra số hoàn hảo");
            System.out.println("3. Tìm và tính tổng các ước của một số");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("Chương trình kết thúc!");
                break;
            }
            switch (choice) {
                case 1:
                    System.out.print("Nhập một số nguyên dương: ");
                    num = sc.nextInt();
                    if (num <= 0) {
                        System.out.println("Vui lòng nhập số nguyên dương!");
                        continue;
                    }
                    if (isPrime(num))
                        System.out.println(num + " là số nguyên tố.");
                    else
                        System.out.println(num + " không phải là số nguyên tố.");
                    break;

                case 2:
                    System.out.print("Nhập một số nguyên dương: ");
                    num = sc.nextInt();
                    if (num <= 0) {
                        System.out.println("Vui lòng nhập số nguyên dương!");
                        continue;
                    }
                    if (isPerfect(num))
                        System.out.println(num + " là số hoàn hảo.");
                    else
                        System.out.println(num + " không phải là số hoàn hảo.");
                    break;

                case 3:
                    System.out.print("Nhập một số nguyên dương: ");
                    num = sc.nextInt();
                    if (num <= 0) {
                        System.out.println("Vui lòng nhập số nguyên dương!");
                        continue;
                    }
                    int sum = sumOfDivisors(num);
                    System.out.println("Tổng các ước của " + num + " là: " + sum);
                    break;

                case 0:


                default:
                    System.out.println("Lựa chọn không hợp lệ! Hãy chọn từ 1 đến 4.");
                    break;
            }
        }
        ;
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static boolean isPerfect(int num) {
        return sumOfDivisors(num) == num;
    }

    public static int sumOfDivisors(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) sum += i;
        }
        return sum;
    }
}

package B3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập lần lượt 2 số nguyên a,b: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("Tổng a, b: " + MathOperations.add(a, b));
        System.out.println("Hiệu a, b: " + MathOperations.subtract(a, b));
        System.out.println("Tích a, b: " + MathOperations.multiply(a, b));
        System.out.println("Thương a, b: " + MathOperations.divide(a, b));
    }
}

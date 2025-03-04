import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số thứ nhất: ");
        int a = sc.nextInt();
        System.out.print("Nhập số thứ hai: ");
        int b = sc.nextInt();
        System.out.print("Nhập số thứ ba: ");
        int c = sc.nextInt();

        if (a == b && b == c) {
            System.out.println("Ba số nguyên bằng nhau");
        } else {
            int max;
            if (a > b) {
                if (a > c) {
                    max = a;
                } else {
                    max = c;
                }
            } else {
                if (b > c) {
                    max = b;
                } else {
                    max = c;
                }
            }

            System.out.println("Số lớn nhất là " + max);
        }

        sc.close();
    }
}

import java.util.Scanner;

public class B5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập width: ");
        int width = sc.nextInt();
        System.out.println("Nhập height: ");
        int height = sc.nextInt();

        float area = width * height;
        float circumference = 2 * (width + height);

        System.out.println("Diện tích: " + area);
        System.out.println("Chu vi: " + circumference);

        sc.close();
    }
}

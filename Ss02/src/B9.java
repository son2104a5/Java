import java.util.Scanner;

public class B9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập cạnh a: ");
        double a = sc.nextDouble();
        System.out.print("Nhập cạnh b: ");
        double b = sc.nextDouble();
        System.out.print("Nhập cạnh c: ");
        double c = sc.nextDouble();

        double perimeter = a + b + c;
        double p = perimeter / 2;
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        System.out.printf("Chu vi: %.2f%n", perimeter);
        System.out.printf("Diện tích: %.2f%n", area);

        sc.close();
    }
}

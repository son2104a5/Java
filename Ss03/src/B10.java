import java.util.Scanner;

public class B10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập các hệ số a, b, c, d: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();

        if (a == 0) {
            solveQuadraticEquation(b, c, d);
        } else {
            solveCubicEquation(a, b, c, d);
        }

        sc.close();
    }

    public static void solveQuadraticEquation(double b, double c, double d) {
        if (b == 0) {
            if (c == 0) {
                if (d == 0) {
                    System.out.println("Phương trình có vô số nghiệm");
                } else {
                    System.out.println("Phương trình vô nghiệm");
                }
            } else {
                System.out.println("Một nghiệm: x = " + (-d / c));
            }
        } else {
            double delta = c * c - 4 * b * d;
            if (delta > 0) {
                double x1 = (-c + Math.sqrt(delta)) / (2 * b);
                double x2 = (-c - Math.sqrt(delta)) / (2 * b);
                System.out.println("Hai nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                System.out.println("Một nghiệm kép: x = " + (-c / (2 * b)));
            } else {
                System.out.println("Phương trình vô nghiệm");
            }
        }
    }

    public static void solveCubicEquation(double a, double b, double c, double d) {
        double delta = 18 * a * b * c * d - 4 * Math.pow(b, 3) * d + Math.pow(b, 2) * Math.pow(c, 2)
                - 4 * a * Math.pow(c, 3) - 27 * Math.pow(a, 2) * Math.pow(d, 2);

        if (delta > 0) {
            System.out.println("Ba nghiệm thực (tìm theo công thức Cardano)");
        } else if (delta == 0) {
            System.out.println("Có nghiệm bội (tìm theo công thức Cardano)");
        } else {
            System.out.println("Một nghiệm thực duy nhất (tìm theo công thức Cardano)");
        }
    }
}

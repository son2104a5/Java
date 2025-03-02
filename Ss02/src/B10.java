import java.util.*;
import java.math.*;

public class B10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số nguyên lớn thứ nhất: ");
        BigInteger num1 = new BigInteger(sc.nextLine());

        System.out.print("Nhập số nguyên lớn thứ hai: ");
        BigInteger num2 = new BigInteger(sc.nextLine());

        System.out.println("\nKết quả các phép toán:");

        System.out.println("Tổng: " + num1.add(num2));
        System.out.println("Hiệu: " + num1.subtract(num2));
        System.out.println("Tích: " + num1.multiply(num2));

        if (!num2.equals(BigInteger.ZERO)) {
            System.out.println("Thương: " + num1.divide(num2));
            System.out.println("Modulo: " + num1.mod(num2));
        } else {
            System.out.println("Không thể chia hoặc lấy dư cho 0.");
        }

        System.out.println("Lũy thừa (số thứ nhất mũ số thứ hai): " + num1.pow(num2.intValue()));

        sc.close();
    }
}

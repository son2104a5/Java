import java.util.*;

public class B4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập giá trị của a (true/false): ");
        boolean a = sc.nextBoolean();
        System.out.println("Nhập giá trị của b (true/false): ");
        boolean b = sc.nextBoolean();
        System.out.println("Nhập giá trị của c (true/false): ");
        boolean c = sc.nextBoolean();

        boolean condition1 = a && b;
        boolean condition2 = a || b;
        boolean condition3 = !c;

        System.out.println(condition1 ? "Cả hai giá trị a và b đều đúng" : "Hoặc a sai hoặc b sai");
        System.out.println(condition2 ? "Trong a và b có ít nhất 1 giá trị đúng" : "Cả 2 giá trị a và b đều sai");
        System.out.println(condition3 ? "Phủ định của c là đúng" : "Phủ định của c là sai");

        sc.close();
    }
}

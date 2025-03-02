import java.util.*;

public class B3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập x: ");
        int x = sc.nextInt();
        System.out.print("Nhập y: ");
        int y = sc.nextInt();

        System.out.println("x == y  : " + (x == y));
        System.out.println("x != y  : " + (x != y));
        System.out.println("x > y   : " + (x > y));
        System.out.println("x < y   : " + (x < y));
        System.out.println("x >= y  : " + (x >= y));
        System.out.println("x <= y  : " + (x <= y));

        sc.close();
    }
}

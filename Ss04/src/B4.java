import java.util.Scanner;

public class B4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        int result = 0;

        do {
            n = sc.nextInt();
            result += n;
        } while (n != 0);
        System.out.printf("Tổng các số đã nhập là: %d", result);
    }
}

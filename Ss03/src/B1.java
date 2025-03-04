import java.util.Scanner;

public class B1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        if (a % 2 == 0) {
            System.out.println("Số " + a + " là số chẵn");
        } else if (a == 0) {
            System.out.println("Số " + a + " không phải chẵn cũng không phải lẻ");
        } else {
            System.out.println("Số " + a + " là số lẻ");
        }
    }
}

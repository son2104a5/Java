import java.util.Scanner;

public class B4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập vào 1 số nguyên: ");
        int n = sc.nextInt();

        try {
            System.out.println("Bạn đã nhập: " + n);
        } catch (NumberFormatException e) {
            System.err.println("Lỗi: Bạn phải nhập số nguyên!");
        } finally {
            System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
        }
    }
}

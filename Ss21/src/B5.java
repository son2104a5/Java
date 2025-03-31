import java.util.Scanner;

public class B5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập 1 số nguyên dương: ");
        try {
        int n = Integer.parseInt(sc.nextLine());
            if (n <= 0) {
                throw new Exception("Số bạn nhập phải là số nguyên dương.");
            } else {
                int count = 0;
                for (int i = 2; i < n / 2; i++) {
                    if (i % 2 == 0) {
                        count++;
                    }
                }
                if (count <= 2 && n != 1) {
                    System.out.println(n + " là số nguyên tố");
                } else {
                    System.out.println(n + " không phải số nguyên tố");
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Lỗi: Bạn phải nhập số nguyên!");
        } catch (Exception e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}

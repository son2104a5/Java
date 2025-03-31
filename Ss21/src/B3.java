import java.util.Scanner;

public class B3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập tuổi của người dùng: ");
        int age = Integer.parseInt(sc.nextLine());
        checkAge(age);
    }

    public static void checkAge(int age) throws Exception {
        if (age < 18) {
            throw new Exception("Bạn chưa đủ 18 tuổi");
        } else {
            System.out.println("Chào mừng bạn!");
        }
    }
}

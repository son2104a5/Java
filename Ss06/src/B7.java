import java.util.Scanner;

public class B7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = "^[\\w\\.]+@[\\w]+\\.[a-z]{2,}$";
        String email = sc.nextLine();
        if (email.matches(regex)) {
            String[] emails = email.split("@");
            System.out.println("Tên người dùng: " + emails[0] + ", Tên miền: " + emails[1]);
        } else {
            System.out.println("Email không hợp lệ");
        }
    }
}

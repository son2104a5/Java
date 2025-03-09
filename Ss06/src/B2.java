import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = "^[\\w\\.]+@[\\w]+\\.[a-z]{2,}$";
        String email = sc.nextLine();
        System.out.println(email.matches(regex) ? "Email hợp lệ" : "Email không hợp lệ");
    }
}

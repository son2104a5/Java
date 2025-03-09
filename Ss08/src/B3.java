import java.util.Scanner;

public class B3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String email, password;
        boolean isEmailValid = false;
        boolean isPasswordValid = false;

        do {
            System.out.print("Nhập email: ");
            email = sc.nextLine();
            isEmailValid = email.matches("^[a-zA-Z0-9][a-zA-Z0-9._-]*@[a-zA-Z0-9.-]+\\.(com|vn|org)$");

            if (!isEmailValid) {
                System.out.println("Email không hợp lệ, vui lòng nhập lại!");
            }
        } while (!isEmailValid);

        do {
            System.out.print("Nhập mật khẩu: ");
            password = sc.nextLine();
            isPasswordValid = password.length() >= 8 &&
                    password.matches(".*[A-Z].*") &&
                    password.matches(".*[a-z].*") &&
                    password.matches(".*[0-9].*") &&
                    password.matches(".*[@#$%!&*].*");

            if (!isPasswordValid) {
                System.out.println("Mật khẩu không hợp lệ, vui lòng nhập lại!");
            }
        } while (!isPasswordValid);

        System.out.println("Email và mật khẩu hợp lệ!");
    }
}

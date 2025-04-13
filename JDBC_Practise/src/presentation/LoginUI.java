package presentation;

import java.util.Scanner;

public class LoginUI {
    public static void displayLoginUI(Scanner sc) {
        System.out.println("Welcome to the Login UI");
        System.out.print("Nhập tên tài khoản: ");
        String username = sc.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = sc.nextLine();

    }
}

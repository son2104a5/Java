package presentation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            LoginUI.displayLoginUI(sc);
            displayMainUI(sc);
        } while (true);
    }

    public static void displayMainUI(Scanner sc) {
        do {
            System.out.println("-------------- Xin chào bạn --------------\n" +
                    "1. UI Phòng ban\n" +
                    "2. UI Nhân viên\n" +
                    "3. UI Thống kê\n" +
                    "4. Đăng xuất");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    EmployeeUI.displayEmployeeUI(sc);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Đã đăng xuất khỏi ứng dụng");
                    return;
            }
        } while (true);
    }
}

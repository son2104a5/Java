package JDBC.presentation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("*************APPLICATION MENU**************\n" +
                    "1. Quản lí sinh viên\n" +
                    "2. Quản lí lớp học\n" +
                    "3. Thoát\n" +
                    "Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    StudentUI.displayStudentMenu(sc);
                    break;
                case 2:
                    break;
                case 3:
                    System.exit(0);
            }
        } while (true);
    }
}

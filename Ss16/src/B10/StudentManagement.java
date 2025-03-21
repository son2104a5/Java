package B10;

import java.util.*;

public class StudentManagement {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. In danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Hiển thị danh sách sinh viên sau phân loại GPA");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> inputStudents();
                case 2 -> displayStudents();
                case 3 -> searchByName();
                case 4 -> classifyStudents();
                case 0 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    public static void inputStudents() {
        System.out.print("Nhập số lượng sinh viên (>=5): ");
        int n = Integer.parseInt(sc.nextLine());
        while (n < 5) {
            System.out.print("Vui lòng nhập ít nhất 5 sinh viên: ");
            n = Integer.parseInt(sc.nextLine());
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin sinh viên thứ " + (i + 1));
            System.out.print("Mã sinh viên: ");
            String id = sc.nextLine();
            System.out.print("Họ và tên: ");
            String name = sc.nextLine();
            System.out.print("GPA: ");
            double gpa = Double.parseDouble(sc.nextLine());

            studentList.add(new Student(id, name, gpa));
        }
    }

    public static void displayStudents() {
        System.out.println("\n=== DANH SÁCH SINH VIÊN ===");
        for (Student s : studentList) {
            s.display();
        }
    }

    public static void searchByName() {
        System.out.print("\nNhập tên cần tìm kiếm: ");
        String keyword = sc.nextLine().toLowerCase();
        boolean found = false;

        for (Student s : studentList) {
            if (s.getName().toLowerCase().contains(keyword)) {
                s.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên nào có tên chứa '" + keyword + "'");
        }
    }

    public static void classifyStudents() {
        System.out.println("\n=== DANH SÁCH SINH VIÊN THEO PHÂN LOẠI GPA ===");
        for (Student s : studentList) {
            s.display();
        }
    }
}

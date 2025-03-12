package B10;

import java.util.Scanner;

public class Main {
    static Student[] students = new Student[100];
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Sửa thông tin sinh viên theo mã");
            System.out.println("4. Xóa sinh viên theo mã");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> showStudents();
                case 2 -> addStudent(scanner);
                case 3 -> updateStudent(scanner);
                case 4 -> deleteStudent(scanner);
                case 5 -> System.out.println("Đã thoát.");
                default -> System.out.println("Chọn sai.");
            }
        } while (choice != 5);
    }

    public static void showStudents() {
        if (count == 0) {
            System.out.println("Danh sách trống.");
        } else {
            for (int i = 0; i < count; i++) {
                students[i].displayData();
            }
        }
    }

    public static void addStudent(Scanner scanner) {
        Student s = new Student();
        s.inputData(scanner);
        students[count++] = s;
    }

    public static void updateStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                System.out.print("Nhập tên mới: ");
                students[i].setName(scanner.nextLine());

                System.out.print("Nhập tuổi mới: ");
                students[i].setAge(Integer.parseInt(scanner.nextLine()));

                System.out.print("Nhập giới tính mới (MALE/FEMALE/OTHER): ");
                students[i].setGender(Gender.valueOf(scanner.nextLine().toUpperCase()));

                System.out.print("Nhập địa chỉ mới: ");
                students[i].setAddress(scanner.nextLine());

                System.out.print("Nhập SĐT mới: ");
                students[i].setPhoneNumber(scanner.nextLine());

                System.out.println("Đã cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên.");
    }

    public static void deleteStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--count] = null;
                System.out.println("Đã xóa.");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên.");
    }
}

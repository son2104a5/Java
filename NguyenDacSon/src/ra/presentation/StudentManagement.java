package ra.presentation;

import ra.entity.Student;

import java.util.*;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Student> students = new HashMap<String, Student>();
        do {
            displayMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    displayStudent(students);
                    break;
                case 2:
                    System.out.print("Nhập số sinh viên muốn thêm vào: ");
                    int n = Integer.parseInt(sc.nextLine());
                    String id = sc.nextLine();
                    if (students.containsKey(id)) {
                        System.out.println("Id đã tồn tại");
                        break;
                    }
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập tên sv: ");
                        String name = sc.nextLine();

                        System.out.print("Nhập tuổi: ");
                        int age = Integer.parseInt(sc.nextLine());

                        System.out.print("Nhập điểm tb: ");
                        Float avg = Float.parseFloat(sc.nextLine());
                        students.put(id, new Student(id, name, age, avg));
                        System.out.println("***********************************");
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã sinh viên cần xóa: ");
                    String idDelete = sc.nextLine();

                    if (students.containsKey(idDelete)) {
                        students.remove(idDelete);
                    } else System.out.println("Id không tồn tại");
                    break;
                case 4:
                    Float total = 0f;

                    for (Map.Entry<String, Student> entry : students.entrySet()) {
                        total = total + entry.getValue().getAvg();
                    }
                    total = total/students.size();
                    System.out.println("Tổng điểm: " + total);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Chức năng không hợp lệ, vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    public static void displayMenu() {
        System.out.println("********************MENU*******************\n" +
                "1. Danh sách sinh viên\n" +
                "2. Thêm mới các sinh viên\n" +
                "3. Xóa sinh viên theo mã sinh viên\n" +
                "4. Tính điểm trung bình của tất cả sinh viên\n" +
                "5. In thông tin sinh viên có điểm trung bình lớn nhất\n" +
                "6. In thông tin sinh viên có tuổi nhỏ nhất\n" +
                "7. Thoát");
        System.out.print("Chọn chức năng từ 1 - 7: ");
    }

    public static void displayStudent(Map<String, Student> students) {
        System.out.println("Danh sách các sinh viên hiên có:");
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            System.out.println(students.get(entry.getKey()).toString());
        }
    }
}

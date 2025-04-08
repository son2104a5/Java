package JDBC.presentation;

import JDBC.business.model.Student;
import JDBC.business.service.student.StudentService;
import JDBC.business.service.student.StudentServiceImp;

import java.util.List;
import java.util.Scanner;

public class StudentUI {
    private final StudentService studentService;

    public StudentUI() {
        studentService = new StudentServiceImp();
    }

    public static void displayStudentMenu(Scanner sc) {
        StudentUI studentUI = new StudentUI();
        do {
            System.out.println("************* STUDENT MANAGEMENT ************\n" +
                    "1. Danh sách sinh viên\n" +
                    "2. Thêm mới sinh viên\n" +
                    "3. Cập nhât sinh viên\n" +
                    "4. Xóa sinh viên\n" +
                    "5. Thống kê sinh viên theo trạng thái\n" +
                    "6. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> studentUI.displayStudents();
                case 2 -> studentUI.createStudents(sc);
                case 3 -> studentUI.updateStudent(sc);
                case 4 -> studentUI.deleteStudent(sc);
                case 5 -> studentUI.countStudentByStatus(sc);
                case 6 -> {
                    System.out.println("Quay lại menu chính");
                    return;
                }
                default -> System.err.println("Chức năng không hợp lệ, vui lòng chọn lại");
            }
        } while (true);
    }

    public void displayStudents() {
        List<Student> students = studentService.findAll();
        students.forEach(System.out::println);
    }

    public void createStudents(Scanner sc) {
        System.out.print("Nhập vào số sinh viên câ thêm mới: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            Student student = new Student();
            student.inputData(sc);
            boolean flag = studentService.save(student);
            if (flag) {
                System.out.println("Thêm mới thành công");
            } else {
                System.err.println("Có lỗi trong quá trình thêm mới");
            }
        }
    }

    public void updateStudent(Scanner sc) {
        System.out.print("Nhập vào mã sinh viên cần cập nhật: ");
        int id = Integer.parseInt(sc.nextLine());
        if (studentService.findById(id) != null) {
            Student student = new Student();
            student.setId(id);
            student.inputData(sc);
            boolean flag = studentService.update(student);
            if (flag) {
                System.out.println("Cập nhật thành công");
            } else {
                System.err.println("Có lỗi trong quá trình cập nhật");
            }
        } else {
            System.err.println("Không tồn tại mã sinh viên.");
        }
    }

    public void deleteStudent(Scanner sc) {
        System.out.print("Nhập vào mã sinh viên cần cập nhật: ");
        int id = Integer.parseInt(sc.nextLine());
        if (studentService.findById(id) != null) {
            Student student = new Student();
            student.setId(id);
            boolean flag = studentService.delete(student);
            if (flag) {
                System.out.println("Xóa thành công");
            } else {
                System.err.println("Có lỗi trong quá trình cập nhật");
            }
        } else {
            System.err.println("Không tồn tại mã sinh viên.");
        }
    }

    public void countStudentByStatus(Scanner sc) {
        System.out.print("Nhâp vào trạng thái cần thống kê: ");
        boolean status = Boolean.parseBoolean(sc.nextLine());
        System.out.printf("Số lượng sinh viên có trạng thái %b: %d\n", status, studentService.getCountStudentByStatus(status));
    }
}

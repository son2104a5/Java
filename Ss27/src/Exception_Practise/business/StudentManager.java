package Exception_Practise.business;

import Exception_Practise.entity.CourseRegistration;
import Exception_Practise.entity.Student;
import Exception_Practise.entity.Gender;
import Exception_Practise.util.ValidationUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Không có sinh viên nào.");
            return;
        }
        students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);
    }

    public void addStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên (5 ký tự, bắt đầu bằng 'SV'): ");
        String studentId = scanner.nextLine();
        if (!ValidationUtil.isValidStudentId(studentId, students)) {
            System.out.println("Mã sinh viên không hợp lệ hoặc đã tồn tại.");
            return;
        }

        System.out.print("Nhập tên (tối đa 150 ký tự): ");
        String name = scanner.nextLine();
        if (!ValidationUtil.isValidName(name)) {
            System.out.println("Tên không hợp lệ.");
            return;
        }

        System.out.print("Nhập tuổi (>= 18): ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());
            if (!ValidationUtil.isValidAge(age)) {
                System.out.println("Tuổi phải >= 18.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Tuổi không hợp lệ.");
            return;
        }

        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        if (!ValidationUtil.isValidAddress(address)) {
            System.out.println("Địa chỉ không được để trống.");
            return;
        }

        System.out.print("Nhập số điện thoại (số di động Việt Nam): ");
        String phone = scanner.nextLine();
        if (!ValidationUtil.isValidPhone(phone, new ArrayList<>(students))) {
            System.out.println("Số điện thoại không hợp lệ hoặc đã tồn tại.");
            return;
        }

        System.out.print("Nhập email: ");
        String email = scanner.nextLine();
        if (!ValidationUtil.isValidEmail(email, new ArrayList<>(students))) {
            System.out.println("Email không hợp lệ hoặc đã tồn tại.");
            return;
        }

        System.out.print("Nhập giới tính (MALE/FEMALE/OTHER): ");
        String genderStr = scanner.nextLine().toUpperCase();
        Gender gender;
        try {
            gender = Gender.valueOf(genderStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Giới tính không hợp lệ.");
            return;
        }

        System.out.print("Nhập điểm trung bình: ");
        double gpa;
        try {
            gpa = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Điểm trung bình không hợp lệ.");
            return;
        }

        Student student = new Student(name, age, address, phone, email, gender, studentId, gpa);
        students.add(student);
        System.out.println("Thêm sinh viên thành công.");
    }

    public void updateStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên cần cập nhật: ");
        String studentId = scanner.nextLine();
        Student student = students.stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findFirst()
                .orElse(null);

        if (student == null) {
            System.out.println("Không tìm thấy sinh viên.");
            return;
        }

        System.out.print("Nhập tên mới (tối đa 150 ký tự, để trống để giữ nguyên): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            if (!ValidationUtil.isValidName(name)) {
                System.out.println("Tên không hợp lệ.");
                return;
            }
            student.setName(name);
        }

        System.out.print("Nhập tuổi mới (>= 18, để trống để giữ nguyên): ");
        String ageStr = scanner.nextLine();
        if (!ageStr.isEmpty()) {
            try {
                int age = Integer.parseInt(ageStr);
                if (!ValidationUtil.isValidAge(age)) {
                    System.out.println("Tuổi phải >= 18.");
                    return;
                }
                student.setAge(age);
            } catch (NumberFormatException e) {
                System.out.println("Tuổi không hợp lệ.");
                return;
            }
        }

        System.out.print("Nhập địa chỉ mới (để trống để giữ nguyên): ");
        String address = scanner.nextLine();
        if (!address.isEmpty()) {
            if (!ValidationUtil.isValidAddress(address)) {
                System.out.println("Địa chỉ không được để trống.");
                return;
            }
            student.setAddress(address);
        }

        System.out.print("Nhập số điện thoại mới (số di động Việt Nam, để trống để giữ nguyên): ");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) {
            if (!ValidationUtil.isValidPhone(phone, new ArrayList<>(students))) {
                System.out.println("Số điện thoại không hợp lệ hoặc đã tồn tại.");
                return;
            }
            student.setPhone(phone);
        }

        System.out.print("Nhập email mới (để trống để giữ nguyên): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) {
            if (!ValidationUtil.isValidEmail(email, new ArrayList<>(students))) {
                System.out.println("Email không hợp lệ hoặc đã tồn tại.");
                return;
            }
            student.setEmail(email);
        }

        System.out.print("Nhập giới tính mới (MALE/FEMALE/OTHER, để trống để giữ nguyên): ");
        String genderStr = scanner.nextLine().toUpperCase();
        if (!genderStr.isEmpty()) {
            try {
                Gender gender = Gender.valueOf(genderStr);
                student.setSex(gender);
            } catch (IllegalArgumentException e) {
                System.out.println("Giới tính không hợp lệ.");
                return;
            }
        }

        System.out.print("Nhập điểm trung bình mới (để trống để giữ nguyên): ");
        String gpaStr = scanner.nextLine();
        if (!gpaStr.isEmpty()) {
            try {
                double gpa = Double.parseDouble(gpaStr);
                student.setGpa(gpa);
            } catch (NumberFormatException e) {
                System.out.println("Điểm trung bình không hợp lệ.");
                return;
            }
        }

        System.out.println("Cập nhật sinh viên thành công.");
    }

    public void deleteStudent(Scanner scanner, List<CourseRegistration> registrations) {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String studentId = scanner.nextLine();
        Student student = students.stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findFirst()
                .orElse(null);

        if (student == null) {
            System.out.println("Không tìm thấy sinh viên.");
            return;
        }

        boolean hasRegistration = registrations.stream()
                .anyMatch(reg -> reg.getStudentId().equals(studentId));
        if (hasRegistration) {
            System.out.println("Không thể xóa sinh viên vì đã đăng ký khóa học.");
            return;
        }

        students.remove(student);
        System.out.println("Xóa sinh viên thành công.");
    }

    public List<Student> getStudents() {
        return students;
    }
}
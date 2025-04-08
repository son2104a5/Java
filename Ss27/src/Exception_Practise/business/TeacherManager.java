package Exception_Practise.business;

import Exception_Practise.entity.ClassRoom;
import Exception_Practise.entity.Teacher;
import Exception_Practise.entity.Gender;
import Exception_Practise.util.ValidationUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TeacherManager {
    private List<Teacher> teachers;

    public TeacherManager() {
        this.teachers = new ArrayList<>();
    }

    public void displayTeachers() {
        if (teachers.isEmpty()) {
            System.out.println("Không có giảng viên nào.");
            return;
        }
        teachers.stream()
                .sorted(Comparator.comparingInt(Teacher::getTeacherId).reversed())
                .forEach(System.out::println);
    }

    public void addTeacher(Scanner scanner) {
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
        if (!ValidationUtil.isValidPhone(phone, new ArrayList<>(teachers))) {
            System.out.println("Số điện thoại không hợp lệ hoặc đã tồn tại.");
            return;
        }

        System.out.print("Nhập email: ");
        String email = scanner.nextLine();
        if (!ValidationUtil.isValidEmail(email, new ArrayList<>(teachers))) {
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

        System.out.print("Nhập chuyên môn: ");
        String subject = scanner.nextLine();
        if (subject == null || subject.trim().isEmpty()) {
            System.out.println("Chuyên môn không được để trống.");
            return;
        }

        Teacher teacher = new Teacher(name, age, address, phone, email, gender, subject);
        teachers.add(teacher);
        System.out.println("Thêm giảng viên thành công.");
    }

    public void updateTeacher(Scanner scanner) {
        System.out.print("Nhập mã giảng viên cần cập nhật: ");
        int teacherId;
        try {
            teacherId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Mã giảng viên không hợp lệ.");
            return;
        }

        Teacher teacher = teachers.stream()
                .filter(t -> t.getTeacherId() == teacherId)
                .findFirst()
                .orElse(null);

        if (teacher == null) {
            System.out.println("Không tìm thấy giảng viên.");
            return;
        }

        System.out.print("Nhập tên mới (tối đa 150 ký tự, để trống để giữ nguyên): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            if (!ValidationUtil.isValidName(name)) {
                System.out.println("Tên không hợp lệ.");
                return;
            }
            teacher.setName(name);
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
                teacher.setAge(age);
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
            teacher.setAddress(address);
        }

        System.out.print("Nhập số điện thoại mới (số di động Việt Nam, để trống để giữ nguyên): ");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) {
            if (!ValidationUtil.isValidPhone(phone, new ArrayList<>(teachers))) {
                System.out.println("Số điện thoại không hợp lệ hoặc đã tồn tại.");
                return;
            }
            teacher.setPhone(phone);
        }

        System.out.print("Nhập email mới (để trống để giữ nguyên): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) {
            if (!ValidationUtil.isValidEmail(email, new ArrayList<>(teachers))) {
                System.out.println("Email không hợp lệ hoặc đã tồn tại.");
                return;
            }
            teacher.setEmail(email);
        }

        System.out.print("Nhập giới tính mới (MALE/FEMALE/OTHER, để trống để giữ nguyên): ");
        String genderStr = scanner.nextLine().toUpperCase();
        if (!genderStr.isEmpty()) {
            try {
                Gender gender = Gender.valueOf(genderStr);
                teacher.setSex(gender);
            } catch (IllegalArgumentException e) {
                System.out.println("Giới tính không hợp lệ.");
                return;
            }
        }

        System.out.print("Nhập chuyên môn mới (để trống để giữ nguyên): ");
        String subject = scanner.nextLine();
        if (!subject.isEmpty()) {
            if (subject.trim().isEmpty()) {
                System.out.println("Chuyên môn không được để trống.");
                return;
            }
            teacher.setSubject(subject);
        }

        System.out.println("Cập nhật giảng viên thành công.");
    }

    public void deleteTeacher(Scanner scanner, List<ClassRoom> classRooms) {
        System.out.print("Nhập mã giảng viên cần xóa: ");
        int teacherId;
        try {
            teacherId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Mã giảng viên không hợp lệ.");
            return;
        }

        Teacher teacher = teachers.stream()
                .filter(t -> t.getTeacherId() == teacherId)
                .findFirst()
                .orElse(null);

        if (teacher == null) {
            System.out.println("Không tìm thấy giảng viên.");
            return;
        }

        boolean isAssigned = classRooms.stream()
                .anyMatch(classRoom -> classRoom.getTeacherId() == teacherId);
        if (isAssigned) {
            System.out.println("Không thể xóa giảng viên vì đã được xếp lớp.");
            return;
        }

        teachers.remove(teacher);
        System.out.println("Xóa giảng viên thành công.");
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }
}
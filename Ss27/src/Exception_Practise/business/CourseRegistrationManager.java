package Exception_Practise.business;

import Exception_Practise.entity.CourseRegistration;
import Exception_Practise.entity.RegistrationStatus;
import Exception_Practise.entity.Student;
import Exception_Practise.util.DateUtil;
import Exception_Practise.entity.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CourseRegistrationManager {
    private List<CourseRegistration> registrations;

    public CourseRegistrationManager() {
        this.registrations = new ArrayList<>();
    }

    public void registerCourse(Scanner scanner, List<Student> students, List<Course> courses) {
        System.out.print("Nhập mã sinh viên: ");
        String studentId = scanner.nextLine();
        if (students.stream().noneMatch(s -> s.getStudentId().equals(studentId))) {
            System.out.println("Không tìm thấy sinh viên.");
            return;
        }

        System.out.print("Nhập mã khóa học: ");
        String courseId = scanner.nextLine();
        if (courses.stream().noneMatch(c -> c.getCourseId().equals(courseId))) {
            System.out.println("Không tìm thấy khóa học.");
            return;
        }

        boolean alreadyRegistered = registrations.stream()
                .anyMatch(reg -> reg.getStudentId().equals(studentId) && reg.getCourseId().equals(courseId));
        if (alreadyRegistered) {
            System.out.println("Sinh viên đã đăng ký khóa học này.");
            return;
        }

        CourseRegistration registration = new CourseRegistration(studentId, courseId);
        registrations.add(registration);
        System.out.println("Đăng ký khóa học thành công.");
    }

    public void cancelRegistration(Scanner scanner) {
        System.out.print("Nhập mã đăng ký cần hủy: ");
        int crid;
        try {
            crid = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Mã đăng ký không hợp lệ.");
            return;
        }

        CourseRegistration registration = registrations.stream()
                .filter(reg -> reg.getCrid() == crid)
                .findFirst()
                .orElse(null);

        if (registration == null) {
            System.out.println("Không tìm thấy đăng ký.");
            return;
        }

        if (registration.getStatus() != RegistrationStatus.PENDING) {
            System.out.println("Chỉ có thể hủy đăng ký ở trạng thái PENDING.");
            return;
        }

        registration.setStatus(RegistrationStatus.DROPPED);
        System.out.println("Hủy đăng ký thành công.");
    }

    public void approveRegistration(Scanner scanner) {
        System.out.print("Nhập mã đăng ký cần duyệt: ");
        int crid;
        try {
            crid = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Mã đăng ký không hợp lệ.");
            return;
        }

        CourseRegistration registration = registrations.stream()
                .filter(reg -> reg.getCrid() == crid)
                .findFirst()
                .orElse(null);

        if (registration == null) {
            System.out.println("Không tìm thấy đăng ký.");
            return;
        }

        if (registration.getStatus() != RegistrationStatus.PENDING) {
            System.out.println("Chỉ có thể duyệt đăng ký ở trạng thái PENDING.");
            return;
        }

        registration.setStatus(RegistrationStatus.ENROLLED);
        System.out.println("Duyệt đăng ký thành công.");
    }

    public void displayRegistrationsByCourse(List<Student> students) {
        if (registrations.isEmpty()) {
            System.out.println("Không có đăng ký nào.");
            return;
        }

        System.out.print("Nhập mã khóa học để xem danh sách đăng ký: ");
        Scanner scanner = new Scanner(System.in);
        String courseId = scanner.nextLine();

        List<CourseRegistration> courseRegistrations = registrations.stream()
                .filter(reg -> reg.getCourseId().equals(courseId))
                .collect(Collectors.toList());

        if (courseRegistrations.isEmpty()) {
            System.out.println("Không có đăng ký nào cho khóa học này.");
            return;
        }

        for (CourseRegistration reg : courseRegistrations) {
            Student student = students.stream()
                    .filter(s -> s.getStudentId().equals(reg.getStudentId()))
                    .findFirst()
                    .orElse(null);
            System.out.println("Mã đăng ký: " + reg.getCrid() +
                    ", Sinh viên: " + (student != null ? student.getName() : "Không xác định") +
                    ", Ngày đăng ký: " + DateUtil.formatDate(reg.getRegistrationDate()) +
                    ", Trạng thái: " + reg.getStatus());
        }
    }

    public List<CourseRegistration> getRegistrations() {
        return registrations;
    }
}

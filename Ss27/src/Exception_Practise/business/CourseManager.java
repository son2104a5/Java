package Exception_Practise.business;

import Exception_Practise.entity.ClassRoom;
import Exception_Practise.entity.Course;
import Exception_Practise.util.ValidationUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CourseManager {
    private List<Course> courses;

    public CourseManager() {
        this.courses = new ArrayList<>();
    }

    public void displayCourses() {
        if (courses.isEmpty()) {
            System.out.println("Không có khóa học nào.");
            return;
        }
        courses.stream()
                .sorted(Comparator.comparing(Course::getCourseName))
                .forEach(System.out::println);
    }

    public void addCourse(Scanner scanner) {
        System.out.print("Nhập mã khóa học (5 ký tự, bắt đầu bằng 'C'): ");
        String courseId = scanner.nextLine();
        if (!ValidationUtil.isValidCourseId(courseId, courses)) {
            System.out.println("Mã khóa học không hợp lệ hoặc đã tồn tại.");
            return;
        }

        System.out.print("Nhập tên khóa học (20-100 ký tự): ");
        String courseName = scanner.nextLine();
        if (!ValidationUtil.isValidCourseName(courseName, courses)) {
            System.out.println("Tên khóa học không hợp lệ hoặc đã tồn tại.");
            return;
        }

        System.out.print("Nhập trạng thái khóa học (true/false): ");
        String statusStr = scanner.nextLine();
        if (!statusStr.equalsIgnoreCase("true") && !statusStr.equalsIgnoreCase("false")) {
            System.out.println("Trạng thái phải là true hoặc false.");
            return;
        }
        boolean status = Boolean.parseBoolean(statusStr);

        Course course = new Course(courseId, courseName, status);
        courses.add(course);
        System.out.println("Thêm khóa học thành công.");
    }

    public void updateCourse(Scanner scanner) {
        System.out.print("Nhập mã khóa học cần cập nhật: ");
        String courseId = scanner.nextLine();
        Course course = courses.stream()
                .filter(c -> c.getCourseId().equals(courseId))
                .findFirst()
                .orElse(null);

        if (course == null) {
            System.out.println("Không tìm thấy khóa học.");
            return;
        }

        System.out.print("Nhập tên khóa học mới (20-100 ký tự, để trống để giữ nguyên): ");
        String courseName = scanner.nextLine();
        if (!courseName.isEmpty()) {
            if (!ValidationUtil.isValidCourseName(courseName, courses)) {
                System.out.println("Tên khóa học không hợp lệ hoặc đã tồn tại.");
                return;
            }
            course.setCourseName(courseName);
        }

        System.out.print("Nhập trạng thái mới (true/false, để trống để giữ nguyên): ");
        String statusStr = scanner.nextLine();
        if (!statusStr.isEmpty()) {
            if (!statusStr.equalsIgnoreCase("true") && !statusStr.equalsIgnoreCase("false")) {
                System.out.println("Trạng thái phải là true hoặc false.");
                return;
            }
            course.setStatus(Boolean.parseBoolean(statusStr));
        }

        System.out.println("Cập nhật khóa học thành công.");
    }

    public void deleteCourse(Scanner scanner, List<ClassRoom> classRooms) {
        System.out.print("Nhập mã khóa học cần xóa: ");
        String courseId = scanner.nextLine();
        Course course = courses.stream()
                .filter(c -> c.getCourseId().equals(courseId))
                .findFirst()
                .orElse(null);

        if (course == null) {
            System.out.println("Không tìm thấy khóa học.");
            return;
        }

        boolean hasClassRoom = classRooms.stream()
                .anyMatch(classRoom -> classRoom.getCourseId().equals(courseId));
        if (hasClassRoom) {
            System.out.println("Không thể xóa khóa học vì đã có lớp học sử dụng.");
            return;
        }

        courses.remove(course);
        System.out.println("Xóa khóa học thành công.");
    }

    public List<Course> getCourses() {
        return courses;
    }
}
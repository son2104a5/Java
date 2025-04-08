package Exception_Practise.business;

import Exception_Practise.entity.ClassRoom;
import Exception_Practise.entity.Course;
import Exception_Practise.entity.Teacher;
import Exception_Practise.util.ValidationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassRoomManager {
    private List<ClassRoom> classRooms;

    public ClassRoomManager() {
        this.classRooms = new ArrayList<>();
    }

    public void addClassRoom(Scanner scanner, List<Course> courses, List<Teacher> teachers) {
        System.out.print("Nhập tên lớp học (15-50 ký tự): ");
        String classRoomName = scanner.nextLine();
        if (!ValidationUtil.isValidClassRoomName(classRoomName, classRooms)) {
            System.out.println("Tên lớp học không hợp lệ hoặc đã tồn tại.");
            return;
        }

        System.out.print("Nhập mã khóa học: ");
        String courseId = scanner.nextLine();
        if (courses.stream().noneMatch(c -> c.getCourseId().equals(courseId))) {
            System.out.println("Không tìm thấy khóa học.");
            return;
        }

        System.out.print("Nhập mã giảng viên: ");
        int teacherId;
        try {
            teacherId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Mã giảng viên không hợp lệ.");
            return;
        }
        if (teachers.stream().noneMatch(t -> t.getTeacherId() == teacherId)) {
            System.out.println("Không tìm thấy giảng viên.");
            return;
        }

        ClassRoom classRoom = new ClassRoom(classRoomName, courseId, teacherId);
        classRooms.add(classRoom);
        System.out.println("Thêm lớp học thành công.");
    }

    public List<ClassRoom> getClassRooms() {
        return classRooms;
    }
}

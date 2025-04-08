package Exception_Practise.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassRoom implements IApp {
    private int classroomId;
    private String classRoomName;
    private String courseId;
    private int teacherId;
    private List<Student> listStudents;
    private LocalDate created;
    private ClassStatus status;
    private static int autoId = 1;

    public ClassRoom() {
        this.classroomId = autoId++;
        this.listStudents = new ArrayList<>();
        this.created = LocalDate.now();
        this.status = ClassStatus.PENDING;
    }

    public ClassRoom(String classRoomName, String courseId, int teacherId) {
        this.classroomId = autoId++;
        this.classRoomName = classRoomName;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.listStudents = new ArrayList<>();
        this.created = LocalDate.now();
        this.status = ClassStatus.PENDING;
    }

    @Override
    public void inputData(Scanner scanner) {}

    public int getClassroomId() { return classroomId; }
    public String getClassRoomName() { return classRoomName; }
    public void setClassRoomName(String classRoomName) { this.classRoomName = classRoomName; }
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    public int getTeacherId() { return teacherId; }
    public void setTeacherId(int teacherId) { this.teacherId = teacherId; }
    public List<Student> getListStudents() { return listStudents; }
    public LocalDate getCreated() { return created; }
    public ClassStatus getStatus() { return status; }
    public void setStatus(ClassStatus status) { this.status = status; }

    @Override
    public String toString() {
        return "Lớp học{" +
                "Mã lớp học=" + classroomId +
                ", Tên lớp học='" + classRoomName + '\'' +
                ", Mã khóa học='" + courseId + '\'' +
                ", Mã giảng viên=" + teacherId +
                ", Danh sách sinh viên=" + listStudents +
                ", Ngày tạo=" + created +
                ", Trạng thái=" + status +
                '}';
    }
}

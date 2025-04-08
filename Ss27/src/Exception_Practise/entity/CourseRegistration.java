package Exception_Practise.entity;

import java.time.LocalDate;
import java.util.Scanner;

public class CourseRegistration implements IApp {
    private int crid;
    private String studentId;
    private String courseId;
    private LocalDate registrationDate;
    private RegistrationStatus status;
    private static int autoId = 1;

    public CourseRegistration() {
        this.crid = autoId++;
        this.registrationDate = LocalDate.now();
        this.status = RegistrationStatus.PENDING;
    }

    public CourseRegistration(String studentId, String courseId) {
        this.crid = autoId++;
        this.studentId = studentId;
        this.courseId = courseId;
        this.registrationDate = LocalDate.now();
        this.status = RegistrationStatus.PENDING;
    }

    @Override
    public void inputData(Scanner scanner) {}

    public int getCrid() { return crid; }
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    public LocalDate getRegistrationDate() { return registrationDate; }
    public RegistrationStatus getStatus() { return status; }
    public void setStatus(RegistrationStatus status) { this.status = status; }

    @Override
    public String toString() {
        return "Đăng ký khóa học{" +
                "Mã đăng ký=" + crid +
                ", Mã sinh viên='" + studentId + '\'' +
                ", Mã khóa học='" + courseId + '\'' +
                ", Ngày đăng ký=" + registrationDate +
                ", Trạng thái=" + status +
                '}';
    }
}

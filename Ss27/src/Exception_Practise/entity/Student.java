package Exception_Practise.entity;

import java.util.Scanner;

public class Student extends Person implements IApp {
    private String studentId;
    private double gpa;

    public Student() {}

    public Student(String name, int age, String address, String phone, String email, Gender sex, String studentId, double gpa) {
        super(name, age, address, phone, email, sex);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public void inputData(Scanner scanner) {}

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    @Override
    public String toString() {
        return "Sinh viên{" +
                "Mã sinh viên='" + studentId + '\'' +
                ", Điểm trung bình=" + gpa +
                ", Tên='" + getName() + '\'' +
                ", Tuổi=" + getAge() +
                ", Địa chỉ='" + getAddress() + '\'' +
                ", Số điện thoại='" + getPhone() + '\'' +
                ", Email='" + getEmail() + '\'' +
                ", Giới tính=" + getSex() +
                '}';
    }
}
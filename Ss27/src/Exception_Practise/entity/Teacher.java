package Exception_Practise.entity;

import java.util.Scanner;

public class Teacher extends Person implements IApp {
    private int teacherId;
    private String subject;
    private static int autoId = 1;

    public Teacher() {
        this.teacherId = autoId++;
    }

    public Teacher(String name, int age, String address, String phone, String email, Gender sex, String subject) {
        super(name, age, address, phone, email, sex);
        this.teacherId = autoId++;
        this.subject = subject;
    }

    @Override
    public void inputData(Scanner scanner) {}

    public int getTeacherId() { return teacherId; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    @Override
    public String toString() {
        return "Giảng viên{" +
                "Mã giảng viên=" + teacherId +
                ", Chuyên môn='" + subject + '\'' +
                ", Tên='" + getName() + '\'' +
                ", Tuổi=" + getAge() +
                ", Địa chỉ='" + getAddress() + '\'' +
                ", Số điện thoại='" + getPhone() + '\'' +
                ", Email='" + getEmail() + '\'' +
                ", Giới tính=" + getSex() +
                '}';
    }
}
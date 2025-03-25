package ra.entity;

import java.util.Scanner;

public class Student {
    private String stuId;
    private String stuName;
    private int age;
    private float avg;

    public Student() {
    }

    public Student(String stuId, String stuName, int age, float avg) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.age = age;
        this.avg = avg;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public void inputData(Scanner sc) {
        System.out.print("Nhập mã sinh viên: ");
        stuId = sc.nextLine();
        System.out.print("Nhập tên sinh viên: ");
        stuName = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập điêểm trung bình: ");
        avg = Float.parseFloat(sc.nextLine());
        System.out.println("Đã thêm sinh viên vào danh sách!");
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", age=" + age +
                ", avg=" + avg +
                '}';
    }
}

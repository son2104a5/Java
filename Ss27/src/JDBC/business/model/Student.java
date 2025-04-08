package JDBC.business.model;

import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private int age;
    private boolean status;

    public Student() {
    }

    public Student(int id, String name, int age, boolean status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner sc) {
        System.out.println("Tên sinh viên:");
        this.name = sc.nextLine();
        System.out.println("Tuổi:");
        this.age = Integer.parseInt(sc.nextLine());
        System.out.println("Trạng thái:");
        this.status = Boolean.parseBoolean(sc.nextLine());
    }

    @Override
    public String toString() {
        return "Mã SV: " + this.id +
                " - Tên: " + this.name +
                " - Tuổi: " + this.age +
                " - Trạng thái: " + this.status;
    }
}

package B10;

import java.util.Scanner;

enum Gender {
    MALE, FEMALE, OTHER
}

public class Student {
    private int id;
    private String name;
    private int age;
    private Gender gender;
    private String address;
    private String phoneNumber;

    public Student() {}

    public Student(int id, String name, int age, Gender gender, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã sinh viên: ");
        id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập tên sinh viên: ");
        name = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        age = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập giới tính (MALE/FEMALE/OTHER): ");
        gender = Gender.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Nhập địa chỉ: ");
        address = scanner.nextLine();

        System.out.print("Nhập số điện thoại: ");
        phoneNumber = scanner.nextLine();
    }

    public void displayData() {
        System.out.println("Mã SV: " + id);
        System.out.println("Tên: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Giới tính: " + gender);
        System.out.println("Địa chỉ: " + address);
        System.out.println("SĐT: " + phoneNumber);
        System.out.println("---------------------------");
    }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGender(Gender gender) { this.gender = gender; }
    public void setAddress(String address) { this.address = address; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}

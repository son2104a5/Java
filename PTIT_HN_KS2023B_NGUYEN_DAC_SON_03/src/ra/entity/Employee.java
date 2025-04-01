package ra.entity;

import ra.validate.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Employee implements IApp {
    public int min = 0;
    public double BASE_SALARY = 1800000;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String empId;
    private String empName;
    private LocalDate birthday;
    private String phoneNumber;
    private boolean sex;
    private double coefficient;
    private int allowanceSalary;
    private String department;
    private byte status;

    public Employee() {
    }

    public Employee(String empId, String empName, LocalDate birthday, String phoneNumber, boolean sex, double coefficient, int allowanceSalary, String department, byte status) {
        this.empId = empId;
        this.empName = empName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.coefficient = coefficient;
        this.allowanceSalary = allowanceSalary;
        this.department = department;
        this.status = status;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getAllowanceSalary() {
        return allowanceSalary;
    }

    public void setAllowanceSalary(int allowanceSalary) {
        this.allowanceSalary = allowanceSalary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner sc) {
        this.empId = Validator.validateStringRegexValue(sc, "Nhập ID của nhân viên: ", "[NV]+\\d{4}");
        this.empName = Validator.validateStringValue(sc, "Nhập tên nhân viên: ");
        String data = Validator.validateStringValue(sc, "Nhập ngày sinh: ");
        this.birthday = LocalDate.parse(data, formatter);
        this.phoneNumber = Validator.validateStringRegexValue(sc, "Nhập số điện thoại: ", "[09|03|08|05|07]+\\d{8}");
        this.sex = Validator.validateBooleanValue(sc, "Nhập giới tính(true - nam, false - nữ): ");
        this.coefficient = Validator.validateNumberValue(sc, "Nhập hệ số lương: ", min);
        this.allowanceSalary = 0;
        this.department = Validator.validateStringValue(sc, "Nhập tên phòng ban: ");
        this.status = 1;
    }

    @Override
    public void displayData() {
        System.out.printf("Mã nhân viên: %s - Tên nhân viên: %s\n" +
                "Ngày sinh: %s - Giới tính: %s - Số điện thoại: %s\n" +
                "Hệ số lương: %s - Phụ cấp lương: %s\n" +
                "Phòng ban: %s - Trạng thái: %s\n", this.empId, this.empName, this.birthday, this.sex ? "Nam" : "Nữ", this.phoneNumber, Double.parseDouble(String.valueOf(coefficient)), Integer.parseInt(String.valueOf(allowanceSalary)), this.department, this.status == 1 ? "Đang hoạt động" : this.status == 2 ? "Đang nghỉ phép" : "Đã nghỉ việc");
    }
}

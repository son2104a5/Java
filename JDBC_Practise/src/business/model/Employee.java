package business.model;

import datatype.EmployeeStatus;
import datatype.Gender;
import validate.EmployeeValidator;

import java.time.LocalDate;
import java.util.Scanner;

public class Employee {
    private String emp_id;
    private String emp_name;
    private String email;
    private String phoneNumber;
    private Gender gender;
    private int salaryLevel;
    private double salary;
    private LocalDate dateOfBirth;
    private String address;
    private EmployeeStatus status;
    private int dp_id;

    public Employee() {
    }

    public Employee(String emp_id, String emp_name, String email, String phoneNumber, Gender gender, int salaryLevel, double salary, LocalDate dateOfBirth, String address, EmployeeStatus status, int dp_id) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.salaryLevel = salaryLevel;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.status = status;
        this.dp_id = dp_id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getSalaryLevel() {
        return salaryLevel;
    }

    public void setSalaryLevel(int salaryLevel) {
        this.salaryLevel = salaryLevel;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public int getDp_id() {
        return dp_id;
    }

    public void setDp_id(int dp_id) {
        this.dp_id = dp_id;
    }

    public void inputData(Scanner scanner) {
        emp_id = EmployeeValidator.validateEmployeeId(scanner, "Nhập ID nhân viên:");
        emp_name = EmployeeValidator.validateInputValue(scanner, "Nhập tên:", String.class);
        email = EmployeeValidator.validateEmail(scanner, "Nhập Email:");
        phoneNumber = EmployeeValidator.validatePhone(scanner, "Nhập số điện thoại:");
        gender = EmployeeValidator.validateSex(scanner, "Nhập giới tính:", Gender.class);
        salaryLevel = EmployeeValidator.validateInputValue(scanner, "Nhập bậc lương:", Integer.class);
        salary = EmployeeValidator.validateInputValue(scanner, "Nhập lương:", Double.class);
        dateOfBirth = EmployeeValidator.validateInputValue(scanner, "Nhập ngày sinh:", LocalDate.class);
        address = EmployeeValidator.validateInputValue(scanner, "Nhập địa chỉ:", String.class);
        status = EmployeeValidator.validateInputValue(scanner, "Nhập trạng thái:", EmployeeStatus.class);
        dp_id = EmployeeValidator.validateInputValue(scanner, "Nhập ID phòng ban:", Integer.class);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id='" + emp_id + '\'' +
                ", emp_name='" + emp_name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", salaryLevel=" + salaryLevel +
                ", salary=" + salary +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", dp_id=" + dp_id +
                '}';
    }
}

package B2;

public class Employee {
//    Thuộc tính của lớp:
    private String id;
    private String name;
    private String department;
    private double salary;
//    Constructors:
    public Employee(String id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
//    Phương thức hiển thị:
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }
//    Getter và Setter
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
//    Phương thức tăng lương
    public void increaseSalary(double percentage) {
        salary += salary * percentage / 100;
    }

}


package B9;

public class Employee {
    protected String name;
    protected String id;
    protected double salary;

    public Employee() {
    }

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double amount) {
        if (amount > 0) {
            salary += amount;
        } else {
            System.out.println("Lỗi: Số tiền tăng lương phải lớn hơn 0.");
        }
    }

    @Override
    public String toString() {
        return "Tên: " + name + ", Mã nhân viên: " + id + ", Lương cơ bản: " + salary;
    }
}


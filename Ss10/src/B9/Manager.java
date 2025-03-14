package B9;

public class Manager extends Employee {
    private double bonus;

    public Manager() {
        super();
    }

    public Manager(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return salary + bonus;
    }

    @Override
    public String toString() {
        return "Tên: " + name + ", Mã nhân viên: " + id + ", Lương cơ bản: " + salary + ", Thưởng: " + bonus;
    }
}


package B9;

public class TestEmployee {
    public static void main(String[] args) {
        Employee emp = new Employee("Nguyễn Văn A", "E001", 8000);
        Manager manager = new Manager("Trần Thị B", "M001", 12000, 3000);
        Developer dev = new Developer("Lê Văn C", "D001", 10000, "Java");

        System.out.println("=== Thông tin nhân viên ===");
        System.out.println(emp.toString());
        System.out.println("Lương: " + emp.getSalary());
        System.out.println();

        System.out.println("=== Thông tin quản lý ===");
        System.out.println(manager.toString());
        System.out.println("Lương (gồm thưởng): " + manager.getSalary());
        System.out.println();

        System.out.println("=== Thông tin lập trình viên ===");
        System.out.println(dev.toString());
        System.out.println("Lương: " + dev.getSalary());
        System.out.println();

        emp.increaseSalary(2000);
        System.out.println("=== Sau khi tăng lương cho nhân viên ===");
        System.out.println(emp.toString());
        System.out.println("Lương mới: " + emp.getSalary());
    }
}


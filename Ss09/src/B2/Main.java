package B2;

public class Main {
    //    Khởi tạo và sử dụng đối tượng
    public static void main(String[] args) {
        Employee emp = new Employee("E001", "Alice", "HR", 5000);

        System.out.println("=== Thông tin nhân viên ===");
        emp.displayInfo();
        System.out.println("Lương: " + emp.getSalary());

        emp.increaseSalary(10);

        System.out.println("=== Sau khi tăng lương ===");
        System.out.println("Lương mới: " + emp.getSalary());
    }
}

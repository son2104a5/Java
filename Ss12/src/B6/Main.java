package B6;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];

        employees[0] = new FullTimeEmployee("Alice", 30, 5000, 1000);
        employees[1] = new PartTimeEmployee("Bob", 22, 100, 60);
        employees[2] = new Intern("Charlie", 21, 2000);

        for (Employee emp : employees) {
            System.out.println("----- Thông tin nhân viên -----");
            emp.showInfo();
            System.out.println();
        }
    }
}

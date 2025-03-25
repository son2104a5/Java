package B10;

import java.util.*;

public class EmployeeManagement {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, Employee> employeeMap = new HashMap<>();

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    calculateTotalSalary();
                    break;
                case 4:
                    calculateAverageSalary();
                    break;
                case 5:
                    findHighestSalaryEmployee();
                    break;
                case 6:
                    findLowestSalaryEmployee();
                    break;
                case 7:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Chức năng không hợp lệ.");
                    break;
            }
        } while (true);
    }

    static void showMenu() {
        System.out.println("\n===== MENU QUẢN LÝ NHÂN VIÊN =====");
        System.out.println("1. Thêm nhân viên");
        System.out.println("2. Hiển thị danh sách nhân viên");
        System.out.println("3. Tính tổng lương nhân viên");
        System.out.println("4. Tính lương trung bình");
        System.out.println("5. Tìm nhân viên có lương cao nhất");
        System.out.println("6. Tìm nhân viên có lương thấp nhất");
        System.out.println("7. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    static void addEmployee() {
        System.out.print("Nhập tên nhân viên: ");
        String name = sc.nextLine();
        double salary = inputPositiveDouble("Nhập lương nhân viên (>0): ");
        Employee emp = new Employee(name, salary);
        employeeMap.put(emp.getId(), emp);
        System.out.println("Đã thêm nhân viên.");
    }

    static void displayEmployees() {
        if (employeeMap.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
        } else {
            System.out.println("Danh sách nhân viên:");
            for (Employee emp : employeeMap.values()) {
                System.out.println(emp);
            }
        }
    }

    static void calculateTotalSalary() {
        double total = 0;
        for (Employee emp : employeeMap.values()) {
            total += emp.getSalary();
        }
        System.out.println("Tổng lương nhân viên: " + total);
    }

    static void calculateAverageSalary() {
        if (employeeMap.isEmpty()) {
            System.out.println("Không có nhân viên để tính lương trung bình.");
            return;
        }
        double total = 0;
        int count = 0;
        for (Employee emp : employeeMap.values()) {
            total += emp.getSalary();
            count++;
        }
        System.out.println("Lương trung bình: " + (total / count));
    }

    static void findHighestSalaryEmployee() {
        if (employeeMap.isEmpty()) {
            System.out.println("Không có nhân viên trong danh sách.");
            return;
        }
        Employee highest = null;
        for (Employee emp : employeeMap.values()) {
            if (highest == null || emp.getSalary() > highest.getSalary()) {
                highest = emp;
            }
        }
        System.out.println("Nhân viên có lương cao nhất: " + highest);
    }

    static void findLowestSalaryEmployee() {
        if (employeeMap.isEmpty()) {
            System.out.println("Không có nhân viên trong danh sách.");
            return;
        }
        Employee lowest = null;
        for (Employee emp : employeeMap.values()) {
            if (lowest == null || emp.getSalary() < lowest.getSalary()) {
                lowest = emp;
            }
        }
        System.out.println("Nhân viên có lương thấp nhất: " + lowest);
    }

    static double inputPositiveDouble(String message) {
        double value;
        do {
            System.out.print(message);
            value = Double.parseDouble(sc.nextLine());
            if (value < 0) System.out.println("Giá trị không hợp lệ!");
        } while (value < 0);
        return value;
    }
}

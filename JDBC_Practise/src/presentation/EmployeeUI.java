package presentation;

import business.model.Employee;
import business.service.employee.EmployeeService;
import business.service.employee.EmployeeServiceImp;

import java.util.List;
import java.util.Scanner;

public class EmployeeUI {
    private final EmployeeService employeeService;

    public EmployeeUI() {
        employeeService = new EmployeeServiceImp();
    }

    public static void displayEmployeeUI(Scanner sc) {
        EmployeeUI employeeUI = new EmployeeUI();
        do {
            System.out.println("------------------ Employee UI ------------------\n" +
                    "1. Danh sách nhân viên\n" +
                    "2. Thêm mới nhân viên\n" +
                    "3. Cập nhât thông tin nhân viên\n" +
                    "4. Xóa nhân viên\n" +
                    "5. Sắp xếp nhân viên\n" +
                    "6. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    employeeUI.displayEmployees(sc);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Thoát EmployeeUI...");
                    return;
            }
        } while (true);
    }

    public void displayEmployees(Scanner sc) {
        int page;
        do {
            System.out.print("Nhập trang (nhập 0 để thoát): ");
            page = Integer.parseInt(sc.nextLine());
            List<Employee> employees = employeeService.findAllByPage(page);
            if (employees.isEmpty() && page != 0) {
                System.err.println("Trang bạn tìm không tồn tại");
            } else employees.forEach(System.out::println);
        } while (page != 0);
    }
}

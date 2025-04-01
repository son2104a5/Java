package ra.presentation;

import ra.business.EmployeeBusiness;
import ra.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeApplication {
    public static List<Employee> employees = new ArrayList<Employee>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("----------------------------Employee Menu----------------------------\n" +
                    "1. Hiển thị danh sách nhân viên\n" +
                    "2. Thêm mới nhân viên\n" +
                    "3. Chỉnh sửa thông tin nhân viên\n" +
                    "4. Xóa nhân viên\n" +
                    "5. Tìm kiếm nhân viên\n" +
                    "6. Sắp xếp \n" +
                    "0. Thoát chương trình\n" +
                    "--------------------------------------------------------------------------");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> EmployeeBusiness.displayEmployees(employees);
                case 2 -> EmployeeBusiness.addNewEmployee(scanner, employees);
                case 3 -> {
                }
                case 4 -> {
                }
                case 5 -> {
                }
                case 6 -> {
                }
                case 0 -> {
                    System.out.println("Kết thúc chương trình");
                    System.exit(0);
                }
            }
        } while (true);
    }
}

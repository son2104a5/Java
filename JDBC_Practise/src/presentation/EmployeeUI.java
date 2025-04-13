package presentation;

import business.model.Employee;
import business.service.employee.EmployeeService;
import business.service.employee.EmployeeServiceImp;
import datatype.EmployeeStatus;
import datatype.Gender;

import java.sql.Date;
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
                    employeeUI.createEmployees(sc);
                    break;
                case 3:
                    employeeUI.updateEmployee(sc);
                    break;
                case 4:
                    employeeUI.displayEmployees(sc);
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Thoát EmployeeUI...");
                    return;
                default:
                    System.err.println("Lựa chọn không hợp lệ, vui lòng nhập lại");
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

    public void createEmployees(Scanner sc) {
        System.out.print("Nhập số nhân viên muốn thêm: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            Employee employee = new Employee();
            employee.inputData(sc);
            boolean flag = employeeService.save(employee);
            if (flag) {
                System.out.println("Thêm mới nhân viên thành công");
            } else System.err.println("Có lỗi xảy ra trong quá trình thêm mới");
        }
    }

    public void updateEmployee(Scanner sc) {
        int choice;
        System.out.print("Nhập id nhân viên cần cập nhật: ");
        String id = sc.nextLine();

        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            do {
                System.out.println("Bạn muốn thay đổi thông tin nào:\n" +
                        "1. Tên nhân viên\n" +
                        "2. Email\n" +
                        "3. Số điện thoại\n" +
                        "4. Giới tính\n" +
                        "5. Bậc lương\n" +
                        "6. Ngày sinh\n" +
                        "7. Địa chỉ\n" +
                        "8. Trạng thái\n" +
                        "9. Phòng ban\n" +
                        "0. Thoát cập nhật");
                System.out.print("Lựa chọn của bạn: ");
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Nhập tên mới: ");
                        employee.setEmp_name(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Nhập email mới: ");
                        employee.setEmail(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Nhập số điện thoại mới: ");
                        employee.setPhoneNumber(sc.nextLine());
                        break;
                    case 4:
                        System.out.print("Nhập giới tính (MALE/FEMALE/OTHER): ");
                        employee.setGender(Gender.valueOf(sc.nextLine().toUpperCase()));
                        break;
                    case 5:
                        System.out.print("Nhập bậc lương mới: ");
                        employee.setSalaryLevel(Integer.parseInt(sc.nextLine()));
                        break;
                    case 6:
                        System.out.print("Nhập ngày sinh mới (yyyy-mm-dd): ");
                        employee.setDateOfBirth(Date.valueOf(sc.nextLine()).toLocalDate());
                        break;
                    case 7:
                        System.out.print("Nhập địa chỉ mới: ");
                        employee.setAddress(sc.nextLine());
                        break;
                    case 8:
                        System.out.print("Nhập trạng thái mới (ACTIVE/INACTIVE/ONLEAVE/POLICYLEAVE): ");
                        employee.setStatus(EmployeeStatus.valueOf(sc.nextLine().toUpperCase()));
                        break;
                    case 9:
                        System.out.print("Nhập ID phòng ban mới: ");
                        employee.setDp_id(Integer.parseInt(sc.nextLine()));
                        break;
                    case 0:
                        System.out.println("Thoát cập nhật.");
                        continue;
                    default:
                        System.err.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
                       break;
                }

                boolean updated = employeeService.update(employee);
                if (updated) {
                    System.out.println("Cập nhật thành công.");
                } else {
                    System.out.println("Cập nhật thất bại.");
                }

            } while (choice != 0);
        } else {
            System.out.println("Không tìm thấy nhân viên.");
        }
    }

    public void deleteEmployee(Scanner sc) {
        System.out.print("Nhập id nhân viên cần xóa: ");
        String id = sc.nextLine();

        if (employeeService.getEmployeeById(id) != null) {
            Employee employee = new Employee();
            employee.setEmp_id(id);
            boolean flag = employeeService.delete(employee);
            if (flag) {
                System.out.println("Xóa thành công, trạng thái nhân viên đã được thay đổi");
            } else {
                System.err.println("Có lỗi tong quá trình thực hiện");
            }
        } else {
            System.err.println("Không tìm thấy nhân viên.");
        }
    }
}

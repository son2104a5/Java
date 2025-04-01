package ra.business;

import ra.entity.Employee;
import ra.validate.Validator;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EmployeeBusiness {
    public static void displayEmployees (List<Employee> employees) {
        employees.forEach(Employee::displayData);
    }

    public static void addNewEmployee (Scanner scanner, List<Employee> employees) {
        System.out.print("Nhập số nhân viên muốn thêm: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            Employee newEmployee = new Employee();
            System.out.println("------------------------------------------");
            scanner.nextLine();
            newEmployee.inputData(scanner);
            System.out.println("------------------------------------------");
            employees.add(newEmployee);
        }
    }

    public static void updateEmployee (Scanner scanner, List<Employee> employees) {
        System.out.print("Nhập vào mã của nhân viên cần sửa: ");
        String id = scanner.nextLine();
        int index = 0;
        boolean flag = false;

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (!employee.equals(id)) {
                flag = true;
                index = employees.indexOf(employee);
                break;
            }
        }
        if (flag) {
            System.out.println("--------------- Chọn thuộc tính cần sửa ----------------");
            System.out.println("1. Tên\n" +
                    "2. Ngày sinh\n" +
                    "3. Số điện thoại\n" +
                    "4. Giới tính\n" +
                    "5. Hệ số lương\n" +
                    "6. Phụ cấp lương\n" +
                    "7. Phòng ban\n" +
                    "8. Trạng thái\n" +
                    "0. Thoát");
            System.out.print("Mời chọn thuộc tính: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    String newName = Validator.validateStringValue(scanner);
                    employees.get(index).setEmpName(newName);
                    break;
                case 2:
                    System.out.print("Nhập ngày sinh mới: ");
                    String newBirthday = scanner.nextLine();
                    employees.get(index).setBirthday(LocalDate.parse(newBirthday));
                    break;
                case 3:

            }
        } else System.out.println("ID không tồn tại.");
    }
}

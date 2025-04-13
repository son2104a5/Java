package business.model;

import validate.DepartmentValidator;

import java.util.Scanner;

public class Department {
    private int dp_id;
    private String dp_name;
    private String dp_description;
    private boolean dp_status;

    public Department() {
    }

    public Department(String dp_name, String dp_description, boolean dp_status) {
        this.dp_name = dp_name;
        this.dp_description = dp_description;
        this.dp_status = dp_status;
    }

    public int getDp_id() {
        return dp_id;
    }

    public String getDp_name() {
        return dp_name;
    }

    public String getDp_description() {
        return dp_description;
    }

    public boolean isDp_status() {
        return dp_status;
    }

    public void inputData(Scanner scanner) {
        dp_name = DepartmentValidator.validateInputValue(scanner, "Nhập tên phòng ban:", String.class);
        dp_description = DepartmentValidator.validateInputValue(scanner, "Nhập mô tả:", String.class);
        dp_status = DepartmentValidator.validateInputValue(scanner, "Nhập trạng thái (true|false):", Boolean.class);
    }

    @Override
    public String toString() {
        return "Department{" +
                "dp_id=" + dp_id +
                ", dp_name='" + dp_name + '\'' +
                ", dp_description='" + dp_description + '\'' +
                ", dp_status=" + dp_status +
                '}';
    }
}

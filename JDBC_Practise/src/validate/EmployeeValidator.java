package validate;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeeValidator {
    public static <T extends Enum<T>> T validateSex(Scanner scanner, String message, Class<T> enumClass) {
        System.out.println(message);
        while (true) {
            String input = scanner.nextLine().trim();
            for (T constanst: enumClass.getEnumConstants()) {
                if (constanst.name().equalsIgnoreCase(input)) {
                    return constanst;
                }
            }
            System.err.println("Giá trị không đúng, vui lòng nhập lại");
        }
    }

    public static String validateEmployeeId(Scanner sc, String message) {
        System.out.print(message);
        while (true) {
            String id = sc.nextLine().trim();

            if (Validator.isValidDataType(id, String.class)) {
                if (id.isEmpty()) {
                    System.err.println("Bạn chưa nhập ID, vui lòng nhập dữ liệu");
                    continue;
                }
                if (Pattern.matches(id, "^E\\w{4}$")) {
                    System.err.println("Mã nhân viên phải bắt đầu bằng 'E' và gồm đúng 5 ký tự.");
                    continue;
                }

            } else {
                System.err.println("Không đúng định dạng dữ liệu, vui lòng nhập lại");
            }
        }
    }

    public static String validateEmail(Scanner scanner, String message) {
        System.out.println(message);
        while (true) {
            String value = scanner.nextLine().trim();
            if (value.isEmpty()) {
                System.err.println("Bạn chưa nhập email, vui lòng nhập dữ liệu");
                continue;
            }
            if (Validator.isValidEmail(value)) {
                return value;
            }
            System.err.println("Không đúng định dạng email, vui lòng nhập lại");
        }
    }

    public static String validatePhone(Scanner scanner, String message) {
        System.out.println(message);
        while (true) {
            String value = scanner.nextLine().trim();
            if (value.isEmpty()) {
                System.err.println("Bạn chưa nhập số điện thoại, vui lòng nhập lại");
                continue;
            }
            if (Validator.isValidPhoneNumberVN(value)) {
                return value;
            }
            System.err.println("Không đúng số điện thoại di đông VN, vui lòng nhập lại");
        }
    }

    public static <T> T validateInputValue(Scanner scanner, String message, Class<T> type) {
        System.out.println(message);
        while (true) {
            String value = scanner.nextLine().trim();
            if (value.isEmpty()) {
                System.err.println("Chưa nhập dữ liệu, vui lòng nhập dữ liệu");
                continue;
            }
            if (Validator.isValidDataType(value, type)) {
                try {
                    return Validator.parseValue(value, type);
                } catch (Exception e) {
                    System.err.println("Lỗi khi chuyển đổi dữ liệu: " + e.getMessage());
                }
            } else {
                System.out.println("Kiểu dữ liệu không phù hợp, vui lòng nhập lại");
            }
        }
    }
}

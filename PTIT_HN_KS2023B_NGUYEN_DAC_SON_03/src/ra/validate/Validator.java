package ra.validate;

import java.util.Scanner;

public class Validator {
    public static int validateIntValue(Scanner scanner, String message, int min) {
        do {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                errorMessage();
            }
        } while (true);
    }

    public static String validateStringRegexValue(Scanner scanner, String message, String regex) {
        System.out.print(message);
        do {
            try {
                String value = scanner.nextLine();
                if (!value.matches(regex)) {
                    errorMessage();
                } else return value;
            } catch (Exception e) {
                errorMessage();
            }
        } while (true);
    }

    public static String validateStringValue(Scanner scanner, String message) {
        System.out.print(message);
        do {
            try {
                String value = scanner.nextLine();
                if (value.isEmpty()) {
                    System.err.println("Lỗi: Không được để trống mục này, vui lòng nhập dữ liệu!");
                } else return value;
            } catch (Exception e) {
                errorMessage();
            }

        } while (true);
    }

    public static boolean validateBooleanValue(Scanner scanner, String message) {
        System.out.print(message);
        do {
            try {
                return Boolean.parseBoolean(scanner.nextLine());
            } catch (Exception e) {
                errorMessage();
            }
        } while (true);
    }

    public static double validateNumberValue(Scanner scanner, String message, int min) {
        System.out.print(message);
        do {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                errorMessage();
            }
        } while (true);
    }

    public static void errorMessage() {
        System.err.println("Lỗi: Không đúng định dạng yêu cầu, vui lòng nhập lại.");
    }
}

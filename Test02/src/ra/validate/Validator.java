package ra.validate;

import java.util.Scanner;

public class Validator {
    public static String inputString(Scanner sc, int minLength, int maxLength) {
        String input;
        while (true) {
            input = sc.nextLine().trim();
            if (!input.isEmpty() && input.length() <= maxLength && input.length() >= minLength) break;
            System.out.print("Giá trị không hợp lệ, nhập lại: ");
        }
        return input;
    }

    public static int inputInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Số nguyên không hợp lệ, nhập lại: ");
            }
        }
    }

    public static int inputInt(Scanner sc, int minValue) {
        int value;
        while (true) {
            value = inputInt(sc);
            if (value >= minValue) break;
            System.out.print("Giá trị phải lớn hơn hoặc bằng " + minValue + ", nhập lại: ");
        }
        return value;
    }

    public static double inputDouble(Scanner sc, double minValue) {
        double value;
        while (true) {
            try {
                value = Double.parseDouble(sc.nextLine());
                if (value > minValue) return value;
            } catch (NumberFormatException ignored) {}
            System.out.print("Giá trị phải là số thực > " + minValue + ", nhập lại: ");
        }
    }
}
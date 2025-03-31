package util;


public class Validator {
    public static void validateInteger(String message, int value) {
        try {
            System.out.println("Đã đúng định dạng số nguyên");
        } catch (NumberFormatException e) {
            System.err.println(message);
        }
    }

    public static void validateFloat(String message, float value) throws Exception {
        try {
            System.out.println("Đã đúng định dạng float");
        } catch (NumberFormatException e) {
            throw new Exception(message);
        }
    }

    public static void validateDouble(String message, double value) throws Exception {
        try {
            System.out.println("Đã đúng định dạng double");
        } catch (NumberFormatException e) {
            throw new Exception(message);
        }
    }

    public static void validateBoolean(String message, boolean value) throws Exception {
        try {
            System.out.println("Đã đúng định dạng boolean");
        } catch (Exception e) {
            throw new Exception(message);
        }
    }

    public static void validateString(String message, String value) throws Exception {
        try {
            if (value.length() < 4 || value.length() > 21) {
                throw new Exception(message);
            } else {
                System.out.println("Đã đúng định dạng string");
            }
        } catch (Exception e) {
            throw new Exception(message);
        }
    }
}

package B8;

import java.util.Scanner;

class InvalidPhoneNumberLengthException extends Exception {
    public InvalidPhoneNumberLengthException(String message) {
        super(message);
    }
}

public class B8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập danh sách số điện thoại (cách nhau bằng dấu phẩy): ");
        String input = scanner.nextLine();
        String[] phoneNumbers = input.split(",");

        for (String phone : phoneNumbers) {
            phone = phone.trim();
            try {
                validatePhoneNumber(phone);
                System.out.println("Hợp lệ: " + phone);
            } catch (NumberFormatException e) {
                System.out.println("Không hợp lệ (" + phone + "): Không phải là số.");
            } catch (InvalidPhoneNumberLengthException e) {
                System.out.println("Không hợp lệ (" + phone + "): " + e.getMessage());
            }
        }
    }

    private static void validatePhoneNumber(String phone) throws InvalidPhoneNumberLengthException {
        if (!phone.matches("\\d+")) {
            throw new NumberFormatException();
        }
        if (phone.length() != 10) {
            throw new InvalidPhoneNumberLengthException("Số điện thoại phải có đúng 10 chữ số.");
        }
    }
}

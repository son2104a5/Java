package util;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số nguyên bất kì: ");
        int intValue = sc.nextInt();
        Validator.validateInteger("Không đúng định dạng số nguyên", intValue);

        System.out.print("Nhập số float bất kì: ");
        float floatValue = sc.nextFloat();
        Validator.validateFloat("Không đúng định dạng float", floatValue);

        System.out.print("Nhập số double bất kì: ");
        double doubleValue = sc.nextDouble();
        Validator.validateDouble("Không đúng định dạng double", doubleValue);

        System.out.print("Nhập kiểu dữ liệu boolean (true/false): ");
        boolean booleanValue = sc.nextBoolean();
        Validator.validateBoolean("Không đúng điịnh dạng boolean", booleanValue);

        int min = 5;
        int max = 20;
        System.out.print("Nhập 1 chuỗi (min 5, max 20): ");
        String stringValue = sc.nextLine().trim();
        if (stringValue.length() < min || stringValue.length() > max) {
            Validator.validateString("Chuỗi có độ dài quá lớn hoặc quá nhỏ.", stringValue);
        } else {
            Validator.validateString("Không đúng định dạng string", stringValue);
        }
    }
}

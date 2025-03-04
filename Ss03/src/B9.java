import java.util.Scanner;

public class B9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập một số trong khoảng 100-999: ");
        int number = sc.nextInt();

        if (number < 100 || number > 999) {
            System.out.println("Số nhập vào không hợp lệ");
        } else {
            int hundreds = number / 100;
            int tens = (number / 10) % 10;
            int units = number % 10;

            System.out.print(convertToWords(hundreds, tens, units));
        }

        sc.close();
    }

    public static String convertToWords(int hundreds, int tens, int units) {
        String[] ones = {"", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};
        String[] tensWords = {"", "mười", "hai mươi", "ba mươi", "bốn mươi", "năm mươi", "sáu mươi", "bảy mươi", "tám mươi", "chín mươi"};

        StringBuilder words = new StringBuilder();

        words.append(ones[hundreds]).append(" trăm");

        if (tens == 0 && units == 0) {
            return words.toString();
        }

        if (tens == 0) {
            words.append(" lẻ ").append(ones[units]);
        } else if (tens == 1) {
            words.append(" mười");
            if (units != 0) {
                words.append(" ").append(ones[units]);
            }
        } else {
            words.append(" ").append(tensWords[tens]);
            if (units != 0) {
                words.append(" ").append(ones[units]);
            }
        }

        return words.toString();
    }
}

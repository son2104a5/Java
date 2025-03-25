import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class B8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;

        do {
            System.out.print("Nhập số nguyên dương (1 - 10): ");
            number = Integer.parseInt(sc.nextLine());
            if (number < 1 || number > 10) {
                System.out.println("Số không hợp lệ. Vui lòng nhập lại.");
            }
        } while (number < 1 || number > 10);

        LinkedHashMap<Integer, String> romanMap = new LinkedHashMap<>();
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        StringBuilder romanNumber = new StringBuilder();
        for (Map.Entry<Integer, String> entry : romanMap.entrySet()) {
            while (number >= entry.getKey()) {
                romanNumber.append(entry.getValue());
                number -= entry.getKey();
            }
        }

        System.out.println("Chuỗi la mã tương ứng với " + number + ": " + romanNumber);
    }
}

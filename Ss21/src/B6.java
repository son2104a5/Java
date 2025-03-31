import java.util.*;

public class B6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> validNumbers = new ArrayList<>();
        int validCount = 0, invalidCount = 0;

        System.out.println("Nhập danh sách các chuỗi (nhập 'exit' để dừng):");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) break;

            try {
                int num = Integer.parseInt(input);
                validNumbers.add(num);
                validCount++;
            } catch (NumberFormatException e) {
                invalidCount++;
            }
        }

        System.out.println("\nSố lượng chuỗi hợp lệ: " + validCount);
        System.out.println("Số lượng chuỗi không hợp lệ: " + invalidCount);
        System.out.println("Danh sách số nguyên hợp lệ: " + validNumbers);
    }
}

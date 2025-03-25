import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class B5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử: ");
        int n = sc.nextInt();

        Map<Integer, String> strs = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập chuỗi %d: ", i + 1);
            strs.put(i, sc.next());
        }

        for (Map.Entry<Integer, String> entry : strs.entrySet()) {
            if (entry.getValue().length() >= 5) {
                if (entry.getValue().charAt(0) == 'A') {
                    System.out.println(entry.getValue());
                }
            }
        }
    }
}

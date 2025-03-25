import java.util.*;

public class B7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        do {
            System.out.print("Nhập số phần tử N (nguyên dương): ");
            n = Integer.parseInt(sc.nextLine());
            if (n <= 0) {
                System.out.println("N không hợp lệ. Vui lòng nhập lại.");
            }
        } while (n <= 0);

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("nums[" + i + "] = ");
            nums[i] = Integer.parseInt(sc.nextLine());
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freqMap.entrySet());

        entryList.sort(Comparator.comparing(Map.Entry::getValue));
        System.out.println("\nTần suất các phần tử (sắp xếp theo số lần xuất hiện tăng dần):");
        for (Map.Entry<Integer, Integer> entry : entryList) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }
}

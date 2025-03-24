import java.util.*;

public class B8 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 5, 7, 8, 6};
        int k = 9;

        Set<String> pairSet = new HashSet<>();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    int a = Math.min(arr[i], arr[j]);
                    int b = Math.max(arr[i], arr[j]);
                    pairSet.add(a + "," + b);
                }
            }
        }

        List<String> pairList = new ArrayList<>(pairSet);
        Collections.sort(pairList, new Comparator<String>() {
            public int compare(String p1, String p2) {
                int a1 = Integer.parseInt(p1.split(",")[0]);
                int b1 = Integer.parseInt(p1.split(",")[1]);
                int a2 = Integer.parseInt(p2.split(",")[0]);
                int b2 = Integer.parseInt(p2.split(",")[1]);

                if (a1 != a2) return Integer.compare(a1, a2);
                return Integer.compare(b1, b2);
            }
        });

        System.out.println("Các cặp số có tổng bằng " + k + ":");
        for (String pair : pairList) {
            String[] parts = pair.split(",");
            System.out.println("(" + parts[0] + ", " + parts[1] + ")");
        }
    }
}

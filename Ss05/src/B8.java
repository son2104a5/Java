import java.util.Scanner;

public class B8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Mảng không hợp lệ");
            return;
        }

        int[] arr = new int[n];
        int[] count = new int[1001];

        System.out.println("Nhập giá trị các phần tử:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            count[arr[i]]++;
        }

        int uniqueCount = 0;
        for (int i = 0; i < n; i++) {
            if (count[arr[i]] > 1) {
                uniqueCount++;
            }
        }
        if (uniqueCount == 0) {
            System.out.println("Không có phần tử nào duy nhất trong mảng");
        } else {
            System.out.print("Mảng sau khi loại bỏ phần tử trùng lặp: ");
            for (int i = 0; i < n; i++) {
                if (count[arr[i]] == 1) {
                    System.out.print(arr[i] + " ");
                }
            }
        }
    }
}

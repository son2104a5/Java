import java.util.Scanner;

public class B10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Mảng không hợp lệ");
            return;
        }

        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int maxSum = arr[0], currentSum = 0, maxElement = arr[0];
        int start = 0, end = 0, tempStart = 0;
        boolean allNegative = true;

        for (int i = 0; i < n; i++) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }

            if (arr[i] >= 0) {
                allNegative = false;
            }

            currentSum += arr[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }

        if (allNegative) {
            maxSum = maxElement;
            System.out.println(maxSum + " (Chọn phần tử lớn nhất vì tất cả số đều âm)");
        } else {
            System.out.print(maxSum + " (Dãy con [");
            for (int i = start; i <= end; i++) {
                System.out.print(arr[i]);
                if (i < end) System.out.print(", ");
            }
            System.out.println("] có tổng lớn nhất)");
        }

    }
}

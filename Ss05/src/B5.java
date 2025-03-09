import java.util.Scanner;

public class B5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int oddMin, oddMax, countOdd = 0;
        System.out.print("Nhập số phần tử trong mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Nhập các phần tử trong mảng: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        oddMin = arr[0];
        oddMax = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0 && arr[i] > oddMax && arr[i] > 0) {
                oddMax = arr[i];
                countOdd++;
            }
            if (arr[i] % 2 != 0 && arr[i] < oddMin && arr[i] > 0) {
                oddMin = arr[i];
                countOdd++;
            }
        }
        if (countOdd == 0) {
            System.out.println("Không có phần tử lẻ trong mảng.");
        } else {
            System.out.printf("Phần tử lẻ nguyên dương lớn nhất: %d, Phần tử lẻ nguyên dương nhỏ nhất: %d", oddMax, oddMin);
        }
    }
}

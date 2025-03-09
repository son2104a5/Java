import java.util.Scanner;

public class B7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Mảng không có phần tử");
            return;
        }

        int[] arr = new int[n];
        int[] result = new int[n];
        int evenCount = 0, oddCount = 0;

        System.out.println("Nhập giá trị các phần tử:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] % 2 == 0) {
                evenCount++;
            }
        }

        int evenIndex = 0, oddIndex = evenCount;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                result[evenIndex++] = arr[i];
            } else {
                result[oddIndex++] = arr[i];
            }
        }

        System.out.println("Mảng sau khi sắp xếp:");
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

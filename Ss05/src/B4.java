import java.util.Scanner;

public class B4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử trong mảng: ");
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("Kích thước rỗng");
            return;
        }
        int[] arr = new int[n];
        System.out.print("Nhập các phần tử trong mảng: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int data;
        for (int i = 0; i < n/2; i++) {
            data = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = data;
        }
        System.out.print("Mảng sau khi đảo ngược: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

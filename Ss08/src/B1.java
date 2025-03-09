import java.util.Scanner;

public class B1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = 0, max = 0, min = 0;
        do {
            n = sc.nextInt();
            if (n < 0) {
                System.out.println("Kích thuớc không hợp lệ");
            }
        } while (n < 0);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d] = ", i);
            arr[i] = sc.nextInt();
            if (i == 0) {
                max = arr[0];
                min = arr[0];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.printf("Giá trị lớn nhất: %d, Giá trị nhỏ nhất: %d", max, min);
    }
}

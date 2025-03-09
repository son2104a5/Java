import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr;
        int sum = 0;
        System.out.print("Nhập vào độ dài của mảng: ");
        arr = new int[sc.nextInt()];
        System.out.print("Nhập giá trị các phần tử của mảng: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        System.out.printf("Tổng các phần tử trong mảng là: %d\n", sum);
    }
}

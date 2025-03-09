import java.util.Scanner;

public class B3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr;
        int evenCount = 0;
        System.out.print("Nhập vào độ dài của mảng: ");
        arr = new int[sc.nextInt()];
        System.out.print("Nhập giá trị các phần tử của mảng: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] % 2 == 0) {
                evenCount++;
            }
        }
        System.out.println("Số lượng phần tử chẵn trong mảng: " + evenCount);
    }
}

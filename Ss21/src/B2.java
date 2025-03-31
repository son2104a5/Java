import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập vào số phần tử trong mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = sc.nextInt();
        }
        System.out.print("Nhập vào chỉ số phần tử của mảng: ");
        int index = sc.nextInt();
        try {
            System.out.print("Phần tử ở vị trí index = " + index + " có giá trị: " + arr[index]);
        } catch (NumberFormatException e) {
            System.err.println("Không đúng định dạng số nguyên");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Không tồn tại chỉ số index = " + index + " trong mảng!");
        }
    }
}

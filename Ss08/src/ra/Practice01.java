package ra;

import java.util.Arrays;
import java.util.Scanner;

public class Practice01 {
    static int[] arr = new int[100];
    static int n = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("***********************MENU**************************");
            System.out.println("1. Nhập giá trị n phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng");
            System.out.println("4. In ra vị trí các phần tử có giá trị bằng k");
            System.out.println("5. Sắp xếp nổi bọt giảm dần");
            System.out.println("6. Tính số lượng số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp đặc biệt theo chia hết cho 3");
            System.out.println("8. Chèn giá trị m vào mảng (sắp xếp giảm dần)");
            System.out.println("9. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> inputArray();
                case 2 -> printArray();
                case 3 -> avgPositive();
                case 4 -> findIndexOfK();
                case 5 -> bubbleSortDescending();
                case 6 -> countPrimes();
                case 7 -> customSort();
                case 8 -> insertAndSort();
                case 9 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 9);
    }

    public static void inputArray() {
        System.out.print("Nhập số lượng phần tử (n <= 100): ");
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }
    }

    public static void printArray() {
        System.out.print("Mảng: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void avgPositive() {
        int sum = 0, count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                sum += arr[i];
                count++;
            }
        }
        if (count > 0) {
            System.out.println("Trung bình các phần tử dương: " + ((double) sum / count));
        } else {
            System.out.println("Không có phần tử dương nào.");
        }
    }

    public static void findIndexOfK() {
        System.out.print("Nhập giá trị k: ");
        int k = Integer.parseInt(sc.nextLine());
        System.out.print("Vị trí phần tử bằng k: ");
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] == k) {
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy phần tử bằng k.");
        System.out.println();
    }

    public static void bubbleSortDescending() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println("Mảng đã sắp xếp giảm dần.");
    }

    public static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static void countPrimes() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(arr[i])) {
                count++;
            }
        }
        System.out.println("Số lượng phần tử là số nguyên tố: " + count);
    }

    public static void customSort() {
        int[] evenDiv3 = Arrays.stream(arr, 0, n).filter(x -> x % 2 == 0 && x % 3 == 0).sorted().toArray();
        int[] oddDiv3 = Arrays.stream(arr, 0, n).filter(x -> x % 2 != 0 && x % 3 == 0)
                .boxed().sorted((a, b) -> b - a).mapToInt(Integer::intValue).toArray();
        int[] others = Arrays.stream(arr, 0, n).filter(x -> x % 3 != 0)
                .sorted().toArray();

        int index = 0;
        for (int x : evenDiv3) arr[index++] = x;
        for (int x : others) arr[index++] = x;
        for (int x : oddDiv3) arr[index++] = x;

        System.out.println("Mảng sau khi sắp xếp đặc biệt:");
        printArray();
    }

    public static void insertAndSort() {
        System.out.print("Nhập giá trị m cần chèn: ");
        int m = Integer.parseInt(sc.nextLine());
        int i = n - 1;
        while (i >= 0 && arr[i] < m) {
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = m;
        n++;
        System.out.println("Mảng sau khi chèn m và sắp xếp giảm dần:");
        printArray();
    }
}


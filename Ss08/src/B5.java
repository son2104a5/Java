import java.util.Scanner;

public class B5 {
    static int[] arr;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("*********************** MENU **************************");
            System.out.println("1. Nhập giá trị `n` phần tử của mảng (`n` nhập từ bàn phím)");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương (`>0`) trong mảng");
            System.out.println("4. In ra vị trí (chỉ số) các phần tử có giá trị bằng `k` trong mảng (`k` nhập từ bàn phím)");
            System.out.println("5. Tính số lượng các phần tử là số nguyên tố trong mảng");
            System.out.println("6. Thoát chương trình");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    inputArray(sc);
                    break;
                case 2:
                    printArray();
                    break;
                case 3:
                    averagePositive();
                    break;
                case 4:
                    findIndexByValue(sc);
                    break;
                case 5:
                    countPrimes();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 6);
        sc.close();
    }

    public static void inputArray(Scanner sc) {
        System.out.print("Nhập số phần tử của mảng: ");
        do {
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Số phần tử phải > 0, vui lòng nhập lại.");
            }
        } while (n <= 0);

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d] = ", i);
            arr[i] = sc.nextInt();
        }
    }

    public static void printArray() {
        if (arr == null) {
            System.out.println("Bạn chưa nhập mảng!");
            return;
        }
        System.out.print("Mảng hiện tại: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void averagePositive() {
        if (arr == null) {
            System.out.println("Bạn chưa nhập mảng!");
            return;
        }
        int sum = 0, count = 0;
        for (int value : arr) {
            if (value > 0) {
                sum += value;
                count++;
            }
        }
        if (count > 0) {
            double avg = (double) sum / count;
            System.out.printf("Trung bình các phần tử dương: %.2f\n", avg);
        } else {
            System.out.println("Không có phần tử dương nào.");
        }
    }

    public static void findIndexByValue(Scanner sc) {
        if (arr == null) {
            System.out.println("Bạn chưa nhập mảng!");
            return;
        }
        System.out.print("Nhập giá trị k cần tìm vị trí: ");
        int k = sc.nextInt();
        boolean found = false;
        System.out.print("Các vị trí có giá trị bằng k: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có phần tử nào bằng " + k);
        } else {
            System.out.println();
        }
    }

    public static void countPrimes() {
        if (arr == null) {
            System.out.println("Bạn chưa nhập mảng!");
            return;
        }
        int count = 0;
        for (int value : arr) {
            if (isPrime(value)) {
                count++;
            }
        }
        System.out.println("Số lượng phần tử là số nguyên tố: " + count);
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

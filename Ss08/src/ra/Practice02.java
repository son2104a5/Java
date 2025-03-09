package ra;

import java.util.Scanner;

public class Practice02 {
    static int[][] matrix;
    static int n, m;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("***********************MENU**************************");
            System.out.println("1. Nhập giá trị các phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng theo ma trận");
            System.out.println("3. Tính số lượng phần tử chia hết cho 2 và 3");
            System.out.println("4. In và tính tổng phần tử trên biên, đường chéo chính, phụ");
            System.out.println("5. Sắp xếp tăng dần theo cột (Selection Sort)");
            System.out.println("6. In các phần tử là số nguyên tố");
            System.out.println("7. Sắp xếp đường chéo chính giảm dần (Insertion Sort)");
            System.out.println("8. Chèn mảng 1 chiều vào dòng bất kỳ của mảng 2 chiều");
            System.out.println("9. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> inputMatrix();
                case 2 -> printMatrix();
                case 3 -> countDivisibleBy2And3();
                case 4 -> printBoundaryAndDiagonals();
                case 5 -> sortColumnsAscending();
                case 6 -> printPrimes();
                case 7 -> sortMainDiagonalDescending();
                case 8 -> insertRow();
                case 9 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 9);
    }

    public static void inputMatrix() {
        System.out.print("Nhập số dòng n: ");
        n = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số cột m: ");
        m = Integer.parseInt(sc.nextLine());
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("matrix[%d][%d] = ", i, j);
                matrix[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
    }

    public static void printMatrix() {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%5d", value);
            }
            System.out.println();
        }
    }

    public static void countDivisibleBy2And3() {
        int count = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                if (value % 2 == 0 && value % 3 == 0) {
                    count++;
                }
            }
        }
        System.out.println("Số lượng phần tử chia hết cho 2 và 3: " + count);
    }

    public static void printBoundaryAndDiagonals() {
        int sum = 0;
        System.out.print("Các phần tử trên biên: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    System.out.print(matrix[i][j] + " ");
                    sum += matrix[i][j];
                }
            }
        }

        System.out.print("\nĐường chéo chính: ");
        for (int i = 0; i < Math.min(n, m); i++) {
            System.out.print(matrix[i][i] + " ");
            sum += matrix[i][i];
        }

        System.out.print("\nĐường chéo phụ: ");
        for (int i = 0; i < Math.min(n, m); i++) {
            System.out.print(matrix[i][m - 1 - i] + " ");
            sum += matrix[i][m - 1 - i];
        }

        System.out.println("\nTổng các phần tử: " + sum);
    }

    public static void sortColumnsAscending() {
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int k = i + 1; k < n; k++) {
                    if (matrix[k][j] < matrix[minIndex][j]) {
                        minIndex = k;
                    }
                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[minIndex][j];
                matrix[minIndex][j] = temp;
            }
        }
        System.out.println("Đã sắp xếp tăng dần theo cột.");
    }

    public static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static void printPrimes() {
        System.out.print("Các phần tử là số nguyên tố: ");
        for (int[] row : matrix) {
            for (int value : row) {
                if (isPrime(value)) {
                    System.out.print(value + " ");
                }
            }
        }
        System.out.println();
    }

    public static void sortMainDiagonalDescending() {
        int size = Math.min(n, m);
        int[] diag = new int[size];
        for (int i = 0; i < size; i++) {
            diag[i] = matrix[i][i];
        }
        for (int i = 1; i < size; i++) {
            int key = diag[i];
            int j = i - 1;
            while (j >= 0 && diag[j] < key) {
                diag[j + 1] = diag[j];
                j--;
            }
            diag[j + 1] = key;
        }
        for (int i = 0; i < size; i++) {
            matrix[i][i] = diag[i];
        }
        System.out.println("Đã sắp xếp đường chéo chính giảm dần.");
    }

    public static void insertRow() {
        System.out.print("Nhập chỉ số dòng muốn chèn (0 đến " + n + "): ");
        int rowIndex = Integer.parseInt(sc.nextLine());
        if (rowIndex < 0 || rowIndex > n) {
            System.out.println("Chỉ số không hợp lệ!");
            return;
        }
        System.out.println("Nhập mảng 1 chiều gồm " + m + " phần tử:");
        int[] newRow = new int[m];
        for (int i = 0; i < m; i++) {
            System.out.print("newRow[" + i + "] = ");
            newRow[i] = Integer.parseInt(sc.nextLine());
        }

        int[][] newMatrix = new int[n + 1][m];
        for (int i = 0; i < rowIndex; i++) {
            newMatrix[i] = matrix[i];
        }
        newMatrix[rowIndex] = newRow;
        for (int i = rowIndex + 1; i <= n; i++) {
            newMatrix[i] = matrix[i - 1];
        }

        matrix = newMatrix;
        n++;
        System.out.println("Đã chèn dòng mới vào mảng.");
    }
}

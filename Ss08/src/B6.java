import java.util.*;

public class B6 {
    static Scanner sc = new Scanner(System.in);
    static String inputString = "";
    static int[] intArray;

    public static void main(String[] args) {
        int mainChoice;
        do {
            System.out.println("\n===== MENU CHÍNH =====");
            System.out.println("1. Xử lý chuỗi");
            System.out.println("2. Xử lý số nguyên");
            System.out.println("3. Thoát chương trình");
            System.out.print("Chọn chức năng (1-3): ");
            mainChoice = sc.nextInt();
            sc.nextLine(); // bỏ dòng thừa

            switch (mainChoice) {
                case 1:
                    handleStringMenu();
                    break;
                case 2:
                    handleIntegerMenu();
                    break;
                case 3:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (mainChoice != 3);
    }
    
    static void handleStringMenu() {
        int choice;
        do {
            System.out.println("\n===== MENU XỬ LÝ CHUỖI =====");
            System.out.println("1. Nhập chuỗi");
            System.out.println("2. Loại bỏ khoảng trắng thừa trong chuỗi");
            System.out.println("3. Đếm số lần xuất hiện của từng ký tự");
            System.out.println("4. Chuẩn hóa chuỗi (viết hoa chữ cái đầu mỗi từ)");
            System.out.println("5. Quay lại menu chính");
            System.out.print("Chọn chức năng (1-5): ");
            choice = sc.nextInt();
            sc.nextLine(); // bỏ dòng thừa

            switch (choice) {
                case 1:
                    System.out.print("Nhập chuỗi: ");
                    inputString = sc.nextLine();
                    break;
                case 2:
                    inputString = inputString.trim().replaceAll("\\s+", " ");
                    System.out.println("Chuỗi sau khi loại bỏ khoảng trắng thừa: " + inputString);
                    break;
                case 3:
                    countCharacterFrequency(inputString);
                    break;
                case 4:
                    inputString = toProperCase(inputString);
                    System.out.println("Chuỗi chuẩn hóa: " + inputString);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }

    static void countCharacterFrequency(String s) {
        if (s.isEmpty()) {
            System.out.println("Chuỗi rỗng, vui lòng nhập chuỗi trước.");
            return;
        }
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        System.out.println("Tần suất ký tự:");
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            System.out.println("'" + entry.getKey() + "': " + entry.getValue());
        }
    }

    static String toProperCase(String s) {
        String[] words = s.trim().toLowerCase().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            }
        }
        return result.toString().trim();
    }

    static void handleIntegerMenu() {
        int choice;
        do {
            System.out.println("\n===== MENU XỬ LÝ MẢNG SỐ NGUYÊN =====");
            System.out.println("1. Nhập mảng số nguyên");
            System.out.println("2. Tìm số nguyên tố lớn nhất trong mảng");
            System.out.println("3. Đếm số phần tử có chữ số đầu tiên là số lẻ");
            System.out.println("4. Kiểm tra mảng có phải là mảng đối xứng không");
            System.out.println("5. Quay lại menu chính");
            System.out.print("Chọn chức năng (1-5): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    inputIntegerArray();
                    break;
                case 2:
                    findMaxPrime();
                    break;
                case 3:
                    countOddStartDigit();
                    break;
                case 4:
                    checkSymmetricArray();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }

    static void inputIntegerArray() {
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        intArray = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("intArray[%d] = ", i);
            intArray[i] = sc.nextInt();
        }
    }

    static void findMaxPrime() {
        if (intArray == null || intArray.length == 0) {
            System.out.println("Mảng chưa được nhập.");
            return;
        }
        int maxPrime = -1;
        for (int val : intArray) {
            if (isPrime(val) && val > maxPrime) {
                maxPrime = val;
            }
        }
        if (maxPrime != -1)
            System.out.println("Số nguyên tố lớn nhất là: " + maxPrime);
        else
            System.out.println("Không có số nguyên tố nào trong mảng.");
    }

    static void countOddStartDigit() {
        if (intArray == null || intArray.length == 0) {
            System.out.println("Mảng chưa được nhập.");
            return;
        }
        int count = 0;
        for (int val : intArray) {
            int firstDigit = Integer.parseInt(String.valueOf(Math.abs(val)).substring(0, 1));
            if (firstDigit % 2 != 0) count++;
        }
        System.out.println("Số phần tử có chữ số đầu tiên là số lẻ: " + count);
    }

    static void checkSymmetricArray() {
        if (intArray == null || intArray.length == 0) {
            System.out.println("Mảng chưa được nhập.");
            return;
        }
        boolean isSymmetric = true;
        for (int i = 0; i < intArray.length / 2; i++) {
            if (intArray[i] != intArray[intArray.length - 1 - i]) {
                isSymmetric = false;
                break;
            }
        }
        if (isSymmetric) {
            System.out.println("Mảng là mảng đối xứng.");
        } else {
            System.out.println("Mảng KHÔNG phải là mảng đối xứng.");
        }
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

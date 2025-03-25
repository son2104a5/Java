package B9;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Map<Integer, Product> productMap = new HashMap<>();
        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addProduct(productMap);
                    break;
                case 2:
                    updateProduct(productMap);
                    break;
                case 3:
                    deleteProduct(productMap);
                    break;
                case 4:
                    calculateTotalStockValue(productMap);
                    break;
                case 5:
                    displayAllProducts(productMap);
                    break;
                case 6:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Chức năng không hợp lệ.");
                    break;
            }
        } while (true);
    }

    static void showMenu() {
        System.out.println("\n===== MENU QUẢN LÝ SẢN PHẨM =====");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Cập nhật giá hoặc số lượng sản phẩm");
        System.out.println("3. Xóa sản phẩm theo ID");
        System.out.println("4. Tính tổng giá trị kho");
        System.out.println("5. Hiển thị tất cả sản phẩm");
        System.out.println("6. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    static void addProduct(Map<Integer, Product> map) {
        System.out.print("Nhập ID sản phẩm: ");
        int id = Integer.parseInt(sc.nextLine());
        if (map.containsKey(id)) {
            System.out.println("ID đã tồn tại!");
            return;
        }
        System.out.print("Nhập tên sản phẩm: ");
        String name = sc.nextLine();

        double price = inputPositiveDouble("Nhập giá sản phẩm (>0): ");
        int quantity = inputPositiveInt("Nhập số lượng sản phẩm (>=0): ");

        map.put(id, new Product(id, name, price, quantity));
        System.out.println("Đã thêm sản phẩm.");
    }

    static void updateProduct(Map<Integer, Product> map) {
        System.out.print("Nhập ID sản phẩm cần cập nhật: ");
        int id = Integer.parseInt(sc.nextLine());
        Product p = map.get(id);
        if (p == null) {
            System.out.println("Không tìm thấy sản phẩm!");
            return;
        }
        System.out.println("1. Cập nhật giá\n2. Cập nhật số lượng");
        int choice = Integer.parseInt(sc.nextLine());
        if (choice == 1) {
            double newPrice = inputPositiveDouble("Nhập giá mới (>0): ");
            p.setPrice(newPrice);
            System.out.println("Đã cập nhật giá.");
        } else if (choice == 2) {
            int newQty = inputPositiveInt("Nhập số lượng mới (>=0): ");
            p.setQuantity(newQty);
            System.out.println("Đã cập nhật số lượng.");
        } else {
            System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    static void deleteProduct(Map<Integer, Product> map) {
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        if (map.remove(id) != null) {
            System.out.println("Đã xóa sản phẩm.");
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }

    static void calculateTotalStockValue(Map<Integer, Product> map) {
        double total = 0;
        for (Product p : map.values()) {
            total += p.getTotalValue();
        }
        System.out.println("Tổng giá trị tồn kho: " + total);
    }

    static void displayAllProducts(Map<Integer, Product> map) {
        if (map.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
        } else {
            System.out.println("Danh sách sản phẩm:");
            for (Product p : map.values()) {
                System.out.println(p);
            }
        }
    }

    static double inputPositiveDouble(String message) {
        double value;
        do {
            System.out.print(message);
            value = Double.parseDouble(sc.nextLine());
            if (value < 0) System.out.println("Giá trị không hợp lệ!");
        } while (value < 0);
        return value;
    }

    static int inputPositiveInt(String message) {
        int value;
        do {
            System.out.print(message);
            value = Integer.parseInt(sc.nextLine());
            if (value < 0) System.out.println("Giá trị không hợp lệ!");
        } while (value < 0);
        return value;
    }
}



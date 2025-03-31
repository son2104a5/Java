package B10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingApp {
    private static Map<String, Product> products = new HashMap<>();
    private static ShoppingCart cart = new ShoppingCart();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        products.put("P001", new Product("P001", "Áo Thun", 150000));
        products.put("P002", new Product("P002", "Quần Jean", 350000));
        products.put("P003", new Product("P003", "Giày Sneakers", 800000));

        while (true) {
            System.out.println("\n===== CỬA HÀNG MUA SẮM =====");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm vào giỏ hàng");
            System.out.println("3. Xoá sản phẩm khỏi giỏ hàng");
            System.out.println("4. Xem giỏ hàng");
            System.out.println("5. Hiển thị tổng tiền");
            System.out.println("6. Thoát");
            System.out.print("Chọn thao tác: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên!");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        displayProducts();
                        break;
                    case 2:
                        addProductToCart(scanner);
                        break;
                    case 3:
                        removeProductFromCart(scanner);
                        break;
                    case 4:
                        cart.displayCart();
                        break;
                    case 5:
                        cart.checkout();
                        break;
                    case 6:
                        System.out.println("Thoát chương trình.");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }

    private static void displayProducts() {
        System.out.println("\n=== Danh sách sản phẩm có sẵn ===");
        for (Product product : products.values()) {
            System.out.println(product.getId() + " - " + product.getName() + " - " + product.getPrice() + " VND");
        }
    }

    private static void addProductToCart(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm: ");
        String productId = scanner.nextLine();
        Product product = products.get(productId);

        if (product == null) {
            System.out.println("Lỗi: Sản phẩm không tồn tại!");
            return;
        }

        System.out.print("Nhập số lượng: ");
        try {
            int quantity = Integer.parseInt(scanner.nextLine());
            cart.addToCart(product, quantity);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập số nguyên!");
        } catch (ShoppingCart.InvalidQuantityException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removeProductFromCart(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần xoá: ");
        String productId = scanner.nextLine();
        try {
            cart.removeFromCart(productId);
        } catch (ShoppingCart.ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}


package ra.presentation;

import ra.entity.Product;
import ra.util.ProductFilter;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    private static final List<Product> productList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n*************** MENU ***************");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm theo ID");
            System.out.println("5. Tìm sản phẩm theo tên");
            System.out.println("6. Lọc sản phẩm theo điều kiện");
            System.out.println("7. Sắp xếp sản phẩm theo giá");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> displayProducts();
                case 2 -> addProduct();
                case 3 -> updateProduct();
                case 4 -> deleteProduct();
                case 5 -> findProductByName();
                case 6 -> filterProducts();
                case 7 -> sortProducts();
                case 8 -> System.exit(0);
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void displayProducts() {
        productList.forEach(Product::displayData);
    }

    private static void addProduct() {
        Product product = new Product();
        product.inputData(scanner);
        productList.add(product);
    }

    private static void updateProduct() {
        System.out.print("Nhập ID sản phẩm cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        productList.stream().filter(p -> p.getProductId() == id).findFirst().ifPresentOrElse(product -> {
            System.out.print("Nhập tên mới: ");
            product.setProductName(scanner.nextLine());
            System.out.print("Nhập giá mới: ");
            product.setPrice(Float.parseFloat(scanner.nextLine()));
            System.out.print("Nhập danh mục mới: ");
            product.setCategory(scanner.nextLine());
        }, () -> System.out.println("Không tìm thấy sản phẩm!"));
    }

    private static void deleteProduct() {
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        productList.removeIf(p -> p.getProductId() == id);
    }

    private static void findProductByName() {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine();
        productList.stream().filter(p -> p.getProductName().equalsIgnoreCase(name)).forEach(Product::displayData);
    }

    private static void filterProducts() {
        System.out.print("Nhập giá X: ");
        float x = Float.parseFloat(scanner.nextLine());
        ProductFilter filterByPrice = p -> p.getPrice() > x;
        productList.stream().filter(filterByPrice::filter).forEach(Product::displayData);
    }

    private static void sortProducts() {
        System.out.println("1. Tăng dần\n2. Giảm dần");
        int option = Integer.parseInt(scanner.nextLine());
        productList.sort(option == 1 ? Comparator.comparing(Product::getPrice) : Comparator.comparing(Product::getPrice).reversed());
        displayProducts();
    }
}
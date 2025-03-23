package ra.imp;

import ra.entity.Product;

import java.util.*;

public class ProductImp {
    static Product[] products = new Product[100];
    static int currentIndex = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n***************MENU***************");
            System.out.println("1. Nhập thông tin n sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê sản phẩm theo giá");
            System.out.println("6. Tìm sản phẩm theo tên");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> inputProducts();
                case 2 -> displayProducts();
                case 3 -> calculateProfits();
                case 4 -> sortByProfitDesc();
                case 5 -> filterByPrice();
                case 6 -> searchByName();
                case 7 -> importProduct();
                case 8 -> sellProduct();
                case 9 -> updateStatus();
                case 10 -> System.exit(0);
                default -> System.out.println("Chọn không hợp lệ!");
            }
        }
    }

    static void inputProducts() {
        System.out.print("Nhập số lượng sản phẩm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n && currentIndex < products.length; i++) {
            Product p = new Product();
            p.inputData(scanner, products);
            products[currentIndex++] = p;
        }
    }

    static void displayProducts() {
        for (int i = 0; i < currentIndex; i++) products[i].displayData();
    }

    static void calculateProfits() {
        for (int i = 0; i < currentIndex; i++) {
            products[i].calProfit();
            System.out.println("SP: " + products[i].getProductName() + " | Profit: " + products[i].getProfit());
        }
    }

    static void sortByProfitDesc() {
        Arrays.sort(products, 0, currentIndex, Comparator.comparing(Product::getProfit).reversed());
        System.out.println("Sắp xếp hoàn tất!");
    }

    static void filterByPrice() {
        System.out.print("Nhập fromPrice: ");
        float from = Float.parseFloat(scanner.nextLine());
        System.out.print("Nhập toPrice: ");
        float to = Float.parseFloat(scanner.nextLine());
        int count = 0;
        for (int i = 0; i < currentIndex; i++) {
            if (products[i].getExportPrice() >= from && products[i].getExportPrice() <= to) {
                products[i].displayData();
                count++;
            }
        }
        System.out.println("Tổng số sản phẩm trong khoảng: " + count);
    }

    static void searchByName() {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String keyword = scanner.nextLine().toLowerCase();
        for (int i = 0; i < currentIndex; i++) {
            if (products[i].getProductName().toLowerCase().contains(keyword)) {
                products[i].displayData();
            }
        }
    }

    static void importProduct() {
        System.out.print("Nhập mã sản phẩm cần nhập: ");
        String id = scanner.nextLine();
        Product found = findById(id);
        if (found != null) {
            System.out.print("Nhập số lượng cần nhập: ");
            int addQty = Integer.parseInt(scanner.nextLine());
            found.setQuantity(found.getQuantity() + addQty);
            System.out.println("Đã cập nhật số lượng.");
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }

    static void sellProduct() {
        System.out.print("Nhập tên sản phẩm cần bán: ");
        String name = scanner.nextLine();
        Product found = findByName(name);
        if (found != null) {
            System.out.print("Nhập số lượng bán: ");
            int qty = Integer.parseInt(scanner.nextLine());
            if (qty <= found.getQuantity()) {
                found.setQuantity(found.getQuantity() - qty);
                System.out.println("Đã bán sản phẩm.");
            } else {
                System.out.println("Không đủ số lượng tồn.");
            }
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }

    static void updateStatus() {
        System.out.print("Nhập mã sản phẩm cần cập nhật trạng thái: ");
        String id = scanner.nextLine();
        Product found = findById(id);
        if (found != null) {
            found.setStatus(!found.isStatus());
            System.out.println("Trạng thái mới: " + (found.isStatus() ? "Đang bán" : "Không bán"));
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }

    static Product findById(String id) {
        for (int i = 0; i < currentIndex; i++) {
            if (products[i].getProductId().equals(id)) return products[i];
        }
        return null;
    }

    static Product findByName(String name) {
        for (int i = 0; i < currentIndex; i++) {
            if (products[i].getProductName().equalsIgnoreCase(name)) return products[i];
        }
        return null;
    }
}

package ra.entity;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;

    public Product() {}

    public Product(String productId, String productName, float importPrice, float exportPrice,
                   int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
        calProfit();
    }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public float getImportPrice() { return importPrice; }
    public void setImportPrice(float importPrice) { this.importPrice = importPrice; }

    public float getExportPrice() { return exportPrice; }
    public void setExportPrice(float exportPrice) { this.exportPrice = exportPrice; }

    public float getProfit() { return profit; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getDescriptions() { return descriptions; }
    public void setDescriptions(String descriptions) { this.descriptions = descriptions; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    public void inputData(Scanner scanner, Product[] arrProduct) {
        while (true) {
            System.out.print("Nhập mã sản phẩm (4 ký tự): ");
            String id = scanner.nextLine();
            if (id.length() == 4 && !isDuplicateId(id, arrProduct)) {
                this.productId = id;
                break;
            } else {
                System.out.println("Mã sản phẩm không hợp lệ hoặc bị trùng.");
            }
        }

        while (true) {
            System.out.print("Nhập tên sản phẩm (6-50 ký tự): ");
            String name = scanner.nextLine();
            if (name.length() >= 6 && name.length() <= 50 && !isDuplicateName(name, arrProduct)) {
                this.productName = name;
                break;
            } else {
                System.out.println("Tên sản phẩm không hợp lệ hoặc bị trùng.");
            }
        }

        do {
            System.out.print("Nhập giá nhập > 0: ");
            this.importPrice = Float.parseFloat(scanner.nextLine());
        } while (this.importPrice <= 0);

        do {
            System.out.print("Nhập giá xuất > 120% giá nhập: ");
            this.exportPrice = Float.parseFloat(scanner.nextLine());
        } while (this.exportPrice <= this.importPrice * 1.2);

        calProfit();

        do {
            System.out.print("Nhập số lượng > 0: ");
            this.quantity = Integer.parseInt(scanner.nextLine());
        } while (this.quantity <= 0);

        System.out.print("Nhập mô tả sản phẩm: ");
        this.descriptions = scanner.nextLine();

        System.out.print("Nhập trạng thái (true: đang bán, false: không bán): ");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayData() {
        System.out.println("Mã SP: " + productId + " | Tên SP: " + productName + " | Giá nhập: " + importPrice +
                " | Giá xuất: " + exportPrice + " | Lợi nhuận: " + profit + " | SL: " + quantity +
                " | Mô tả: " + descriptions + " | Trạng thái: " + (status ? "Đang bán" : "Không bán"));
    }

    public void calProfit() {
        this.profit = this.exportPrice - this.importPrice;
    }

    private boolean isDuplicateId(String id, Product[] products) {
        for (Product p : products) {
            if (p != null && p.getProductId().equals(id)) return true;
        }
        return false;
    }

    private boolean isDuplicateName(String name, Product[] products) {
        for (Product p : products) {
            if (p != null && p.getProductName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }
}

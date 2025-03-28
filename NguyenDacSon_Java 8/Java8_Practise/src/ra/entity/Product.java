package ra.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Product implements IProduct {
    private static int idCounter = 1;
    private int productId;
    private String productName;
    private float price;
    private String category;
    private LocalDate createdDate;

    public Product() {
        this.productId = idCounter++;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm: ");
        this.productName = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        this.price = Float.parseFloat(scanner.nextLine());
        System.out.print("Nhập danh mục sản phẩm: ");
        this.category = scanner.nextLine();
        this.createdDate = LocalDate.now();
    }

    @Override
    public void displayData() {
        System.out.println("ID: " + productId + " - Tên: " + productName + " - Giá: " + price + " - Danh mục: " + category + " - Ngày tạo: " + createdDate);
    }
}
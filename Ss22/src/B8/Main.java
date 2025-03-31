package B8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "B8/products.dat";

        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Laptop", 1200.50));
        productList.add(new Product(2, "Smartphone", 850.75));
        productList.add(new Product(3, "Tablet", 500.00));
        productList.add(new Product(4, "Smartwatch", 250.99));

        FileHandler.writeProductsToFile(fileName, productList);

        List<Product> loadedProducts = FileHandler.readProductsFromFile(fileName);

        if (loadedProducts != null) {
            System.out.println("\nDanh sách sản phẩm:");
            for (Product p : loadedProducts) {
                System.out.println(p);
            }
        }
    }
}

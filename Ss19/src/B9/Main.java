package B9;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> products = new LinkedHashMap<>();
        ProductProcessorImpl processor = new ProductProcessorImpl();

        products.put("Apple", 20);
        products.put("Banana", 11);
        products.put("Orange", 32);
        products.put("Watermelon", 150);
        products.put("Pineapple", 104);
        products.put("Grapes", 139);
        products.put("Mango", 74);

        List<Product> productList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            productList.add(new Product(entry.getKey(), entry.getValue()));
        }

        processor.hasExpensiveProducts(productList);
        System.out.println();

        int totalPrice = processor.calculateTotalValue(productList);
        System.out.println("Tổng giá trị các sản phầm: " + totalPrice);
        System.out.println();

        System.out.println("Danh sách những sản phẩm hiện có:");
        ProductProcessor.printProductList(productList);
    }
}

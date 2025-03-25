package B9;

import java.util.List;
import java.util.function.Predicate;

public interface ProductProcessor {
    abstract int calculateTotalValue(List<Product> products);

    static void printProductList(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    default void hasExpensiveProducts(List<Product> products) {
        Predicate<Product> isLarger = i -> i.getPrice() > 100;
        boolean isExpensiveProduct = false;
        for (Product product : products) {
            if (isLarger.test(product)) {
                System.out.println(product);
                isExpensiveProduct = true;
            }
        }
        if (!isExpensiveProduct) {
            System.out.println("Không có sản phâm đắt tiền");
        }
    }
}

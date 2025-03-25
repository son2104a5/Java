package B9;

import java.util.List;

public class ProductProcessorImpl implements ProductProcessor {
    @Override
    public int calculateTotalValue(List<Product> products) {
        int total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}

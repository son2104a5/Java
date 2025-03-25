import java.util.*;

public class B5 {
    public static void main(String[] args) {
        Map<String, Double> productList = new LinkedHashMap<String, Double>();
        productList.put("Laptop", 1299.0);
        productList.put("PC", 799.0);
        productList.put("Tủ lạnh", 1029.0);
        productList.put("Máy giặt", 899.0);
        productList.put("Điện thoại", 129.0);

        List<Map.Entry<String, Double>> sortList = new ArrayList<>();
        for (Map.Entry<String, Double> entry : productList.entrySet()) {
            if (entry.getValue() >= 500 && entry.getValue() <= 1500) {
                sortList.add(entry);
            }
        }

        sortList.sort(Map.Entry.comparingByValue());
        for (Map.Entry<String, Double> entry : sortList) {
            System.out.println("Tên sản phẩm: " + entry.getKey() + " - Giá sản phẩm:  " + entry.getValue());
        }
    }
}

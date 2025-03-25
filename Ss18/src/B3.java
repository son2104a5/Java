import java.util.LinkedHashMap;
import java.util.Map;

public class B3 {
    public static void main(String[] args) {
        Map<String, Double> proLinkedHashMap = new LinkedHashMap<>();
        proLinkedHashMap.put("Laptop", 1299.0);
        proLinkedHashMap.put("Máy giặt", 899.0);
        proLinkedHashMap.put("Tủ lạnh", 1029.0);
        proLinkedHashMap.put("Điện thoại", 129.0);
        proLinkedHashMap.put("PC", 799.0);

        System.out.println("products: " + proLinkedHashMap);
        proLinkedHashMap.remove("Laptop");
        System.out.println("products: " + proLinkedHashMap);
    }
}

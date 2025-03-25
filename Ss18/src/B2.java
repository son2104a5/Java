import java.util.HashMap;
import java.util.Map;

public class B2 {
    public static void main(String[] args) {
        Map<String, Double> proHashMap = new HashMap<String, Double>();
        proHashMap.put("Laptop", 1299.0);
        proHashMap.put("PC", 799.0);
        proHashMap.put("Tủ lạnh", 1029.0);
        proHashMap.put("Máy giặt", 899.0);
        proHashMap.put("Điện thoại", 129.0);

        System.out.println("Sản phẩm có tên Laptop: " + proHashMap.containsKey("Laptop"));
        System.out.println("Sản phẩm có giá 1000: " + proHashMap.containsKey(1000));
    }
}

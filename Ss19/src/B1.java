import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class B1 {
    public static void main(String[] args) {
        Map<Integer, String> strs = new HashMap<>();
        strs.put(1, "Java");
        strs.put(2, "");
        strs.put(3, "Lambda");
        strs.put(4, "Stream");
        strs.put(5, "");
        strs.put(6, "Functional");

        Predicate<String> isNone = str -> str.isEmpty();

        for (Integer key : strs.keySet()) {
            if (!isNone.test(strs.get(key))) {
                System.out.println(strs.get(key));
            }
        }
    }
}

import java.util.Map;
import java.util.TreeMap;

public class B4 {
    public static void main(String[] args) {
        Map<String, Double> listTree = new TreeMap<>();
        listTree.put("NV001", 280.0);
        listTree.put("NV002", 300.0);
        listTree.put("NV003", 290.0);
        listTree.put("NV004", 270.0);
        listTree.put("NV005", 320.0);

        System.out.println("listTree: " + listTree);

        listTree.put("NV001", 400.0);
        listTree.remove("NV002");
        System.out.println("listTree: " + listTree);
    }
}

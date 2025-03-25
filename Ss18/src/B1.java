import java.util.HashMap;
import java.util.Map;

public class B1 {
    public static void main(String[] args) {
        Map<String, Double> stuHashMap = new HashMap<>();
        stuHashMap.put("Nguyễn Văn A", 7.4);
        stuHashMap.put("Trần Thị B", 7.2);
        stuHashMap.put("Lê Đức C", 8.0);
        stuHashMap.put("Ngô Văn D", 6.6);
        stuHashMap.put("Nghiêm Hà E", 6.8);
        System.out.println("students: " + stuHashMap);

        System.out.println("Students Score:");
        for (Double stu : stuHashMap.values()) {
            System.out.println(stu);
        }
    }
}

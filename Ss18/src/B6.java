import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class B6 {
    public static void main(String[] args) {
        Map<String, Double> stuLinked = new LinkedHashMap<>();

        stuLinked.put("Nguyễn Văn A", 6.0);
        stuLinked.put("Nguyễn Văn B", 7.0);
        stuLinked.put("Nguyễn Văn C", 8.0);
        stuLinked.put("Nguyễn Văn D", 9.0);
        stuLinked.put("Nguyễn Văn E", 7.7);
        stuLinked.put("Nguyễn Văn F", 5.0);
        stuLinked.put("Nguyễn Văn G", 7.0);
        stuLinked.put("Nguyễn Văn H", 4.0);
        stuLinked.put("Nguyễn Văn I", 9.0);
        stuLinked.put("Nguyễn Văn J", 3.7);

        System.out.println("stuLinked: " + stuLinked);

        double avg = 0;
        for (Map.Entry<String, Double> entry : stuLinked.entrySet()) {
            avg += entry.getValue();
        }
        avg = avg / stuLinked.size();

        stuLinked.entrySet().removeIf(entry -> entry.getValue() < 5);

        System.out.println("stuLinked sau khi xóa: " + stuLinked);
    }
}

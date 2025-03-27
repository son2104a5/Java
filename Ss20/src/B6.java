import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class B6 {
    public static void main(String[] args) {
        List<String> items = List.of("apple", "banana", "apple", "orange", "banana", "apple");

        String currentTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        System.out.println("Thời điểm xử lý: " + currentTime);

        Map<String, Long> itemCount = items.stream()
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()));

        itemCount.forEach((item, count) -> System.out.println(item + " : " + count));
    }
}

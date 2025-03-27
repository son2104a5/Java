import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class B5 {
    public static void main(String[] args) {
        List<Integer> normalList = List.of(10, 5, 8, 20, 7);
        List<Integer> singleElementList = List.of(10);
        List<Integer> allSameList = List.of(10, 10, 10);

        findLargesrSecond(normalList);
        findLargesrSecond(singleElementList);
        findLargesrSecond(allSameList);
    }

    public static void findLargesrSecond(List<Integer> list) {
        Optional<Integer> secondLargest = list.stream()
                .distinct()
                .sorted((a, b) -> Integer.compare(b, a))
                .skip(1)
                .findFirst();

        System.out.println(secondLargest.map(num -> "Số lớn thứ hai: " + num)
                .orElse("Không tìm thấy số lớn thứ hai"));
    }
}

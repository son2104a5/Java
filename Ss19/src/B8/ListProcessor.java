package B8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public interface ListProcessor {
    abstract int sumOddNumbers(List<Integer> list);
    static void printList(List<Integer> list) {
        list.forEach(System.out::println);
    }
    default void checkOdd(List<Integer> list) {
        Predicate<Integer> isEven = i -> i % 2 != 0;
        List<Integer> listEven = new ArrayList<>();
        for (Integer i : list) {
            if (isEven.test(i)) {
                listEven.add(i);
            }
        }
        if (!listEven.isEmpty()) {
            System.out.println("Các phần tử lẻ:");
            printList(listEven);
            return;
        }
        System.out.println("Không có phần tử lẻ");
    }
}

package B7;

import java.util.List;

public interface ListProcessor {
    abstract void containsNegative(List<Integer> list);

    static void printList(List<Integer> list) {
        list.forEach(System.out::println);
    }
}

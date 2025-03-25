package B6;

import java.util.List;

public interface StringProcessor {
    abstract String processString(String input);

    default void printList(List<String> list) {
        list.forEach(System.out::println);
    }
}

package B7;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, -2, 10, 0, -7, 3);

        ListProcessImp listProcessImp = new ListProcessImp();

        ListProcessor.printList(list);
        listProcessImp.containsNegative(list);
    }
}

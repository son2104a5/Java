package B7;

import java.util.List;
import java.util.function.Predicate;

public class ListProcessImp implements ListProcessor{
    @Override
    public void containsNegative(List<Integer> list) {
        Predicate<Integer> isNegative = i -> i < 0;
        int count = 0;
        for (Integer i : list) {
            if (isNegative.test(i)) {
                count++;
            }
        }
        if (count > 0) {
            System.out.println("Danh sách chứa số âm");
            return;
        }
        System.out.println("Danh sách không chứa số âm");
    }
}

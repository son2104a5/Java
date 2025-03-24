import java.util.*;

public class B5 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Collections.addAll(set1, 1, 2, 3, 4, 5);

        Set<Integer> set2 = new HashSet<>();
        Collections.addAll(set2, 4, 5, 6, 7, 8);

        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);

        List<Integer> sortedList = new ArrayList<>(unionSet);
        Collections.sort(sortedList);

        System.out.println(sortedList);
    }
}

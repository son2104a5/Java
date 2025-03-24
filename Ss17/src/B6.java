import java.util.*;

public class B6 {
    public static void main(String[] args) {
        Set<Integer> nums1 = new HashSet<>();
        Collections.addAll(nums1, 10, 20, 30, 40);

        Set<Integer> nums2 = new HashSet<>();
        Collections.addAll(nums2, 30, 40, 50, 60);

        nums1.retainAll(nums2);

        List<Integer> result = new ArrayList<>(nums1);

        Collections.sort(result);
        System.out.println(result);
    }
}

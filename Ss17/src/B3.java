import java.util.HashSet;
import java.util.Set;

public class B3 {
    public static void main(String[] args) {
        Set<Integer> nums = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            nums.add(i + 1);
        }
        nums.removeIf(num -> num % 2 == 0);
        System.out.println(nums);
    }
}

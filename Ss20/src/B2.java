import java.util.Arrays;
import java.util.List;

public class B2 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int totalEven = nums.stream().filter(num -> num % 2 != 0).reduce(0, Integer::sum);

        System.out.print("Tổng các số lẻ: " + totalEven);
    }
}

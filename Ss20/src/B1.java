import java.util.Arrays;
import java.util.List;

public class B1 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.print("Các số chẵn: ");
        nums.stream().filter(num -> num % 2 == 0).forEach(System.out::println);
    }
}

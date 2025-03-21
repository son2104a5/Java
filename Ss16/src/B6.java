import java.util.ArrayList;

public class B6 {
    public static void main(String[] args) {
        ArrayList<Integer> original = new ArrayList<>();
        original.add(1);
        original.add(2);
        original.add(3);
        original.add(2);
        original.add(4);
        original.add(1);
        original.add(5);

        ArrayList<Integer> result = new ArrayList<>();

        for (Integer num : original) {
            if (!result.contains(num)) {
                result.add(num);
            }
        }

        System.out.println("Danh sách sau khi loại bỏ trùng lặp: " + result);
    }
}

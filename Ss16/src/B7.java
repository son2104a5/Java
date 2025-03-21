import java.util.ArrayList;
import java.util.List;

public class B7 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3); list.add(2); list.add(4);
        list.add(1); list.add(5);

        List<Integer> checked = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            int current = list.get(i);

            if (checked.contains(current)) continue;

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).equals(current)) {
                    count++;
                }
            }

            checked.add(current);
            System.out.println(current + " xuất hiện " + count + " lần");
        }
    }
}

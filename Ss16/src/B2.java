import java.util.*;

public class B2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }

        System.out.println("ArrayList trước khi xóa: " + list);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int item = iterator.next();
            if (item % 3 == 0) {
                iterator.remove();
            }
        }
        System.out.println("ArrayList sau khi xóa: " + list);
    }
}

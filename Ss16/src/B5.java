import java.util.ArrayList;

public class B5 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3); list.add(2); list.add(4); list.add(1); list.add(5);

        ArrayList<Integer> checked = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (checked.contains(num)) continue;

            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).equals(num)) {
                    count++;
                }
            }

            checked.add(num);
            System.out.println(num + " - " + count + " lần");
        }
    }
}

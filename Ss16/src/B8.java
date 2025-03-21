import java.util.ArrayList;

public class B8 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("banana");
        list.add("apple");
        list.add("pear");
        list.add("kiwi");
        list.add("grape");

        System.out.println("Trước khi sắp xếp: " + list);

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                String s1 = list.get(i);
                String s2 = list.get(j);

                if (s1.length() > s2.length() || (s1.length() == s2.length() && s1.compareTo(s2) > 0)) {
                    String temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }

        System.out.println("Sau khi sắp xếp: " + list);
    }
}

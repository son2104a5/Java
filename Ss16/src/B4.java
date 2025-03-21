import java.util.ArrayList;

public class B4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int total = 0;
        for (int i = 0; i < 6; i++) {
            list.add((int)(Math.random() * 10));
        }
        for (int i = 0; i < 6; i++) {
            total += list.get(i);
        }
        System.out.println(list);
        System.out.println("Tổng các phần tử có trong mảng là: " + total);
    }
}

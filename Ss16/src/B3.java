import java.util.ArrayList;

public class B3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int max, min;
        for (int i = 0; i < 6; i++) {
            list.add((int)(Math.random() * 10));
        }
        min = list.getFirst();
        max = list.getFirst();

        for (int n: list) {
            if (n < min) {
                min = n;
            }
            if (n > max) {
                max = n;
            }
        }
        System.out.println("min = " + min + " , max = " + max);
    }
}

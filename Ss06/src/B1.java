import java.util.Scanner;

public class B1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        str.trim();
        String[] strs = str.split(" ");
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            count++;
        }
        System.out.println(count);
    }
}

import java.util.*;

public class B8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Nhâp n: ");
        int n = sc.nextInt();

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char randomChar = (char) (random.nextInt(94) + 33);
            str.append(randomChar);
        }
        System.out.println(str.toString());
    }
}

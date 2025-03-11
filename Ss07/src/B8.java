import java.util.*;

public class B8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhâp n: ");
        int n = sc.nextInt();
        String char = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890";

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char randomChar = (Math.random() * char.length();
            str.append(randomChar);
        }
        System.out.println(str.toString());
    }
}

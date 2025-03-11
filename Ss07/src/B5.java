import java.util.Scanner;

public class B5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().trim();
        String[] strs = str.trim().split("\\s+");
        StringBuilder strAppend = new StringBuilder();

        for (int i = strs.length - 1; i >= 0 ; i--) {
            strAppend.append(strs[i]);
            if (i != 0) {
                strAppend.append(" ");
            }
        }
        System.out.println(strAppend.toString());
    }
}

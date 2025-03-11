import java.util.Scanner;

public class B1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String str3 = sc.nextLine();

        StringBuilder str = new StringBuilder();
        str.append(str1 + " ");
        str.append(str2 + " ");
        str.append(str3 + " ");
        String newStr = str.toString().toUpperCase();
        System.out.println(newStr);
    }
}

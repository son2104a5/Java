import java.util.Scanner;

public class B4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean check = false;

        StringBuilder str = new StringBuilder(sc.nextLine());
        StringBuilder strReverse = new StringBuilder(str);
        strReverse.reverse();
        for (int i = 0; i < strReverse.length(); i++) {
            if (strReverse.charAt(i) == str.charAt(i)) {
                check = true;
            } else {
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("Chuỗi đối xứng");
        } else {
            System.out.println("Chuỗi không đối xứng");
        }
    }
}

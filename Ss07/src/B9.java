import java.util.Scanner;

public class B9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        char currentChar;
        char checkChar;
        String str = sc.nextLine();
        checkChar = str.charAt(0);
        StringBuilder convertStr = new StringBuilder();
        convertStr.append(checkChar);
        for (int i = 0; i < str.length(); i++) {
            currentChar = str.charAt(i);
            if (checkChar == currentChar) {
                count++;
            } else {
                checkChar = currentChar;
                convertStr.append(count);
                convertStr.append(checkChar);
                count = 1;
            }
        }
        convertStr.append(count);
        System.out.println(convertStr.toString());
    }
}

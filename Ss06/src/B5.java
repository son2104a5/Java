import java.util.Scanner;
import java.util.regex.Pattern;

public class B5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = ".*[^a-zA-Z0-9,?].*";
        String str = sc.nextLine();
        String[] words = str.split(" ");
        int count = 0;
        for (String word : words) {
            if (word.matches(regex)) {
                count++;
            }
        }
        String[] specialWords = new String[count];

        int index = 0;
        for (String word : words) {
            if (word.matches(regex)) {
                specialWords[index++] = word;
            }
        }
        if (specialWords.length == 0) {
            System.out.println("Không có từ nào chứa ký tự đặc biệt.");
        } else {
            System.out.println(String.join(", ", specialWords));
        }
    }
}

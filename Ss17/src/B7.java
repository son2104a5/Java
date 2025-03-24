import java.util.*;

public class B7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String str = sc.nextLine();

        String[] words = str.toLowerCase().split("\\W+");

        List<String> wordList = new ArrayList<>(Arrays.asList(words));

        Set<String> uniqueWords = new HashSet<>(wordList);

        List<String> sortedWordList = new ArrayList<>(uniqueWords);
        Collections.sort(sortedWordList);

        for (String word : sortedWordList) {
            int count = 0;
            for (String word2 : wordList) {
                if (word.equals(word2)) {
                    count++;
                }
            }
            System.out.println(word + " : " + count);
        }
    }
}

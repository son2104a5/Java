package B5;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "B5/input.txt";

        List<String> players = Arrays.asList(
                "Văn Lâm",
                "Tiến Linh",
                "Xuân Sơn",
                "Hoàng Đức",
                "Văn Hậu"
        );

        FileHandler.writeToFile(fileName, players);

        List<String> names = FileHandler.readFromFile(fileName);

        if (names != null) {
            String longestName = NameProcessor.findLongestName(names);

            // In kết quả
            System.out.println("Tên cầu thủ dài nhất: " + longestName);
            System.out.println("Độ dài: " + longestName.length());
        }
    }
}

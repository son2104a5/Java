import java.util.Scanner;

public class B10 {
    public static void main(String[] args) {
        String[] texts = {
                "  Hello, World! This is a test 123.  ",
                "Java is fun!! Learn @ 2024?",
                "Contact us at 1800-555-0199!",
                "No numbers here! Just text...",
                "   "
        };

        for (int i = 0; i < texts.length; i++) {
            String text = texts[i];

            if (text.trim().isEmpty()) {
                System.out.println("\"Không có văn bản để xử lý.\"");
                System.out.println("N/A");
                System.out.println("----------");
                continue;
            }

            String cleaned = text.replaceAll("[^a-zA-Z0-9\\s]", "");
            cleaned = cleaned.toLowerCase().trim();
            cleaned = cleaned.replaceAll("\\s+", " ");

            System.out.println("\"" + cleaned + "\"");

            String[] numbers = cleaned.split(" ");
            String result = "[";
            boolean found = false;
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j].matches("[0-9]+")) {
                    if (found) result += ", ";
                    result += "\"" + numbers[j] + "\"";
                    found = true;
                }
            }
            result += "]";

            if (found) System.out.println(result);
            else System.out.println("[]");

            System.out.println("----------");
        }
    }
}

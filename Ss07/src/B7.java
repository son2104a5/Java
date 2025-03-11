import java.util.Scanner;

public class B7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] testCases = {
                "HelloWorld",
                "javaIsFun",
                "convertThisToSnake",
                "CamelCase",
                "PascalCaseExample",
                "oneword",
                "TwoWords",
                "UltraMegaLongTestString",
                "already_snake_case",
                ""
        };

        for (String test : testCases) {
            System.out.printf("Input: %-30s → Output: %s\n", test, toSnakeCase(test));
        }
    }

    public static String toSnakeCase(String input) {
        if (input == null || input.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (Character.isUpperCase(c)) {
                if (i != 0 && Character.isLowerCase(chars[i - 1])) {
                    result.append('_');
                } else if (i != 0 && Character.isUpperCase(chars[i - 1]) && i + 1 < chars.length && Character.isLowerCase(chars[i + 1])) {
                    result.append('_');
                }
                result.append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}

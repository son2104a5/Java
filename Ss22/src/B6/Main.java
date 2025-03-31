package B6;

public class Main {
    public static void main(String[] args) {
        String inputFile = "B6/input.txt";
        String outputFile = "B6/copy.txt";

        String content = "Lập trình Java thật thú vị!";
        FileHandler.writeToFile(inputFile, content);

        String readContent = FileHandler.readFromFile(inputFile);
        if (readContent != null) {
            String reversedContent = StringProcessor.reverseString(readContent);

            FileHandler.writeToFile(outputFile, reversedContent);

            String finalContent = FileHandler.readFromFile(outputFile);
            System.out.println("Nội dung sau khi đảo ngược: " + finalContent);
        }
    }
}

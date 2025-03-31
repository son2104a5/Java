package B3;

import java.io.*;

public class B3 {
    public static void main(String[] args) {
        String inputFile = "B3/input.txt";
        String copyFile = "B3/copy.txt";

        writeToFile(inputFile, "Đây là nội dung của file input.txt.\nDữ liệu sẽ được sao chép sang copy.txt");

        copyFileContent(inputFile, copyFile);

        System.out.println("Nội dung của copy.txt:");
        readFromFile(copyFile);
    }

    public static void writeToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Đã tạo file " + fileName + " và ghi nội dung thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public static void copyFileContent(String source, String destination) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Đã sao chép nội dung từ " + source + " sang " + destination + " thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi sao chép file: " + e.getMessage());
        }
    }

    public static void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}

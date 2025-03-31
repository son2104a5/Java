package B7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public static void writeSampleData(String fileName) {
        String data = "1,AU,Australia\n" +
                "2,CN,China\n" +
                "3,AU,Australia\n" +
                "4,CN,China\n" +
                "5,JP,Japan\n" +
                "6,CN,China\n" +
                "7,JP,Japan\n" +
                "8,TH,Thailand";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);
            System.out.println("Đã tạo file " + fileName + " thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public static List<Country> readCountriesFromFile(String fileName) {
        List<Country> countries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String code = parts[1].trim();
                    String name = parts[2].trim();
                    countries.add(new Country(id, code, name));
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
        return countries;
    }
}

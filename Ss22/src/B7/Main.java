package B7;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "B7/data.txt";

        FileHandler.writeSampleData(fileName);

        List<Country> countryList = FileHandler.readCountriesFromFile(fileName);

        System.out.println("\nDanh sách các quốc gia:");
        for (Country country : countryList) {
            System.out.println(country);
        }
    }
}

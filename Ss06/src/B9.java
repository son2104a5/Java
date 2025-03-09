import java.util.Scanner;

public class B9 {
    public static void main(String[] args) {
        String[] urls = {
                "https://www.example.com/path/to/resource",
                "http://google.com",
                "http://invalid-url",
                "ftp://abc.org",
                "https://domain.example.org/search?q=java",
                "http://localhost:8080"
        };

        for (int i = 0; i < urls.length; i++) {
            String url = urls[i];

            if (url.startsWith("http://")) {
                String rest = url.substring(7);
                int slashIndex = rest.indexOf('/');
                String domain = slashIndex != -1 ? rest.substring(0, slashIndex) : rest;
                String path = slashIndex != -1 ? rest.substring(slashIndex) : "";

                if (domain.length() > 0) {
                    System.out.println("Giao thức: http");
                    System.out.println("Tên miền: " + domain);
                    if (path.length() > 0) {
                        System.out.println("Đường dẫn: " + path);
                    } else {
                        System.out.println("Khng có đường dẫn");
                    }

                } else {
                    System.out.println("URL không hợp lệ");
                }
            } else if (url.startsWith("https://")) {
                String rest = url.substring(8);
                int slashIndex = rest.indexOf('/');
                String domain = slashIndex != -1 ? rest.substring(0, slashIndex) : rest;
                String path = slashIndex != -1 ? rest.substring(slashIndex) : "";

                if (domain.length() > 0) {
                    System.out.println("Giao thức: https");
                    System.out.println("Tên miền: " + domain);
                    System.out.println("Đường dẫn: " + path);
                } else {
                    System.out.println("URL không hợp lệ");
                }
            } else {
                System.out.println("URL không hợp lệ");
            }

            System.out.println("----------");
        }
    }
}

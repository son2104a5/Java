import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("Hello, Java World!");
        str.delete(5, 9);
        System.out.println(str);
        str.replace(7, 12, "Universe");
        System.out.println(str);
    }
}

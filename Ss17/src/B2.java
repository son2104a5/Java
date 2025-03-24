import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> setHashSet = new HashSet<String>();
        setHashSet.add("Java");
        setHashSet.add("Python");
        setHashSet.add("C++");
        setHashSet.add("JavaScript");

        System.out.print("Nhập chuỗi cần tìm: ");
        String s = sc.nextLine();
        System.out.println(setHashSet.contains(s) ? "Có chuỗi bạn tìm" : "Không có chuỗi bạn tìm");
    }
}

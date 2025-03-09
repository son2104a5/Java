import java.util.Scanner;

public class B3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        boolean flag = false;
        int index = 0;
        String charFind = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == charFind.charAt(0)) {
                flag = true;
                index = i;
            }
        }
        if (flag) {
            System.out.printf("Từ %s xuất hiện tại vị trí %d trong chuỗi", charFind, index);
        }
    }
}

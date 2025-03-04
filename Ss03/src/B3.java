import java.util.Scanner;

public class B3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float score = sc.nextFloat();

        if (score < 10 && score >= 8.5) {
            System.out.println("Xếp loại: Giỏi");
        } else if (score < 8.5 && score >= 6.5) {
            System.out.println("Xếp loại: Khá");
        } else if (score < 6.5 && score >= 5) {
            System.out.println("Xếp loại: Trung bình");
        } else  if (score < 5) {
            System.out.println("Xếp loại: Yếu");
        } else {
            System.out.println("Điểm không hợp lệ");
        }
    }
}

import java.util.Scanner;

public class B6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----------Nhập thông tin sinh viên----------");
        System.out.print("Nhập tên sinh viên: ");
        String studentName = sc.nextLine();

        System.out.print("Nhập điểm môn học 1: ");
        double subject1 = sc.nextDouble();
        System.out.print("Nhập điểm môn học 2: ");
        double subject2 = sc.nextDouble();
        System.out.print("Nhập điểm môn học 3: ");
        double subject3 = sc.nextDouble();

        double averageScore = (subject1 + subject2 + subject3) / 3;

        String evaluation = (averageScore >= 5.0) ? "Lên lớp" : "Học lại";

        System.out.println("\n----------Hiển thị thông tin sinh viên----------");
        System.out.println("Tên sinh viên: " + studentName);
        System.out.printf("Điểm môn 1: %.2f | Điểm môn 2: %.2f | Điểm môn 3: %.2f\n", subject1, subject2, subject3);
        System.out.printf("Điểm trung bình: %.2f\n", averageScore);
        System.out.println("Đánh giá: " + evaluation);

        sc.close();
    }
}

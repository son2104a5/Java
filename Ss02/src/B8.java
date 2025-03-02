import java.util.Scanner;

public class B8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã sinh viên: ");
        String studentId = sc.nextLine();

        System.out.print("Nhập tên sinh viên: ");
        String studentName = sc.nextLine();

        System.out.print("Nhập số điện thoại sinh viên: ");
        String phoneNumber = sc.nextLine();

        System.out.print("Nhập ngày sinh sinh viên (dd/mm/yyyy): ");
        String birthDate = sc.nextLine();

        System.out.print("Nhập giới tính sinh viên (1: Nam, 0: Nữ): ");
        int genderInput = sc.nextInt();
        String gender = (genderInput == 1) ? "Nam" : "Nữ";

        System.out.println("------------Nhập điểm sinh viên------------");
        System.out.print("Nhập điểm toán: ");
        double math = sc.nextDouble();
        System.out.print("Nhập điểm lý: ");
        double physics = sc.nextDouble();
        System.out.print("Nhập điểm hóa: ");
        double chemistry = sc.nextDouble();
        System.out.print("Nhập điểm sinh học: ");
        double biology = sc.nextDouble();
        System.out.print("Nhập điểm ngoại ngữ: ");
        double foreignLanguage = sc.nextDouble();

        double averageScore = (math + physics + chemistry + biology + foreignLanguage) / 5;

        System.out.println("------------Hiển thị thông tin sinh viên------------");
        System.out.printf("Mã sinh viên: %s | Tên sinh viên: %s | Giới tính: %s%n", studentId, studentName, gender);
        System.out.printf("Ngày sinh: %s | Số điện thoại: %s%n", birthDate, phoneNumber);
        System.out.printf("Điểm toán: %.2f | Điểm Vật Lý: %.2f | Điểm Hóa học: %.2f | Điểm Sinh học: %.2f | Điểm Ngoại ngữ: %.2f%n",
                math, physics, chemistry, biology, foreignLanguage);
        System.out.printf("Điểm trung bình: %.2f%n", averageScore);

        sc.close();
    }
}

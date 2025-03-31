import java.util.Scanner;

public class B1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = 1, secondNumber = 1, divNumbers = 0;
        try {
            System.out.println("Nhập vào số nguyên thứ nhất:");
            firstNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập vào số nguyên thứ hai:");
            secondNumber = Integer.parseInt(scanner.nextLine());
            divNumbers = firstNumber / secondNumber;
        } catch (ArithmeticException e1) {
            System.err.println("Không thể chia cho 0");
            return;
        } catch (NumberFormatException e2) {
            System.err.println("Sai định dạng số nguyên.");
            return;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Kêt quả phép chia: " + divNumbers);
    }
}

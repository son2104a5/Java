import java.util.Scanner;

public class B5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float num1 = sc.nextFloat();
        float num2 = sc.nextFloat();
        float result = 0;

        char operator = sc.next().charAt(0);

        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println("Kết quả: " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("Kết quả: " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("Kết quả: " + result);
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Không thể chia cho 0");
                } else {
                    result = num1 / num2;
                    System.out.println("Kết quả: " + result);
                }
                break;
        }
    }
}

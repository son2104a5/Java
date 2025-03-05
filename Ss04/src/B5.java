import java.util.Scanner;

public class B5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int checkPfN;
        int countLoop = 0;

        if (n < 0) {
            System.out.println("Số không hợp lệ");
            return;
        }

        for (int i = 1; i < n - 1; i++) {
            checkPfN = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    checkPfN += j;
                    countLoop++;
                }
                if (countLoop == 1) {
                    System.out.printf("Các số hoàn hảo nhỏ hơn %d là: ", n);
                }
            }
            if (checkPfN == i) {
                System.out.printf("%d ", i);
            }
        }

        if (countLoop == 0) {
            System.out.printf("Không có số hoàn hảo nào nhỏ hơn %d", n);
        }
    }
}

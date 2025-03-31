package B7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1_000_000);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("\nNhập số tiền muốn rút (nhập 0 để thoát): ");
            String input = sc.nextLine();

            if (input.equals("0")) break;

            try {
                double amount = Double.parseDouble(input);
                account.withdraw(amount);
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
            } catch (BankAccount.InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Kết thúc chương trình.");
    }
}

package B9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<String, BankAccount> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        accounts.put("1001", new BankAccount("1001", 500000));
        accounts.put("1002", new BankAccount("1002", 200000));

        while (true) {
            System.out.println("\n===== HỆ THỐNG NGÂN HÀNG =====");
            System.out.println("1. Gửi tiền");
            System.out.println("2. Rút tiền");
            System.out.println("3. Chuyển tiền");
            System.out.println("4. Thoát");
            System.out.print("Chọn thao tác: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên!");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        deposit(scanner);
                        break;
                    case 2:
                        withdraw(scanner);
                        break;
                    case 3:
                        transfer(scanner);
                        break;
                    case 4:
                        System.out.println("Thoát chương trình.");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Nhập số tài khoản: ");
        String accId = scanner.nextLine();
        BankAccount acc = accounts.get(accId);
        if (acc == null) {
            System.out.println("Tài khoản không tồn tại.");
            return;
        }

        System.out.print("Nhập số tiền gửi: ");
        try {
            double depositAmount = Double.parseDouble(scanner.nextLine());
            acc.deposit(depositAmount);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập số hợp lệ.");
        } catch (BankAccount.InvalidAmountException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Nhập số tài khoản: ");
        String accId = scanner.nextLine();
        BankAccount acc = accounts.get(accId);
        if (acc == null) {
            System.out.println("Tài khoản không tồn tại.");
            return;
        }

        System.out.print("Nhập số tiền rút: ");
        try {
            double withdrawAmount = Double.parseDouble(scanner.nextLine());
            acc.withdraw(withdrawAmount);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập số hợp lệ.");
        } catch (BankAccount.InvalidAmountException | BankAccount.InsufficientFundsException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void transfer(Scanner scanner) {
        System.out.print("Nhập tài khoản nguồn: ");
        String senderId = scanner.nextLine();
        BankAccount sender = accounts.get(senderId);
        if (sender == null) {
            System.out.println("Tài khoản nguồn không tồn tại.");
            return;
        }

        System.out.print("Nhập tài khoản đích: ");
        String receiverId = scanner.nextLine();
        BankAccount receiver = accounts.get(receiverId);
        if (receiver == null) {
            System.out.println("Tài khoản đích không tồn tại.");
            return;
        }

        System.out.print("Nhập số tiền chuyển: ");
        try {
            double transferAmount = Double.parseDouble(scanner.nextLine());
            sender.transfer(receiver, transferAmount);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập số hợp lệ.");
        } catch (BankAccount.InvalidAmountException | BankAccount.InsufficientFundsException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}

package B8;

public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("123456", "Nguyen Van A", 5000);
        BankAccount acc2 = new BankAccount("654321", "Tran Thi B", 3000);

        System.out.println("== Tài khoản 1 ban đầu ==");
        acc1.display();
        System.out.println("\n== Tài khoản 2 ban đầu ==");
        acc2.display();

        System.out.println("\n== Giao dịch: Nạp tiền vào tài khoản 1 ==");
        acc1.deposit(2000);
        acc1.display();

        System.out.println("\n== Giao dịch: Rút tiền từ tài khoản 1 ==");
        acc1.withdraw(1000);
        acc1.display();

        System.out.println("\n== Giao dịch: Chuyển tiền từ tài khoản 1 sang tài khoản 2 ==");
        acc1.transfer(acc2, 1500);
        acc1.display();
        acc2.display();
    }
}

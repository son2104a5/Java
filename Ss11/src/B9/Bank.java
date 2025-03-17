package B9;

public class Bank {
    private BankAccount[] accounts;
    private int count;

    public Bank() {
        accounts = new BankAccount[10];
        count = 0;
    }

    public void addAccount(BankAccount account) {
        if (count < accounts.length) {
            accounts[count++] = account;
            System.out.println("Đã thêm tài khoản " + account.accountNumber + " vào ngân hàng.");
        } else {
            System.out.println("Ngân hàng đã đầy, không thể thêm tài khoản mới.");
        }
    }

    public void displayAllBalances() {
        System.out.println("\n===== THÔNG TIN SỐ DƯ CÁC TÀI KHOẢN =====");
        for (int i = 0; i < count; i++) {
            accounts[i].displayBalance();
        }
    }
}

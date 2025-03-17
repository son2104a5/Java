package B9;

public class SavingAccount extends BankAccount {

    public SavingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Rút tiền thất bại! Số dư không đủ trong tài khoản tiết kiệm " + accountNumber);
        } else {
            balance -= amount;
            System.out.println("Rút " + amount + " từ tài khoản tiết kiệm " + accountNumber + " thành công.");
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Nạp " + amount + " vào tài khoản tiết kiệm " + accountNumber + " thành công.");
    }

    @Override
    public void displayBalance() {
        System.out.println("Tài khoản tiết kiệm " + accountNumber + " có số dư: $" + balance);
    }
}

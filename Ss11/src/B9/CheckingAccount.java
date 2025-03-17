package B9;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Rút " + amount + " từ tài khoản vãng lai " + accountNumber + " thành công (số dư có thể âm).");
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Nạp " + amount + " vào tài khoản vãng lai " + accountNumber + " thành công.");
    }

    @Override
    public void displayBalance() {
        System.out.println("Tài khoản vãng lai " + accountNumber + " có số dư: $" + balance);
    }
}


package B9;

public class BankAccount {
    private String accountId;
    private double balance;

    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Số tiền gửi phải lớn hơn 0.");
        }
        balance += amount;
        System.out.println("Nạp thành công. Số dư mới: " + balance);
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Số tiền rút phải lớn hơn 0.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Số dư không đủ.");
        }
        balance -= amount;
        System.out.println("Rút thành công. Số dư mới: " + balance);
    }

    public void transfer(BankAccount recipient, double amount) throws InvalidAmountException, InsufficientFundsException {
        if (recipient == null) {
            throw new InvalidAmountException("Tài khoản đích không tồn tại.");
        }
        if (amount <= 0) {
            throw new InvalidAmountException("Số tiền chuyển phải lớn hơn 0.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Số dư không đủ để chuyển.");
        }
        balance -= amount;
        recipient.balance += amount;
        System.out.println("Chuyển thành công. Số dư mới của tài khoản nguồn: " + balance);
    }

    public static class InsufficientFundsException extends RuntimeException {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }

    public static class InvalidAmountException extends Exception {
        public InvalidAmountException(String message) {
            super(message);
        }
    }
}

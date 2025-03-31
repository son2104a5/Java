package B7;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Lỗi: Số tiền rút vượt quá số dư!");
        }
        if (balance - amount < 50000) {
            throw new InsufficientBalanceException("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
        }
        balance -= amount;
        System.out.println("Rút tiền thành công! Số dư còn lại: " + balance + " đồng.");
    }

    public static class InsufficientBalanceException extends Exception {
        public InsufficientBalanceException(String message) {
            super(message);
        }
    }
}

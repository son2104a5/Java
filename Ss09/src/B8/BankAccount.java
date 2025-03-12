package B8;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Nạp tiền thành công: +" + amount);
        } else {
            System.out.println("Số tiền nạp không hợp lệ.");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Số dư không đủ.");
        } else {
            balance -= amount;
            System.out.println("Rút tiền thành công: -" + amount);
        }
    }

    public void transfer(BankAccount recipient, double amount) {
        if (amount > balance) {
            System.out.println("Số dư không đủ để chuyển tiền.");
        } else {
            balance -= amount;
            recipient.balance += amount;
            System.out.println("Chuyển tiền thành công: -" + amount + " đến tài khoản " + recipient.accountNumber);
        }
    }

    public void display() {
        System.out.println("Số tài khoản: " + accountNumber);
        System.out.println("Chủ tài khoản: " + accountHolder);
        System.out.println("Số dư hiện tại: " + balance);
    }
}


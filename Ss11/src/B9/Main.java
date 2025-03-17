package B9;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        BankAccount saving1 = new SavingAccount("SA001", 1000);
        BankAccount saving2 = new SavingAccount("SA002", 500);

        BankAccount checking1 = new CheckingAccount("CA001", 200);
        BankAccount checking2 = new CheckingAccount("CA002", 0);

        bank.addAccount(saving1);
        bank.addAccount(saving2);
        bank.addAccount(checking1);
        bank.addAccount(checking2);

        saving1.deposit(200);
        saving1.withdraw(1500);
        saving2.withdraw(300);

        checking1.withdraw(300);
        checking2.withdraw(100);
        checking2.deposit(500);

        bank.displayAllBalances();
    }
}


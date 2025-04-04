package B1;

public class Main {
    public static void main(String[] args) {
        Account account1 = Account.getInstance();
        account1.setAccountInfo(1, "John Doe", 30);
        account1.displayInfo();

        Account account2 = Account.getInstance();
        account2.displayInfo();

        System.out.println("account1 == account2? " + (account1 == account2));
    }
}

package B10;

public class CreditCard extends PaymentMethod {
    public CreditCard(double amount) {
        super(amount);
    }

    @Override
    public double calculateFee() {
        return amount * 0.02;
    }

    @Override
    public double processPayment() {
        double totalAmount = amount + calculateFee();
        return totalAmount;
    }

    @Override
    public String processPayment(double amount, String currency) {
        this.amount = amount;
        double totalAmount = processPayment();
        return totalAmount + " " + currency;
    }
}


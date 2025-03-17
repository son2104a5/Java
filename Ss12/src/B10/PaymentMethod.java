package B10;

public abstract class PaymentMethod {
    protected double amount;

    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFee();
    public abstract double processPayment();
    public abstract String processPayment(double amount, String currency);
}


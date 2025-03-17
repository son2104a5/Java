package B10;

public class Main {
    public static void main(String[] args) {
        PaymentMethod creditCard = new CreditCard(1000);
        PaymentMethod debitCard = new DebitCard(1000);
        PaymentMethod cash = new Cash(1000);

        System.out.println("=== Giao dịch CreditCard ===");
        System.out.println("Phí: " + creditCard.calculateFee());
        System.out.println("Tổng tiền phải trả: " + creditCard.processPayment());
        System.out.println("Thanh toán bằng USD: " + creditCard.processPayment(1000, "USD"));

        System.out.println("\n=== Giao dịch DebitCard ===");
        System.out.println("Phí: " + debitCard.calculateFee());
        System.out.println("Tổng tiền phải trả: " + debitCard.processPayment());
        System.out.println("Thanh toán bằng EUR: " + debitCard.processPayment(1000, "EUR"));

        System.out.println("\n=== Giao dịch Cash ===");
        System.out.println("Phí: " + cash.calculateFee());
        System.out.println("Tổng tiền phải trả: " + cash.processPayment());
        System.out.println("Thanh toán bằng VND: " + cash.processPayment(1000, "VND"));
    }
}


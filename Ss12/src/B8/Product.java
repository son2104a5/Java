package B8;

public class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getDiscount() {
        return 0.0;
    }

    public double getFinalPrice() {
        double discount = getDiscount();
        return price - (price * discount / 100);
    }

    public double getDiscount(int quantity) {
        if (quantity > 100) {
            return 5.0;
        } else {
            return getDiscount();
        }
    }

    public double getFinalPrice(int quantity) {
        double discount = getDiscount(quantity);
        return price - (price * discount / 100);
    }
}

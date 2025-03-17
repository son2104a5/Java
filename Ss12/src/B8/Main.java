package B8;

public class Main {
    public static void main(String[] args) {
        Product product = new Product("Generic Product", 1000);
        Electronics electronics = new Electronics("Laptop", 2000);
        Clothing clothing = new Clothing("T-Shirt", 500);
        Food food = new Food("Apple", 100);

        System.out.println("=== Giá sau chiết khấu mặc định ===");
        System.out.println(product.name + ": " + product.getFinalPrice());
        System.out.println(electronics.name + ": " + electronics.getFinalPrice());
        System.out.println(clothing.name + ": " + clothing.getFinalPrice());
        System.out.println(food.name + ": " + food.getFinalPrice());

        System.out.println("\n=== Giá sau chiết khấu theo số lượng (quantity = 150) ===");
        int quantity = 150;
        System.out.println(product.name + ": " + product.getFinalPrice(quantity));
        System.out.println(electronics.name + ": " + electronics.getFinalPrice(quantity));
        System.out.println(clothing.name + ": " + clothing.getFinalPrice(quantity));
        System.out.println(food.name + ": " + food.getFinalPrice(quantity));
    }
}

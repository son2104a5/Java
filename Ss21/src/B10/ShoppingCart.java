package B10;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, CartItem> cartItems = new HashMap<>();

    public void addToCart(Product product, int quantity) throws InvalidQuantityException {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Lỗi: Số lượng không hợp lệ!");
        }

        if (cartItems.containsKey(product.getId())) {
            cartItems.get(product.getId()).increaseQuantity(quantity);
        } else {
            cartItems.put(product.getId(), new CartItem(product, quantity));
        }

        System.out.println("Đã thêm " + quantity + " " + product.getName() + " vào giỏ hàng.");
    }

    public void removeFromCart(String productId) throws ProductNotFoundException {
        if (!cartItems.containsKey(productId)) {
            throw new ProductNotFoundException("Lỗi: Không tìm thấy sản phẩm trong giỏ hàng!");
        }

        cartItems.remove(productId);
        System.out.println("Đã xoá sản phẩm khỏi giỏ hàng.");
    }

    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Giỏ hàng trống.");
            return;
        }

        System.out.println("\n=== Giỏ hàng ===");
        for (CartItem item : cartItems.values()) {
            System.out.println(item.getProduct().getName() + " - " + item.getQuantity() + " x " + item.getProduct().getPrice());
        }
    }

    public void checkout() {
        double total = 0;
        for (CartItem item : cartItems.values()) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        System.out.println("Tổng tiền cần thanh toán: " + total);
    }

    public static class InvalidQuantityException extends Exception {
        public InvalidQuantityException(String message) {
            super(message);
        }
    }

    public static class ProductNotFoundException extends Exception {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }
}


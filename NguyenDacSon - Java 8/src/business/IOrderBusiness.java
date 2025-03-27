package business;

import entity.Order;

import java.util.List;
import java.util.Scanner;

public interface IOrderBusiness {
    void addOrder(Scanner scanner, List<Order> orders);
    void displayOrder(List<Order> orders);
    void updateOrderStatus(Scanner scanner);
    List<Order> getOrdersDelivered();
    List<Order> getOrdersOverdue();

    default double getTotalRevenue() {
        return 0;
    }
}

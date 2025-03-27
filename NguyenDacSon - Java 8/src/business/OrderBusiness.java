package business;

import entity.Order;

import java.util.List;
import java.util.Scanner;

public class OrderBusiness implements IOrderBusiness {

    @Override
    public void addOrder(Scanner scanner, List<Order> orders) {
        Order order = new Order();
        order.inputData(scanner);
        orders.add(order);
    }

    @Override
    public void displayOrder(List<Order> orders) {
        orders.forEach(order -> System.out.println(order.toString()));
    }

    @Override
    public void updateOrderStatus(Scanner scanner) {

    }

    @Override
    public List<Order> getOrdersDelivered() {
        return List.of();
    }

    @Override
    public List<Order> getOrdersOverdue() {
        return List.of();
    }
}

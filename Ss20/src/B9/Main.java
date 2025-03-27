package B9;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
            new Order(1, "Quý", LocalDate.of(2025, 3, 20), Optional.of(LocalDate.of(2025, 3, 25))),
            new Order(2, "Lan", LocalDate.of(2025, 3, 21), Optional.empty()),
            new Order(3, "Minh", LocalDate.of(2025, 3, 22), Optional.of(LocalDate.of(2025, 3, 23))),
            new Order(4, "Huyền", LocalDate.of(2025, 3, 23), Optional.empty()),
            new Order(5, "Việt", LocalDate.of(2025, 3, 23), Optional.of(LocalDate.of(2025, 3, 30)))
        );

        System.out.println("====== Danh sách đơn hàng đã giao ======");
        orders.stream()
                .filter(o -> o.getDeliveryDate().isPresent())
                .forEach(Order::toDisplayString);

        System.out.println("====== Danh sách đơn hàng chưa giao ======");
        orders.stream()
                .filter(o -> o.getDeliveryDate().isEmpty())
                .forEach(Order::toDisplayString);

        long count = orders.stream()
                .filter(o -> o.getDeliveryDate()
                        .filter(date -> !date.isBefore(LocalDate.of(2025, 3, 17)) && !date.isAfter(LocalDate.of(2025, 3, 23)))
                        .isPresent()).count();
        System.out.println("== Số đơn hàng đã giao từ ngày 2025-03-17 đến 2025-03-23 ==\n" +
                "Tổng đơn: " + count);
    }
}

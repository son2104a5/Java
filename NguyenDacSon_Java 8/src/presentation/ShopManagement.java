package presentation;

import business.CustomerBusiness;
import business.OrderBusiness;
import entity.Customer;
import entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {
    public static final List<Customer> listCustomers = new ArrayList<Customer>();
    public static final List<Order> listOrders = new ArrayList<>();

    public static void main(String[] args) {
        ShopManagement shopManagement = new ShopManagement();

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("**********************SHOP MENU*******************\n" +
                    "1. Quản lý khách hàng\n" +
                    "2. Quản lý đơn hàng\n" +
                    "3. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> customerMenu(scanner);
                case 2 -> orderMenu(scanner);
                case 3 -> {
                    System.out.println("Tạm biệt.");
                    System.exit(0);
                }
            }
        } while (true);
    }

    public static void customerMenu(Scanner scanner) {
        int choice;
        CustomerBusiness customerBusiness = new CustomerBusiness();
        do {
            System.out.println("***********************CUSTOMER MENU******************\n" +
                    "1. Danh sách khách hàng\n" +
                    "2. Thêm mới khách hàng\n" +
                    "3. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> customerBusiness.displayCustomers();
                case 2 -> customerBusiness.addCustomer(scanner);
                case 3 -> System.out.println("Thoát menu khách hàng...");
            }
        } while (choice != 3);
    }

    public static void orderMenu(Scanner scanner) {
        int choice;
        OrderBusiness orderBusiness = new OrderBusiness();
        do {
            System.out.println("***********************ORDER MENU**********************\n" +
                    "1. Danh sách đơn hàng\n" +
                    "2. Thêm mới đơn hàng\n" +
                    "3. Cập nhật trạng thái đơn hàng\n" +
                    "4. Danh sách đơn hàng quá hạn\n" +
                    "5. Thống kê số lượng đơn hàng đã giao (Trạng thái true)\n" +
                    "6. Tính tổng doanh thu các đơn hàng đã giao\n" +
                    "7. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> orderBusiness.displayOrders();
                case 2 -> orderBusiness.addOrder(scanner);
                case 3 -> orderBusiness.updateOrderStatus(scanner);
                case 4 -> orderBusiness.getOrderOverdue();
                case 5 -> orderBusiness.getOrderDelivied();
                case 6 -> orderBusiness.getTotalRevenue();
                case 7 -> System.out.println("Thoát menu đơn hàng...");
            }
        } while (choice != 7);
    }
}
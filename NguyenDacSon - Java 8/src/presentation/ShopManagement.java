package presentation;

import business.CustomerBusiness;
import business.OrderBusiness;
import entity.Customer;
import entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopManagement extends OrderBusiness {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int customerChoice, orderChoice;
        List<Customer> customers = new ArrayList<Customer>();
        List<Order> orders = new ArrayList<Order>();
        do {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    do {
                        customerMenu();
                        customerChoice = scanner.nextInt();
                        switch (customerChoice) {
                            case 1 -> CustomerBusiness.displayCustomer(customers);
                            case 2 -> CustomerBusiness.addCustomer(scanner, customers);
                            case 3 -> System.out.println("Đã thoát menu khách hàng.");
                        }
                    } while (customerChoice != 3);
                    break;
                case 2:
                    do {
                        orderMenu();
                        orderChoice = scanner.nextInt();
                        switch (orderChoice) {
                            case 1:
                                OrderBusiness.displayOrders(orders);
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                System.out.println("Đã thoát chức năng đơn hàng.");
                                break;
                        }
                    } while (orderChoice != 7);
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình");
                    System.exit(0);
            }
        } while (true);
    }

    public static void displayMenu() {
        System.out.println("**********************SHOP MENU*******************\n" +
                "1. Quản lý khách hàng\n" +
                "2. Quản lý đơn hàng\n" +
                "3. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    public static void customerMenu() {
        System.out.println("***********************CUSTOMER MENU******************\n" +
                "1. Danh sách khách hàng\n" +
                "2. Thêm mới khách hàng\n" +
                "3. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    public static void orderMenu() {
        System.out.println("***********************ORDER MENU**********************\n" +
                "1. Danh sách đơn hàng\n" +
                "2. Thêm mới đơn hàng\n" +
                "3. Cập nhật trạng thái đơn hàng\n" +
                "4. Danh sách đơn hàng quá hạn\n" +
                "5. Thống kê số lượng đơn hàng đã giao (Trạng thái true)\n" +
                "6. Tính tổng doanh thu các đơn hàng đã giao\n" +
                "7. Thoát");
        System.out.print("Chọn chức năng: ");
    }
}

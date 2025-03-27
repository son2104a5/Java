package business;

import entity.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerBusiness {

    public static void addCustomer(Scanner scanner, List<Customer> customers) {
        System.out.print("Nhập số khách hàng muốn thêm: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Customer customer = new Customer();
            customer.inputData(scanner);
            customers.add(customer);
        }
    }

    public static void displayCustomer(List<Customer> customers) {
        customers.forEach(customer -> System.out.println(customer.toString()));
    }
}

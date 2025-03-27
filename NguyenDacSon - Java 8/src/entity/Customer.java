package entity;

import java.util.Optional;
import java.util.Scanner;

public class Customer implements IApp {
    public static int currentCustomerId = 1;
    @Override
    public void inputData(Scanner scanner) {
        do {
            System.out.print("Nhập tên khách hàng: ");
            this.name = scanner.next();
            if (this.name.isEmpty()) {
                System.out.println("Tên không được để trống");
            } else {
                break;
            }
        } while (true);
        System.out.print("Nhập email khách hàng: ");
        this.email = Optional.of(scanner.next());
        currentCustomerId++;
    }

    private int id;
    private String name;
    private Optional<String> email;

    public Customer() {
    }

    public Customer(String name, Optional<String> email) {
        this.id = currentCustomerId++;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email.orElse("Không có Email");
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email=" + email +
                '}';
    }
}

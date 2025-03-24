package B10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ DANH BẠ =====");
            System.out.println("1. Thêm liên lạc");
            System.out.println("2. Xóa liên lạc theo SĐT");
            System.out.println("3. Tìm kiếm liên lạc theo SĐT");
            System.out.println("4. Hiển thị danh bạ");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập SĐT: ");
                    String phone = sc.nextLine();
                    manager.addContact(new Contact(name, phone));
                    break;
                case 2:
                    System.out.print("Nhập SĐT cần xóa: ");
                    String delPhone = sc.nextLine();
                    if (manager.removeContactByPhone(delPhone)) {
                        System.out.println("Đã xóa liên lạc.");
                    } else {
                        System.out.println("Không tìm thấy liên lạc.");
                    }
                    break;
                case 3:
                    System.out.print("Nhập SĐT cần tìm: ");
                    String findPhone = sc.nextLine();
                    Contact found = manager.findContactByPhone(findPhone);
                    if (found != null) {
                        System.out.println("Liên lạc: " + found);
                    } else {
                        System.out.println("Không tìm thấy liên lạc.");
                    }
                    break;
                case 4:
                    System.out.println("\nDanh sách liên lạc:");
                    manager.displayContacts();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 5);
    }
}

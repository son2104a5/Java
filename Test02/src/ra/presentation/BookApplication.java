package ra.presentation;

import ra.business.BookBusiness;
import ra.entity.Book;
import ra.validate.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n----------------------------Book Menu----------------------------");
            System.out.println("1. Hiển thị danh sách các cuốn sách");
            System.out.println("2. Thêm mới sách");
            System.out.println("3. Xóa sách");
            System.out.println("4. Tìm kiếm sách");
            System.out.println("5. Sắp xếp");
            System.out.println("0. Thoát chương trình");
            System.out.println("----------------------------------------------------------------");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = Validator.inputInt(scanner);

            switch (choice) {
                case 1:
                    List<Book> books = BookBusiness.getBooks();
                    if (books.isEmpty()) {
                        System.out.println("Danh sách sách rỗng.");
                    } else {
                        books.forEach(Book::displayData);
                    }
                    break;
                case 2:
                    System.out.print("Nhập số lượng sách muốn thêm: ");
                    int count = Validator.inputInt(scanner, 1);
                    List<Book> newBooks = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        System.out.println("Nhập thông tin sách thứ " + (i + 1) + ":");
                        Book book = new Book();
                        book.inputData(scanner);
                        System.out.print("Nhập mã sách: ");
                        book.setBookId(Validator.inputString(scanner, 1, 20));
                        newBooks.add(book);
                    }
                    BookBusiness.addBooks(newBooks);
                    System.out.println("Thêm sách thành công.");
                    break;
                case 3:
                    System.out.print("Nhập mã sách cần xóa: ");
                    String delId = scanner.nextLine();
                    boolean removed = BookBusiness.removeBook(delId);
                    if (removed) {
                        System.out.println("Đã xóa sách thành công.");
                    } else {
                        System.out.println("Không tìm thấy sách có mã tương ứng.");
                    }
                    break;
                case 4:
                    System.out.println("1. Tìm theo tiêu đề");
                    System.out.println("2. Tìm theo thể loại");
                    System.out.println("3. Tìm theo khoảng giá");
                    System.out.print("Chọn loại tìm kiếm: ");
                    int searchType = Validator.inputInt(scanner);
                    switch (searchType) {
                        case 1:
                            System.out.print("Nhập tiêu đề cần tìm: ");
                            String title = scanner.nextLine();
                            BookBusiness.searchByTitle(title).forEach(Book::displayData);
                            break;
                        case 2:
                            System.out.print("Nhập thể loại cần tìm: ");
                            String category = scanner.nextLine();
                            BookBusiness.searchByCategory(category).forEach(Book::displayData);
                            break;
                        case 3:
                            System.out.print("Giá từ: ");
                            double from = Validator.inputDouble(scanner, 0);
                            System.out.print("Đến: ");
                            double to = Validator.inputDouble(scanner, from);
                            BookBusiness.searchByPriceRange(from, to).forEach(Book::displayData);
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;
                case 5:
                    System.out.println("1. Sắp xếp theo tiêu đề (tăng dần)");
                    System.out.println("2. Sắp xếp theo tiêu đề (giảm dần)");
                    System.out.println("3. Sắp xếp theo giá (tăng dần)");
                    System.out.println("4. Sắp xếp theo giá (giảm dần)");
                    System.out.print("Chọn kiểu sắp xếp: ");
                    int sortType = Validator.inputInt(scanner);
                    switch (sortType) {
                        case 1:
                            BookBusiness.sortByTitle(true);
                            break;
                        case 2:
                            BookBusiness.sortByTitle(false);
                            break;
                        case 3:
                            BookBusiness.sortByPrice(true);
                            break;
                        case 4:
                            BookBusiness.sortByPrice(false);
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.");
                    }
                    System.out.println("Danh sách sau khi sắp xếp:");
                    BookBusiness.getBooks().forEach(Book::displayData);
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }
}

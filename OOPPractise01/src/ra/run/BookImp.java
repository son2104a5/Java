package ra.run;

import ra.entity.Book;

import java.util.*;

public class BookImp {
    static Scanner sc = new Scanner(System.in);
    static List<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("************ MENU ************");
            System.out.println("1. Nhập thông tin n sách");
            System.out.println("2. Tính lợi nhuận các sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp theo giá bán tăng dần");
            System.out.println("5. Sắp xếp theo lợi nhuận giảm dần");
            System.out.println("6. Tìm sách theo tên");
            System.out.println("7. Thống kê số lượng sách theo năm XB");
            System.out.println("8. Thống kê số lượng sách theo tác giả");
            System.out.println("9. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> inputBooks();
                case 2 -> calcInterests();
                case 3 -> displayBooks();
                case 4 -> sortByExportPrice();
                case 5 -> sortByInterest();
                case 6 -> searchByName();
                case 7 -> statByYear();
                case 8 -> statByAuthor();
                case 9 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Chọn không hợp lệ.");
            }
        } while (choice != 9);
    }

    static void inputBooks() {
        System.out.print("Nhập số lượng sách: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            Book book = new Book();
            book.inputData(sc, bookList.toArray(new Book[0]), bookList.size());
            bookList.add(book);
        }
    }

    static void calcInterests() {
        for (Book b : bookList) {
            b.calcInterest();
        }
        System.out.println("Đã tính lợi nhuận.");
    }

    static void displayBooks() {
        for (Book b : bookList) {
            b.displayData();
        }
    }

    static void sortByExportPrice() {
        bookList.sort(Comparator.comparing(Book::getExportPrice));
        displayBooks();
    }

    static void sortByInterest() {
        bookList.sort((a, b) -> Float.compare(b.getInterest(), a.getInterest()));
        displayBooks();
    }

    static void searchByName() {
        System.out.print("Nhập tên sách cần tìm: ");
        String name = sc.nextLine();
        boolean found = false;
        for (Book b : bookList) {
            if (b.getBookName().equalsIgnoreCase(name)) {
                b.displayData();
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy.");
    }

    static void statByYear() {
        Map<Integer, Integer> map = new HashMap<>();
        for (Book b : bookList) {
            map.put(b.getYear(), map.getOrDefault(b.getYear(), 0) + 1);
        }
        map.forEach((year, count) -> System.out.printf("Năm %d: %d sách\n", year, count));
    }

    static void statByAuthor() {
        Map<String, Integer> map = new HashMap<>();
        for (Book b : bookList) {
            map.put(b.getAuthor(), map.getOrDefault(b.getAuthor(), 0) + 1);
        }
        map.forEach((author, count) -> System.out.printf("Tác giả %s: %d sách\n", author, count));
    }
}

package B9;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner sc = new Scanner(System.in);

        manager.addBook(new Book("B001", "Java Programming", "John Doe", 2019));
        manager.addBook(new Book("B002", "Python Basics", "Alice Smith", 2021));
        manager.addBook(new Book("B003", "Data Structures", "Bob Johnson", 2018));
        manager.addBook(new Book("B004", "Web Development", "Charlie Brown", 2020));
        manager.addBook(new Book("B002", "Duplicate Book", "Someone", 2023)); // Sách trùng ID sẽ không thêm

        System.out.print("Nhập năm để lọc các sách xuất bản sau năm đó: ");
        int year = Integer.parseInt(sc.nextLine());

        List<Book> filtered = manager.filterBooksAfterYear(year);
        manager.sortBooksByTitle(filtered);

        System.out.println("\nDanh sách sách sau khi lọc và sắp xếp:");
        manager.displayBooks(filtered);
    }
}

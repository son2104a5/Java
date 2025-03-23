package ra.business;

import ra.entity.Book;
import java.util.*;

public class BookBusiness {
    private static final List<Book> books = new ArrayList<>();

    public static List<Book> getBooks() {
        return books;
    }

    public static void addBooks(List<Book> newBooks) {
        books.addAll(newBooks);
    }

    public static Book findBookById(String id) {
        return books.stream().filter(b -> b.getBookId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    public static boolean removeBook(String id) {
        return books.removeIf(b -> b.getBookId().equalsIgnoreCase(id));
    }

    public static List<Book> searchByTitle(String title) {
        return books.stream().filter(b -> b.getBookTitle().toLowerCase().contains(title.toLowerCase())).toList();
    }

    public static List<Book> searchByCategory(String category) {
        return books.stream().filter(b -> b.getCategory().toLowerCase().contains(category.toLowerCase())).toList();
    }

    public static List<Book> searchByPriceRange(double from, double to) {
        return books.stream().filter(b -> b.getPrice() >= from && b.getPrice() <= to).toList();
    }

    public static void sortByTitle(boolean ascending) {
        books.sort((a, b) -> ascending ? a.getBookTitle().compareToIgnoreCase(b.getBookTitle())
                : b.getBookTitle().compareToIgnoreCase(a.getBookTitle()));
    }

    public static void sortByPrice(boolean ascending) {
        books.sort((a, b) -> ascending ? Double.compare(a.getPrice(), b.getPrice())
                : Double.compare(b.getPrice(), a.getPrice()));
    }
}

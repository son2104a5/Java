package B9;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> bookList;
    private final String fileName = "books.dat";

    public BookManager() {
        bookList = FileHandler.readBooksFromFile(fileName);
        if (bookList == null) {
            bookList = new ArrayList<>();
        }
    }

    public void addBook(Book book) {
        bookList.add(book);
        FileHandler.writeBooksToFile(fileName, bookList);
    }

    public void updateBook(Book book) {
        for (Book b : bookList) {
            if (b.getId() == book.getId()) {
                b.setName(book.getName());
                b.setAuthor(book.getAuthor());
                b.setPublisher(book.getPublisher());
                b.setPrice(book.getPrice());
                FileHandler.writeBooksToFile(fileName, bookList);
                return;
            }
        }
        System.out.println("Không tìm thấy sách có ID: " + book.getId());
    }

    public void deleteBook(int id) {
        bookList.removeIf(book -> book.getId() == id);
        FileHandler.writeBooksToFile(fileName, bookList);
    }

    public void displayAllBooks() {
        List<Book> books = FileHandler.readBooksFromFile(fileName);
        if (books != null && !books.isEmpty()) {
            System.out.println("\nDanh sách sách:");
            for (Book book : books) {
                System.out.println(book);
            }
        } else {
            System.out.println("\nKhông có sách nào trong danh sách.");
        }
    }
}

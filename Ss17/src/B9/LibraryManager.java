package B9;

import java.util.*;

public class LibraryManager {
    private Set<Book> bookSet = new HashSet<>();

    public boolean addBook(Book book) {
        return bookSet.add(book);
    }

    public List<Book> filterBooksAfterYear(int year) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : bookSet) {
            if (book.getYear() > year) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    public void sortBooksByTitle(List<Book> books) {
        Collections.sort(books, Comparator.comparing(Book::getTitle));
    }

    public void displayBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }
}

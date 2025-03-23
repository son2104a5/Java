package ra.entity;

import java.util.Scanner;
import ra.validate.Validator;

public class Book implements IApp {
    private String bookId;
    private String bookTitle;
    private String author;
    private String publisher;
    private int publicationYear;
    private String category;
    private double price;
    private int quantity;

    public Book() {}

    public Book(String bookId, String bookTitle, String author, String publisher,
                int publicationYear, String category, double price, int quantity) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getBookId() { return bookId; }
    public void setBookId(String bookId) { this.bookId = bookId; }

    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public int getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public void inputData(Scanner sc) {
        System.out.print("Nhập tiêu đề sách: ");
        this.bookTitle = Validator.inputString(sc, 1, 100);

        System.out.print("Nhập tác giả: ");
        this.author = Validator.inputString(sc, 1, 50);

        System.out.print("Nhập nhà xuất bản: ");
        this.publisher = Validator.inputString(sc, 1, 100);

        System.out.print("Nhập năm xuất bản: ");
        this.publicationYear = Validator.inputInt(sc);

        System.out.print("Nhập thể loại: ");
        this.category = Validator.inputString(sc, 1, 100);

        System.out.print("Nhập giá sách: ");
        this.price = Validator.inputDouble(sc, 0);

        System.out.print("Nhập số lượng: ");
        this.quantity = Validator.inputInt(sc, 1);
    }

    @Override
    public void displayData() {
        System.out.printf("Mã: %s | Tiêu đề: %s | Tác giả: %s | NXB: %s | Năm: %d | Thể loại: %s | Giá: %.2f | SL: %d\n",
                bookId, bookTitle, author, publisher, publicationYear, category, price, quantity);
    }
}
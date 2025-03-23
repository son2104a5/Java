package ra.entity;

import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    public Book() {}

    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.year = year;
        this.interest = exportPrice - importPrice;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getInterest() {
        return interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void inputData(Scanner sc, Book[] books, int index) {
        while (true) {
            System.out.print("Nhập mã sách: ");
            bookId = sc.nextLine();
            boolean isDuplicate = false;
            for (int i = 0; i < index; i++) {
                if (books[i].getBookId().equals(bookId)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) break;
            System.out.println("Mã sách bị trùng. Nhập lại!");
        }

        while (true) {
            System.out.print("Nhập tên sách (4 ký tự, bắt đầu bằng B): ");
            bookName = sc.nextLine();
            boolean validName = bookName.length() == 4 && bookName.startsWith("B");
            boolean isDuplicate = false;
            for (int i = 0; i < index; i++) {
                if (books[i].getBookName().equals(bookName)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (validName && !isDuplicate) break;
            System.out.println("Tên sách không hợp lệ hoặc bị trùng.");
        }

        do {
            System.out.print("Nhập giá nhập: ");
            importPrice = Float.parseFloat(sc.nextLine());
        } while (importPrice <= 0);

        do {
            System.out.print("Nhập giá xuất: ");
            exportPrice = Float.parseFloat(sc.nextLine());
        } while (exportPrice <= importPrice * 1.3);

        while (true) {
            System.out.print("Nhập tên tác giả (6-50 ký tự): ");
            author = sc.nextLine();
            if (author.length() >= 6 && author.length() <= 50) break;
            System.out.println("Tác giả không hợp lệ.");
        }

        do {
            System.out.print("Nhập năm xuất bản (>2000): ");
            year = Integer.parseInt(sc.nextLine());
        } while (year <= 2000);

        calcInterest();
    }

    public void displayData() {
        System.out.printf("Mã: %s | Tên: %s | Giá nhập: %.2f | Giá xuất: %.2f | Tác giả: %s | Năm XB: %d | Lợi nhuận: %.2f\n",
                bookId, bookName, importPrice, exportPrice, author, year, interest);
    }

    public void calcInterest() {
        this.interest = exportPrice - importPrice;
    }
}

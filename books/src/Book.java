import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private double importPrice;
    private double exportPrice;
    private String title;
    private String author;
    private float interest;
    private int year;

    public Book () {
    }

    public Book (int year, float interest, String author, String title, double exportPrice, double importPrice, String bookName, String bookId) {
        this.year = year;
        this.interest = interest;
        this.author = author;
        this.title = title;
        this.exportPrice = exportPrice;
        this.importPrice = importPrice;
        this.bookName = bookName;
        this.bookId = bookId;
    }

    public String getBookId () {
        return bookId;
    }

    public void setBookId (String bookId) {
        this.bookId = bookId;
    }

    public String getBookName () {
        return bookName;
    }

    public void setBookName (String bookName) {
        this.bookName = bookName;
    }

    public double getImportPrice () {
        return importPrice;
    }

    public void setImportPrice (double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice () {
        return exportPrice;
    }

    public void setExportPrice (double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getAuthor () {
        return author;
    }

    public void setAuthor (String author) {
        this.author = author;
    }

    public float getInterest () {
        return interest;
    }

    public void setInterest (float interest) {
        this.interest = interest;
    }

    public int getYear () {
        return year;
    }

    public void setYear (int year) {
        this.year = year;
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập ID sách: ");
        this.bookId = scanner.nextLine();
        System.out.print("Nhập tên sách: ");
        this.bookName = scanner.nextLine();
        System.out.print("Giá nhập về: ");
        this.importPrice = Double.parseDouble(scanner.nextLine());
        this.exportPrice = this.importPrice * 1.1;
        System.out.print("Tiêu đề sách: ");
        this.title = scanner.nextLine();
        System.out.print("Tên tác giả: ");
        this.author = scanner.nextLine();
        System.out.print("Nhập năm xuất bản: ");
        this.year = Integer.parseInt(scanner.nextLine());
    }

    public void displayData() {
        System.out.println("ID sách: " + this.bookId);
        System.out.println("Tên sách: " + this.bookName);
        System.out.println("Giá nhập về: " + this.importPrice);
        System.out.println("Giá bán: " + this.exportPrice);
        System.out.println("Tiêu đề: " + this.title);
        System.out.println("Tác giả: " + this.author);
        System.out.println("Doanh thu bán ra: " + this.interest);
        System.out.println("Năm xuất bản: " + this.year);
    }

    public void calInterest () {
        this.interest = (float) (this.exportPrice - this.importPrice);
    }
}

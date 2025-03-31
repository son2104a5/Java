package B9;

public class Main {
    public static void main(String[] args) {
        BookManager manager = new BookManager();

        manager.addBook(new Book(1, "Lập trình Java", "Nguyễn Văn A", "NXB Trẻ", 150.0));
        manager.addBook(new Book(2, "Cấu trúc dữ liệu", "Trần Văn B", "NXB Giáo dục", 120.5));
        manager.addBook(new Book(3, "Hệ điều hành", "Lê Văn C", "NXB Khoa học", 200.0));

        manager.displayAllBooks();

        manager.updateBook(new Book(2, "Cấu trúc dữ liệu nâng cao", "Trần Văn B", "NXB Giáo dục", 130.0));

        System.out.println("\nSau khi cập nhật:");
        manager.displayAllBooks();

        manager.deleteBook(1);

        System.out.println("\nSau khi xóa:");
        manager.displayAllBooks();
    }
}

import java.util.Scanner;

public class BookManagement {
    static Book[] books = new Book[100];
    static int countBook = 0;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.printf("****************************MENU*************************\n" +
                    "1. Danh sách sách\n" +
                    "2. Thêm mới sách\n" +
                    "3. Tính lợi nhuận của các sách\n" +
                    "4. Cập nhật sách\n" +
                    "5. Xóa sách\n" +
                    "6. Sắp xếp sách theo lợi nhuận tăng dần\n" +
                    "7. Tìm kiếm sách theo tác giả\n" +
                    "8. Tìm kiếm sách theo khoảng giá (tìm theo khoảng giá bán)\n" +
                    "9. Thống kê sách theo mỗi tác giả\n" +
                    "10. Thoát\n");
            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    displayBook();
                    break;
                case 2:
                    addBook(sc);
                    break;
                case 3:
                    calculateAllInterest();
                    break;
                case 4:
                    sc.nextLine();
                    updateBook(sc);
                    break;
                case 5:
                    sc.nextLine();
                    deleteBook(sc);
                    break;
                case 6:
                    sortBook();
                    break;
                case 7:
                    sc.nextLine();
                    findBookByAuthorName(sc);
                    break;
                case 8:
                    sc.nextLine();
                    findBookByAmountPrice(sc);
                    break;
                case 9:
                    statisticBookByAuthor();
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Chức năng không tồn tại, vui lòng nhập lại!");
            }
        } while (true);
    }

    public static void displayBook () {
        for (int i = 0; i < countBook; i++) {
            System.out.println("****************************");
            books[i].displayData();
            System.out.println("****************************");
        }
    }

    public static void addBook (Scanner sc) {
        System.out.print("Nhập số sách muốn thêm: ");
        int numberBookAdd = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numberBookAdd; i++) {
            books[countBook] = new Book();
            books[countBook].inputData(sc);
            countBook++;
        }
    }

    public static void calculateAllInterest () {
        for (int i = 0; i < countBook; i++) {
            books[i].calInterest();
        }
    }

    public static void calculateInterest (String id) {
        int index = findBookById(id);
        if (index == -1) {
            System.out.printf("Không tìm thấy cuốn sách có id %s\n", id);
        } else {
            books[index].calInterest();
        }
    }

    public static int findBookById (String studentId) {
        for (int i = 0; i < countBook; i++) {
            if (books[i].getBookId().equals(studentId)) {
                return i;
            }
        }
        return - 1;
    }

    public static void updateBook (Scanner sc) {
        System.out.println("Nhập vào id sách cần cập nhật:");
        String bookId = sc.nextLine();
        int indexUpdate = findBookById(bookId);
        if (indexUpdate == - 1) {
            System.err.printf("Không tìm thấy cuốn sách có id %d\n", bookId);
        } else {
            boolean isExit = true;
            do {
                System.out.println("1. Cập nhật tên sách");
                System.out.println("2. Cập nhật giá nhập vào");
                System.out.println("3. Cập nhật giá bán");
                System.out.println("4. Cập nhật tiêu đề sách");
                System.out.println("5. Cập nhật tên tác giả");
                System.out.println("6. Cập nhật doanh thu");
                System.out.println("7. Cập nhật năm xuất bản");
                System.out.println("8. Thoát");
                System.out.println("Chọn chức năng: ");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Nhập vào tên cuốn sách mới: ");
                        books[indexUpdate].setBookName(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Nhập vào giá nhập mới: ");
                        books[indexUpdate].setImportPrice(Double.parseDouble(sc.nextLine()));
                        break;
                    case 3:
                        System.out.print("Nhập vào giá bán mới: ");
                        books[indexUpdate].setExportPrice(Double.parseDouble(sc.nextLine()));
                        break;
                    case 4:
                        System.out.print("Nhập vào tên tiêu đề mới: ");
                        books[indexUpdate].setTitle(sc.nextLine());
                        break;
                    case 5:
                        System.out.print("Nhập vào tên tác giả: ");
                        books[indexUpdate].setAuthor(sc.nextLine());
                        break;
                    case 6:
                        calculateInterest(bookId);
                        System.out.println("Đã cập nhật doanh thu của sách.");
                        break;
                    case 7:
                        System.out.println("Nhập vào năm xuất bản mới: ");
                        books[indexUpdate].setYear(Integer.parseInt(sc.nextLine()));
                        break;
                    case 8:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Chức năng không tồn tại. Vui lòng chọn lại");
                }
            } while (isExit);
        }
    }

    public static void deleteBook (Scanner sc) {
        System.out.println("Nhập vào id sách cần xóa");
        String bookId = sc.nextLine();
        int indexDelete = findBookById(bookId);
        if (indexDelete == - 1) {
            System.err.println("Không tồn tại cuốn sách có mã " + bookId);
        } else {
            for (int i = indexDelete; i < countBook; i++) {
                books[i] = books[i + 1];
            }
            countBook--;
            System.out.printf("Xóa cuốn sách có id %s thành công\n", bookId);
        }
    }

    public static void sortBook () {
        for (int i = 0; i < countBook; i++) {
            for (int j = i + 1; j < countBook; j++) {
                if (books[i].getInterest() > books[j].getInterest()) {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
        System.out.println("Hoàn thành sắp xếp");
    }

    public static void findBookByAuthorName (Scanner sc) {
        System.out.printf("Nhập tên tác giả của cuốn sách cần tìm: ");
        String authorName = sc.nextLine();
        for (int i = 0; i < countBook; i++) {
            if (books[i].getAuthor().equals(authorName)) {
                books[i].displayData();
            }
        }
    }

    public static void findBookByAmountPrice (Scanner sc) {
        System.out.print("Nhập giá đầu vào: ");
        double startPrice = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập giá cuối: ");
        double endPrice = Double.parseDouble(sc.nextLine());
        boolean isFind = false;
        for (int i = 0; i < countBook; i++) {
            if (books[i].getExportPrice() >= startPrice && books[i].getExportPrice() <= endPrice) {
                System.out.println("****************************");
                books[i].displayData();
                System.out.println("****************************");
                isFind = true;
            }
        }
        if (!isFind) {
            System.out.println("Không có cuốn sách nào có giá trong khoảng bạn đưa ra.");
        }
    }

    public static void statisticBookByAuthor () {
        for (int i = 0; i < countBook; i++) {
            String currentAuthor = books[i].getAuthor();
            boolean counted = false;
            for (int j = 0; j < i; j++) {
                if (books[j].getAuthor().equals(currentAuthor)) {
                    counted = true;
                    break;
                }
            }
            if (!counted) {
                System.out.printf("Danh sách những cuốn sách của tác giả %s:\n", currentAuthor);
                for (int k = 0; k < countBook; k++) {
                    if (books[k].getAuthor().equals(currentAuthor)) {
                        books[k].displayData();
                    }
                }
            }
        }
    }
}

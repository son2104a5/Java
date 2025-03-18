import java.util.Scanner;

public class Category implements IApp {
    public static final int MIN_NAME_LENGTH = 6;
    public static final int MAX_NAME_LENGTH = 50;
    public static final int MAX_DES_LENGTH = 255;

    private static int idCounter = 1;

    private int catId;
    private String catName;
    private int priority;
    private String catDescription;
    private boolean catStatus;

    public Category() {
        this.catId = idCounter++;
    }

    public Category(String catName, int priority, String catDescription, boolean catStatus) {
        this.catId = idCounter++;
        this.catName = catName;
        this.priority = priority;
        this.catDescription = catDescription;
        this.catStatus = catStatus;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Tạo mới danh mục với mã catId = " + this.catId);

        // Nhập tên danh mục
        do {
            System.out.print("Nhập tên danh mục: ");
            this.catName = scanner.nextLine().trim();
            if (catName.length() < MIN_NAME_LENGTH) {
                System.out.println("Tên danh mục quá ngắn (tối thiểu " + MIN_NAME_LENGTH + " ký tự).");
            } else if (catName.length() > MAX_NAME_LENGTH) {
                System.out.println("Tên danh mục quá dài (tối đa " + MAX_NAME_LENGTH + " ký tự).");
            }
        } while (catName.length() < MIN_NAME_LENGTH || catName.length() > MAX_NAME_LENGTH);

        // Nhập thứ tự ưu tiên
        System.out.print("Nhập thứ tự ưu tiên: ");
        this.priority = Integer.parseInt(scanner.nextLine());

        // Nhập mô tả
        do {
            System.out.print("Nhập mô tả danh mục: ");
            this.catDescription = scanner.nextLine().trim();
            if (catDescription.length() > MAX_DES_LENGTH) {
                System.out.println("Mô tả quá dài (tối đa " + MAX_DES_LENGTH + " ký tự).");
            }
        } while (catDescription.length() > MAX_DES_LENGTH);

        // Nhập trạng thái
        System.out.print("Trạng thái hoạt động (true: Hoạt động | false: Không hoạt động): ");
        this.catStatus = Boolean.parseBoolean(scanner.nextLine().trim());
    }

    @Override
    public void displayData() {
        System.out.println("----------- THÔNG TIN DANH MỤC -----------");
        System.out.println("Mã danh mục (catId): " + catId);
        System.out.println("Tên danh mục       : " + catName);
        System.out.println("Thứ tự ưu tiên     : " + priority);
        System.out.println("Mô tả              : " + catDescription);
        System.out.println("Trạng thái         : " + (catStatus ? "Hoạt động" : "Không hoạt động"));
    }

    // Getter & Setter
    public int getCatId() {
        return catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    public boolean isCatStatus() {
        return catStatus;
    }

    public void setCatStatus(boolean catStatus) {
        this.catStatus = catStatus;
    }
}

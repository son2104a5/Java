import java.util.Scanner;

public class Category implements IApp{
    public static final int MIN_NAME_LENGTH = 6;
    public static final int MAX_NAME_LENGTH = 50;
    public static final int MAX_DES_LENGTH = 255;

    @Override
    public void inputData (Scanner scanner) {
        System.out.println("Danh mục được tạo với catId = " + idCounter);
        this.catId = idCounter;
        do {
            System.out.print("Nhập tên danh mục: ");
            this.catName = scanner.nextLine();
            if (catName.length() < MIN_NAME_LENGTH) {
                System.out.println("Tên danh mục quá ngắn.");
            } else if (catName.length() > MAX_NAME_LENGTH) {
                System.out.println("Tên danh mục quá dài");
            }
        } while (this.catName.length() < MIN_NAME_LENGTH || this.catName.length() > MAX_NAME_LENGTH);
        System.out.print("Nhập thứ tự ưu tiên: ");
        this.priority = Integer.parseInt(scanner.nextLine());
        do {
            System.out.print("Nhập mô tả: ");
            this.catDescription = scanner.nextLine();
            if (catDescription.length() > MAX_DES_LENGTH) {
                System.out.println("Vượt kí tự.");
            }
        } while (this.catDescription.length() > MAX_DES_LENGTH);
        System.out.print("Trạng thái (true or false) : ");
        this.catStatus = Boolean.parseBoolean(scanner.nextLine());
        idCounter++;
    }

    @Override
    public void displayData () {
        System.out.println("catId: " + catId);
        System.out.println("catName: " + catName);
        System.out.println("priority: " + priority);
        System.out.println("catDescription: " + catDescription);
        System.out.printf("catStatus: %s\n", catStatus ? "Hoạt động" : "Không hoạt động");
    }

    private static int idCounter = 1;
    private int catId;
    private String catName;
    private int priority;
    private String catDescription;
    private boolean catStatus;

    public Category () {
    }

    public Category (String catName, int priority, String catDescription, boolean catStatus) {
        this.catId = idCounter;
        this.catName = catName;
        this.priority = priority;
        this.catDescription = catDescription;
        this.catStatus = catStatus;
    }

    public int getCatId () {
        return catId;
    }

    public String getCatName () {
        return catName;
    }

    public void setCatName (String catName) {
        this.catName = catName;
    }

    public int getPriority () {
        return priority;
    }

    public void setPriority (int priority) {
        this.priority = priority;
    }

    public String getCatDescription () {
        return catDescription;
    }

    public void setCatDescription (String catDescription) {
        this.catDescription = catDescription;
    }

    public boolean isCatStatus () {
        return catStatus;
    }

    public void setCatStatus (boolean catStatus) {
        this.catStatus = catStatus;
    }
}

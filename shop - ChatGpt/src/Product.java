import java.util.Scanner;

public class Product implements IApp {
    private static final String[] existingIds = new String[100];
    private static final String[] existingNames = new String[100];
    private static int idCount = 0;
    private static int nameCount = 0;
    private static final float INTEREST = 1.2f;

    private String proId;
    private String proName;
    private float importPrice;
    private float exportPrice;
    private String proTitle;
    private String proDescription;
    private int proStock;
    private int proCategory;
    private int proStatus;

    @Override
    public void inputData(Scanner sc) {
        inputProductId(sc);
        inputProductName(sc);
        inputImportPrice(sc);
        inputExportPrice(sc);
        inputTitle(sc);
        inputDescription(sc);
        inputStock(sc);
        inputCategory(sc);
        inputStatus(sc);
    }

    private void inputProductId(Scanner sc) {
        while (true) {
            System.out.print("Nhập mã sản phẩm (5 ký tự bắt đầu bằng C/E/T): ");
            String id = sc.nextLine().trim();
            if (id.matches("^[CET][A-Za-z0-9]{4}$") && !isDuplicateId(id)) {
                this.proId = id;
                existingIds[idCount++] = id;
                break;
            } else {
                System.out.println("Mã sản phẩm không hợp lệ hoặc đã tồn tại.");
            }
        }
    }

    private void inputProductName(Scanner sc) {
        while (true) {
            System.out.print("Nhập tên sản phẩm (10-100 ký tự, không trùng): ");
            String name = sc.nextLine().trim();
            if (name.length() >= 10 && name.length() <= 100 && !isDuplicateName(name)) {
                this.proName = name;
                existingNames[nameCount++] = name;
                break;
            } else {
                System.out.println("Tên sản phẩm không hợp lệ hoặc đã tồn tại.");
            }
        }
    }

    private void inputImportPrice(Scanner sc) {
        while (true) {
            System.out.print("Nhập giá nhập (> 0): ");
            try {
                float price = Float.parseFloat(sc.nextLine());
                if (price > 0) {
                    this.importPrice = price;
                    break;
                } else {
                    System.out.println("Giá nhập phải > 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ.");
            }
        }
    }

    private void inputExportPrice(Scanner sc) {
        while (true) {
            System.out.print("Nhập giá xuất (>= giá nhập * INTEREST): ");
            try {
                float price = Float.parseFloat(sc.nextLine());
                if (price >= this.importPrice * INTEREST) {
                    this.exportPrice = price;
                    break;
                } else {
                    System.out.println("Giá xuất phải >= giá nhập * INTEREST.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ.");
            }
        }
    }

    private void inputTitle(Scanner sc) {
        while (true) {
            System.out.print("Nhập tiêu đề (tối đa 200 ký tự): ");
            String title = sc.nextLine().trim();
            if (title.length() <= 200) {
                this.proTitle = title;
                break;
            } else {
                System.out.println("Tiêu đề quá dài.");
            }
        }
    }

    private void inputDescription(Scanner sc) {
        System.out.print("Nhập mô tả sản phẩm: ");
        this.proDescription = sc.nextLine();
    }

    private void inputStock(Scanner sc) {
        while (true) {
            System.out.print("Nhập số lượng sản phẩm (>= 0): ");
            try {
                int stock = Integer.parseInt(sc.nextLine());
                if (stock >= 0) {
                    this.proStock = stock;
                    break;
                } else {
                    System.out.println("Số lượng phải >= 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            }
        }
    }

    private void inputCategory(Scanner sc) {
        System.out.print("Nhập mã danh mục: ");
        try {
            this.proCategory = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Mã danh mục không hợp lệ, mặc định là 0.");
            this.proCategory = 0;
        }
    }

    private void inputStatus(Scanner sc) {
        while (true) {
            System.out.print("Nhập trạng thái sản phẩm (0: Hoạt động, 1: Hết hàng, 2: Không hoạt động): ");
            try {
                int status = Integer.parseInt(sc.nextLine());
                if (status >= 0 && status <= 2) {
                    this.proStatus = status;
                    break;
                } else {
                    System.out.println("Trạng thái không hợp lệ.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên từ 0 đến 2.");
            }
        }
    }

    @Override
    public void displayData() {
        System.out.println("Mã SP: " + proId);
        System.out.println("Tên SP: " + proName);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Tiêu đề: " + proTitle);
        System.out.println("Mô tả: " + proDescription);
        System.out.println("Tồn kho: " + proStock);
        System.out.println("Mã danh mục: " + proCategory);
        System.out.println("Trạng thái: " + getStatusText());
    }

    private String getStatusText() {
        return switch (proStatus) {
            case 0 -> "Hoạt động";
            case 1 -> "Hết hàng";
            case 2 -> "Không hoạt động";
            default -> "Không xác định";
        };
    }

    private boolean isDuplicateId(String id) {
        for (int i = 0; i < idCount; i++) {
            if (existingIds[i].equalsIgnoreCase(id)) return true;
        }
        return false;
    }

    private boolean isDuplicateName(String name) {
        for (int i = 0; i < nameCount; i++) {
            if (existingNames[i].equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    public static int getIdCount () {
        return idCount;
    }

    public static void setIdCount (int idCount) {
        Product.idCount = idCount;
    }

    public static int getNameCount () {
        return nameCount;
    }

    public static void setNameCount (int nameCount) {
        Product.nameCount = nameCount;
    }

    public String getProId () {
        return proId;
    }

    public void setProId (String proId) {
        this.proId = proId;
    }

    public String getProName () {
        return proName;
    }

    public void setProName (String proName) {
        this.proName = proName;
    }

    public float getImportPrice () {
        return importPrice;
    }

    public void setImportPrice (float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice () {
        return exportPrice;
    }

    public void setExportPrice (float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getProTitle () {
        return proTitle;
    }

    public void setProTitle (String proTitle) {
        this.proTitle = proTitle;
    }

    public String getProDescription () {
        return proDescription;
    }

    public void setProDescription (String proDescription) {
        this.proDescription = proDescription;
    }

    public int getProStock () {
        return proStock;
    }

    public void setProStock (int proStock) {
        this.proStock = proStock;
    }

    public int getProCategory () {
        return proCategory;
    }

    public void setProCategory (int proCategory) {
        this.proCategory = proCategory;
    }

    public int getProStatus () {
        return proStatus;
    }

    public void setProStatus (int proStatus) {
        this.proStatus = proStatus;
    }

    public Product() {}

    public Product(String proId, String proName, float importPrice, float exportPrice,
                   String proTitle, String proDescription, int proStock,
                   int proCategory, int proStatus) {
        this.proId = proId;
        this.proName = proName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.proTitle = proTitle;
        this.proDescription = proDescription;
        this.proStock = proStock;
        this.proCategory = proCategory;
        this.proStatus = proStatus;
    }

    // Getters and setters...
    // (same as your code - omitted here for brevity)
}

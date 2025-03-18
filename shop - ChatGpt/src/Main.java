import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Category[] cats = new Category[100];
        Product[] pro = new Product[100];
        int catCount = 0;
        int proCount = 0;

        while (true) {
            shopMenu();
            int mainChoice = Integer.parseInt(sc.nextLine());

            switch (mainChoice) {
                case 1:
                    catCount = handleCategoryMenu(sc, cats, catCount);
                    break;
                case 2:
                    proCount = handleProductMenu(sc, pro, cats, proCount, catCount);
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ! Vui lòng nhập lại.");
            }
        }
    }

    private static int handleCategoryMenu (Scanner sc, Category[] cats, int catCount) {
        int choice;
        do {
            catMenu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    if (catCount == 0) {
                        System.out.println("Hiện chưa có danh mục nào.");
                    } else {
                        System.out.println("===== Danh sách các danh mục =====");
                        for (int i = 0; i < catCount; i++) {
                            System.out.println("------------------------");
                            cats[i].displayData();
                            System.out.println("------------------------");
                        }
                    }
                    break;
                case 2:
                    Category newCat = new Category();
                    newCat.inputData(sc);
                    cats[catCount++] = newCat;
                    System.out.println("Thêm danh mục thành công.");
                    break;
                case 3:
                    updateCatById(sc, cats, catCount);
                    break;
                case 4:
                    deleteCatById(sc, cats, catCount);
                    break;
                case 5:
                    findCatById(sc, cats, catCount);
                    break;
                case 6:
                    System.out.println("Đã trở về menu chính!");
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ! Vui lòng nhập lại.");
            }
        } while (choice != 6);
        return catCount;
    }

    private static int handleProductMenu (Scanner sc, Product[] pro, Category[] cats, int proCount, int catCount) {
        int choice;
        do {
            proMenu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    if (proCount == 0) {
                        System.out.println("Hiện chưa có sản phẩm nào.");
                    } else {
                        System.out.println("===== Danh sách các sản phẩm =====");
                        for (int i = 0; i < proCount; i++) {
                            System.out.println("------------------------");
                            pro[i].displayData();
                            System.out.println("------------------------");
                        }
                    }
                    break;
                case 2:
                    Product newPro = new Product();
                    newPro.inputData(sc);
                    pro[proCount++] = newPro;
                    System.out.println("Thêm sản phẩm thành công.");
                    break;
                case 3:
                    updateProductById(sc, pro, proCount);
                    break;
                case 4:
                    deleteProductById(sc, pro, proCount);
                    break;
                case 5:
                    findProductById(sc, pro, proCount);
                    break;
                case 6:
                    findProductByPriceAmount(sc, pro, proCount);
                    break;
                case 7:
                    sortProductByPrice(sc, pro, proCount);
                    break;
                case 8:
                    soldProduct(sc, pro, proCount);
                    break;
                case 9:
                    statisticStockProductByCatName(sc, pro, cats, proCount, catCount);
                    break;
                case 10:
                    System.out.println("Đã về menu chính!");
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ! Vui lòng nhập lại.");
            }
        } while (choice != 10);
        return proCount;
    }

    // Giả sử các hàm menu bên dưới đã tồn tại
    private static void shopMenu () {
        System.out.println("======= MENU CHÍNH =======");
        System.out.println("1. Quản lý danh mục");
        System.out.println("2. Quản lý sản phẩm");
        System.out.println("3. Thoát");
        System.out.print("Chọn: ");
    }

    private static void catMenu () {
        System.out.println("===== QUẢN LÝ DANH MỤC =====");
        System.out.println("1. Hiển thị danh mục");
        System.out.println("2. Thêm danh mục");
        System.out.println("3. Cập nhật danh mục");
        System.out.println("4. Xóa danh mục");
        System.out.println("5. Tìm danh mục theo mã");
        System.out.println("6. Quay lại");
        System.out.print("Chọn: ");
    }

    private static void proMenu () {
        System.out.println("===== QUẢN LÝ SẢN PHẨM =====");
        System.out.println("1. Hiển thị sản phẩm");
        System.out.println("2. Thêm sản phẩm");
        System.out.println("3. Cập nhật sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Tìm sản phẩm theo mã");
        System.out.println("6. Tìm sản phẩm theo giá");
        System.out.println("7. Sắp xếp sản phẩm theo giá");
        System.out.println("8. Bán sản phẩm");
        System.out.println("9. Thống kê tồn kho theo danh mục");
        System.out.println("10. Quay lại");
        System.out.print("Chọn: ");
    }

    public static void updateCatById(Scanner sc, Category[] cats, int catCount) {
        System.out.print("Nhập ID danh mục muốn sửa: ");
        int catIdUpdate = Integer.parseInt(sc.nextLine());
        boolean found = false;

        for (int i = 0; i < catCount; i++) {
            if (cats[i].getCatId() == catIdUpdate) {
                found = true;
                int choice;
                do {
                    System.out.println("----- MENU CẬP NHẬT DANH MỤC -----");
                    System.out.println("1. Cập nhật tên danh mục");
                    System.out.println("2. Cập nhật độ ưu tiên");
                    System.out.println("3. Cập nhật mô tả");
                    System.out.println("4. Cập nhật trạng thái");
                    System.out.println("5. Thoát cập nhật");
                    System.out.print("Nhập lựa chọn: ");
                    choice = Integer.parseInt(sc.nextLine());

                    switch (choice) {
                        case 1:
                            System.out.print("Tên mới: ");
                            cats[i].setCatName(sc.nextLine());
                            System.out.println("✔ Đã cập nhật tên.");
                            break;
                        case 2:
                            System.out.print("Độ ưu tiên mới: ");
                            cats[i].setPriority(Integer.parseInt(sc.nextLine()));
                            System.out.println("✔ Đã cập nhật độ ưu tiên.");
                            break;
                        case 3:
                            System.out.print("Mô tả mới: ");
                            cats[i].setCatDescription(sc.nextLine());
                            System.out.println("✔ Đã cập nhật mô tả.");
                            break;
                        case 4:
                            System.out.print("Trạng thái mới (true/false): ");
                            cats[i].setCatStatus(Boolean.parseBoolean(sc.nextLine()));
                            System.out.println("✔ Đã cập nhật trạng thái.");
                            break;
                        case 5:
                            System.out.println("⬅ Thoát cập nhật.");
                            break;
                        default:
                            System.out.println("❌ Lựa chọn không hợp lệ!");
                            break;
                    }
                } while (choice != 5);
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Không tìm thấy danh mục với ID: " + catIdUpdate);
        }
    }

    public static int deleteCatById(Scanner sc, Category[] cats, int catCount) {
        System.out.print("Nhập ID danh mục muốn xóa: ");
        int catIdDelete = Integer.parseInt(sc.nextLine());
        boolean found = false;

        for (int i = 0; i < catCount; i++) {
            if (cats[i].getCatId() == catIdDelete) {
                found = true;
                for (int j = i; j < catCount - 1; j++) {
                    cats[j] = cats[j + 1];
                }
                cats[catCount - 1] = null;
                catCount--;
                System.out.println("✔ Đã xóa danh mục có ID: " + catIdDelete);
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Không tìm thấy danh mục với ID: " + catIdDelete);
        }

        return catCount;
    }

    public static void findProductByKeyword(Scanner sc, Product[] pro, int proCount) {
        if (proCount == 0) {
            System.out.println("Hiện chưa có sản phẩm nào để tìm kiếm.");
            return;
        }

        System.out.print("Nhập từ khóa tìm kiếm (tên hoặc tiêu đề): ");
        String keyword = sc.nextLine().toLowerCase();
        boolean found = false;

        System.out.println("===== KẾT QUẢ TÌM KIẾM =====");
        for (int i = 0; i < proCount; i++) {
            String name = pro[i].getProName().toLowerCase();
            String title = pro[i].getProTitle().toLowerCase();

            if (name.contains(keyword) || title.contains(keyword)) {
                System.out.println("------------------------");
                pro[i].displayData();
                System.out.println("------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ Không tìm thấy sản phẩm nào phù hợp với từ khóa \"" + keyword + "\".");
        }
    }

    public static void findProductByPriceAmount(Scanner sc, Product[] pro, int proCount) {
        if (proCount == 0) {
            System.out.println("Hiện chưa có sản phẩm nào để tìm kiếm.");
            return;
        }

        float minPrice, maxPrice;

        try {
            System.out.print("Nhập giá bán tối thiểu: ");
            minPrice = Float.parseFloat(sc.nextLine());
            System.out.print("Nhập giá bán tối đa: ");
            maxPrice = Float.parseFloat(sc.nextLine());

            if (minPrice > maxPrice) {
                System.out.println("❌ Giá tối thiểu không được lớn hơn giá tối đa.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Vui lòng nhập đúng định dạng số cho giá bán.");
            return;
        }

        boolean found = false;
        System.out.println("===== KẾT QUẢ TÌM KIẾM THEO KHOẢNG GIÁ =====");
        for (int i = 0; i < proCount; i++) {
            float price = pro[i].getExportPrice();
            if (price >= minPrice && price <= maxPrice) {
                System.out.println("------------------------");
                pro[i].displayData();
                System.out.println("------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.printf("❌ Không tìm thấy sản phẩm nào trong khoảng giá từ %.2f đến %.2f\n", minPrice, maxPrice);
        }
    }

    public static void sortProductByPrice(Product[] pro, int proCount) {
        if (proCount == 0) {
            System.out.println("Hiện chưa có sản phẩm nào để sắp xếp.");
            return;
        }

        for (int i = 0; i < proCount - 1; i++) {
            for (int j = 0; j < proCount - i - 1; j++) {
                if (pro[j].getExportPrice() > pro[j + 1].getExportPrice()) {
                    Product temp = pro[j];
                    pro[j] = pro[j + 1];
                    pro[j + 1] = temp;
                }
            }
        }

        System.out.println("===== DANH SÁCH SẢN PHẨM SAU KHI SẮP XẾP THEO GIÁ BÁN TĂNG DẦN =====");
        for (int i = 0; i < proCount; i++) {
            System.out.println("------------------------");
            pro[i].displayData();
            System.out.println("------------------------");
        }
    }

    public static void soldProduct(Scanner sc, Product[] pro, int proCount) {
        if (proCount == 0) {
            System.out.println("Hiện chưa có sản phẩm nào để bán.");
            return;
        }

        System.out.print("Nhập mã sản phẩm cần bán: ");
        String proIdSell = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < proCount; i++) {
            if (pro[i].getProId().equalsIgnoreCase(proIdSell)) {
                found = true;
                System.out.println("Thông tin sản phẩm:");
                pro[i].displayData();

                if (pro[i].getProStatus() == 1) {
                    System.out.println("❌ Sản phẩm đã hết hàng, không thể bán.");
                    return;
                }

                System.out.print("Nhập số lượng cần bán: ");
                int quantitySell;
                try {
                    quantitySell = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("❌ Số lượng phải là số nguyên hợp lệ.");
                    return;
                }

                if (quantitySell <= 0) {
                    System.out.println("❌ Số lượng bán phải lớn hơn 0.");
                } else if (quantitySell > pro[i].getProStock()) {
                    System.out.println("❌ Số lượng trong kho không đủ để bán.");
                } else {
                    int newStock = pro[i].getProStock() - quantitySell;
                    pro[i].setProStock(newStock);

                    if (newStock == 0) {
                        pro[i].setProStatus(1); // Hết hàng
                        System.out.println("⚠ Sản phẩm đã bán hết. Trạng thái cập nhật thành 'Hết hàng'.");
                    }

                    float totalPrice = quantitySell * pro[i].getExportPrice();
                    System.out.println("✅ Bán thành công! Tổng tiền thu được: " + totalPrice);
                    System.out.println("📦 Số lượng còn lại trong kho: " + newStock);
                }
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Không tìm thấy sản phẩm có mã: " + proIdSell);
        }
    }

    public static void statisticStockProductByCatName(Product[] pro, Category[] cats, int proCount, int catCount) {
        if (proCount == 0 || catCount == 0) {
            System.out.println("Chưa có đủ dữ liệu sản phẩm hoặc danh mục để thống kê.");
            return;
        }

        System.out.println("===== THỐNG KÊ SỐ LƯỢNG SẢN PHẨM THEO DANH MỤC =====");
        for (int i = 0; i < catCount; i++) {
            int count = 0;
            for (int j = 0; j < proCount; j++) {
                if (pro[j].getProCategory() == cats[i].getCatId()) {
                    count++;
                }
            }
            System.out.printf("Danh mục: %-20s | Số lượng sản phẩm: %d\n", cats[i].getCatName(), count);
        }
    }

}

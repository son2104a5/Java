import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Category[] cats = new Category[100];
        Product[] pro = new Product[100];
        int catCount = 0;
        int proCount = 0;

        int mainChoice, catChoice, proChoice;
        do {
            shopMenu();
            mainChoice = Integer.parseInt(sc.nextLine());
            switch (mainChoice) {
                case 1:
                    do {
                        catMenu();
                        catChoice = Integer.parseInt(sc.nextLine());
                        switch (catChoice) {
                            case 1:
                                if (catCount == 0) {
                                    System.out.println("Hiện chưa có danh mục nào.");
                                } else {
                                    System.out.println("===== Danh sách các danh nục hiện có =====");
                                    for (int i = 0; i < catCount; i++) {
                                        System.out.println("------------------------");
                                        cats[i].displayData();
                                        System.out.println("------------------------");
                                    }
                                }
                                break;
                            case 2:
                                cats[catCount++].inputData(sc);
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
                                break;
                        }
                    } while (catChoice != 6);
                    break;
                case 2:
                    do {
                        proMenu();
                        proChoice = Integer.parseInt(sc.nextLine());
                        switch (proChoice) {
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
                                pro[proCount++].inputData(sc);
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
                                break;
                        }
                    } while (proChoice != 10);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Chức năng không hợp lệ! Vui lòng nhập lại.");
                    break;
            }
        } while (true);
    }

    public static void shopMenu () {
        System.out.println("*********************SHOP MENU*********************\n" +
                "1. Quản lý danh mục\n" +
                "2. Quản lý sản phẩm\n" +
                "3. Thoát\n");
        System.out.print("Chọn chức năng: ");
    }

    public static void catMenu () {
        System.out.println("********************CATEGORIE MANAGEMENT*********************\n" +
                "1. Danh sách danh mục\n" +
                "2. Thêm mới danh mục\n" +
                "3. Cập nhật danh mục\n" +
                "4. Xóa danh mục\n" +
                "5. Tìm kiếm danh mục theo tên\n" +
                "6. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    public static void proMenu () {
        System.out.println("************************PRODUCT MANAGEMENT*******************\n" +
                "1. Danh sách sản phẩm\n" +
                "2. Thêm mới sản phẩm\n" +
                "3. Cập nhật sản phẩm\n" +
                "4. Xóa sản phẩm\n" +
                "5. Tìm kiếm sản phẩm theo tên hoặc tiêu đề\n" +
                "6. Tìm kiếm sản phẩm theo khoảng giá bán\n" +
                "7. Sắp xếp sản phẩm theo giá bán tăng dần\n" +
                "8. Bán sản phẩm\n" +
                "9. Thống kê số lượng sản phẩm theo danh mục\n" +
                "10. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    public static void updateCatById (Scanner sc, Category[] cats, int catCount) {
        System.out.println("Nhập id danh mục muốn sửa: ");
        int catIdUpdate = Integer.parseInt(sc.nextLine());
        boolean found = false;
        for (int i = 0; i < catCount; i++) {
            if (cats[i].getCatId() == catIdUpdate) {
                found = true;
                int choice;
                do {
                    System.out.println("----- MENU CẬP NHẬT -----");
                    System.out.println("1. Cập nhật Tên danh mục");
                    System.out.println("2. Cập nhật Độ ưu tiên");
                    System.out.println("3. Cập nhật Mô tả");
                    System.out.println("4. Cập nhật Trạng thái");
                    System.out.println("5. Thoát cập nhật");
                    System.out.print("Nhập lựa chọn của bạn: ");
                    choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.print("Nhập Tên mới: ");
                            String name = sc.nextLine();
                            cats[i].setCatName(name);
                            System.out.println("Đã cập nhật tên.");
                            break;
                        case 2:
                            System.out.print("Nhập độ ưu tiên mới: ");
                            int priority = Integer.parseInt(sc.nextLine());
                            cats[i].setPriority(priority);
                            System.out.println("Đã cập nhật độ ưu tiên.");
                            break;
                        case 3:
                            System.out.print("Nhập mô tả mới: ");
                            String desc = sc.nextLine();
                            cats[i].setCatDescription(desc);
                            System.out.println("Đã cập nhật mô tả.");
                            break;
                        case 4:
                            System.out.print("Nhập trạng thái mới (true/false): ");
                            boolean status = Boolean.parseBoolean(sc.nextLine());
                            cats[i].setCatStatus(status);
                            System.out.println("Đã cập nhật trạng thái.");
                            break;
                        case 5:
                            System.out.println("Thoát cập nhật...");
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ!");
                    }
                } while (choice != 5);
                break;
            }
        }

        if (! found) {
            System.out.println("Không tìm thấy danh mục với ID: " + catIdUpdate);
        }
    }

    public static void deleteCatById (Scanner sc, Category[] cats, int catCount) {
        System.out.print("Nhập id danh mục muốn xóa: ");
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
                System.out.println("Đã xóa danh mục có ID: " + catIdDelete);
                break;
            }
        }

        if (! found) {
            System.out.println("Không tìm thấy danh mục với ID: " + catIdDelete);
        }
    }

    public static void findCatById (Scanner sc, Category[] cats, int catCount) {
        System.out.print("Nhập tên danh mục cần tìm: ");
        String searchName = sc.nextLine().toLowerCase();
        boolean found = false;

        System.out.println("=== KẾT QUẢ TÌM KIẾM ===");
        for (int i = 0; i < catCount; i++) {
            if (cats[i].getCatName().toLowerCase().contains(searchName)) {
                cats[i].displayData();
                found = true;
            }
        }

        if (! found) {
            System.out.println("Không tìm thấy danh mục nào với tên chứa: " + searchName);
        }
    }

    public static void updateProductById (Scanner sc, Product[] pro, int proCount) {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        String updateId = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < proCount; i++) {
            if (pro[i].getProId().equalsIgnoreCase(updateId)) {
                found = true;
                int updateChoice;
                do {
                    System.out.println("\n--- MENU CẬP NHẬT SẢN PHẨM ---");
                    System.out.println("1. Tên sản phẩm");
                    System.out.println("2. Giá nhập");
                    System.out.println("3. Giá xuất");
                    System.out.println("4. Tiêu đề");
                    System.out.println("5. Mô tả");
                    System.out.println("6. Số lượng tồn kho");
                    System.out.println("7. Mã danh mục");
                    System.out.println("8. Trạng thái");
                    System.out.println("9. Thoát cập nhật");
                    System.out.print("Chọn mục cần cập nhật: ");
                    updateChoice = Integer.parseInt(sc.nextLine());

                    switch (updateChoice) {
                        case 1:
                            System.out.print("Nhập tên mới: ");
                            pro[i].setProName(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhập giá nhập mới: ");
                            pro[i].setImportPrice(Float.parseFloat(sc.nextLine()));
                            break;
                        case 3:
                            System.out.print("Nhập giá xuất mới: ");
                            pro[i].setExportPrice(Float.parseFloat(sc.nextLine()));
                            break;
                        case 4:
                            System.out.print("Nhập tiêu đề mới: ");
                            pro[i].setProTitle(sc.nextLine());
                            break;
                        case 5:
                            System.out.print("Nhập mô tả mới: ");
                            pro[i].setProDescription(sc.nextLine());
                            break;
                        case 6:
                            System.out.print("Nhập số lượng tồn kho mới: ");
                            pro[i].setProStock(Integer.parseInt(sc.nextLine()));
                            break;
                        case 7:
                            System.out.print("Nhập mã danh mục mới: ");
                            pro[i].setProCategory(Integer.parseInt(sc.nextLine()));
                            break;
                        case 8:
                            int newStatus;
                            do {
                                System.out.println("Chọn trạng thái mới:");
                                System.out.println("0. Hoạt động");
                                System.out.println("1. Hết hàng");
                                System.out.println("2. Không hoạt động");
                                System.out.print("Nhập lựa chọn: ");
                                newStatus = Integer.parseInt(sc.nextLine());

                                switch (newStatus) {
                                    case 0:
                                        pro[i].setProStatus(0);
                                        System.out.println("Đã cập nhật trạng thái: Hoạt động");
                                        break;
                                    case 1:
                                        pro[i].setProStatus(1);
                                        System.out.println("Đã cập nhật trạng thái: Hết hàng");
                                        break;
                                    case 2:
                                        pro[i].setProStatus(2);
                                        System.out.println("Đã cập nhật trạng thái: Không hoạt động");
                                        break;
                                    default:
                                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                                }
                            } while (newStatus < 0 || newStatus > 2);
                            break;
                        case 9:
                            System.out.println("Thoát cập nhật...");
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
                    }
                } while (updateChoice != 9);
                break;
            }
        }

        if (! found) {
            System.out.println("Không tìm thấy sản phẩm với mã: " + updateId);
        }
    }

    public static void deleteProductById (Scanner sc, Product[] pro, int proCount) {
        if (proCount == 0) {
            System.out.println("Hiện chưa có sản phẩm nào để xóa.");
        } else {
            System.out.print("Nhập mã sản phẩm cần xóa: ");
            String deleteId = sc.nextLine();
            boolean found = false;

            for (int i = 0; i < proCount; i++) {
                if (pro[i].getProId().equalsIgnoreCase(deleteId)) {
                    found = true;

                    for (int j = i; j < proCount - 1; j++) {
                        pro[j] = pro[j + 1];
                    }

                    pro[proCount - 1] = null;
                    proCount--;
                    System.out.println("Sản phẩm có mã \"" + deleteId + "\" đã được xóa thành công.");
                    break;
                }
            }

            if (! found) {
                System.out.println("Không tìm thấy sản phẩm có mã: " + deleteId);
            }
        }
    }

    public static void findProductById (Scanner sc, Product[] pro, int proCount) {
        if (proCount == 0) {
            System.out.println("Hiện chưa có sản phẩm nào để tìm kiếm.");
        } else {
            System.out.print("Nhập từ khóa tìm kiếm (tên hoặc tiêu đề): ");
            String keyword = sc.nextLine().toLowerCase();
            boolean found = false;

            System.out.println("===== KẾT QUẢ TÌM KIẾM =====");
            for (int i = 0; i < proCount; i++) {
                if (pro[i].getProName().toLowerCase().contains(keyword) ||
                        pro[i].getProTitle().toLowerCase().contains(keyword)) {
                    System.out.println("------------------------");
                    pro[i].displayData();
                    System.out.println("------------------------");
                    found = true;
                }
            }

            if (! found) {
                System.out.println("Không tìm thấy sản phẩm nào phù hợp với từ khóa \"" + keyword + "\".");
            }
        }
    }

    public static void findProductByPriceAmount (Scanner sc, Product[] pro, int proCount) {
        if (proCount == 0) {
            System.out.println("Hiện chưa có sản phẩm nào để tìm kiếm.");
        } else {
            System.out.print("Nhập giá bán tối thiểu: ");
            String minStr = sc.nextLine();
            System.out.print("Nhập giá bán tối đa: ");
            String maxStr = sc.nextLine();

            boolean isValid = true;
            for (int i = 0; i < minStr.length(); i++) {
                if (! Character.isDigit(minStr.charAt(i)) && minStr.charAt(i) != '.') {
                    isValid = false;
                    break;
                }
            }
            for (int i = 0; i < maxStr.length(); i++) {
                if (! Character.isDigit(maxStr.charAt(i)) && maxStr.charAt(i) != '.') {
                    isValid = false;
                    break;
                }
            }

            if (! isValid) {
                System.out.println("Giá bán phải là số hợp lệ. Vui lòng nhập lại.");
                return;
            }

            float minPrice = Float.parseFloat(minStr);
            float maxPrice = Float.parseFloat(maxStr);

            if (minPrice > maxPrice) {
                System.out.println("Giá tối thiểu không được lớn hơn giá tối đa.");
                return;
            }

            boolean found = false;
            System.out.println("===== KẾT QUẢ TÌM KIẾM THEO KHOẢNG GIÁ =====");
            for (int i = 0; i < proCount; i++) {
                if (pro[i].getExportPrice() >= minPrice && pro[i].getExportPrice() <= maxPrice) {
                    System.out.println("------------------------");
                    pro[i].displayData();
                    System.out.println("------------------------");
                    found = true;
                }
            }

            if (! found) {
                System.out.println("Không tìm thấy sản phẩm nào trong khoảng giá từ " + minPrice + " đến " + maxPrice);
            }
        }
    }

    public static void sortProductByPrice (Scanner sc, Product[] pro, int proCount) {
        if (proCount == 0) {
            System.out.println("Hiện chưa có sản phẩm nào để sắp xếp.");
        } else {
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
    }

    public static void soldProduct (Scanner sc, Product[] pro, int proCount) {
        if (proCount == 0) {
            System.out.println("Hiện chưa có sản phẩm nào để bán.");
        } else {
            System.out.print("Nhập mã sản phẩm cần bán: ");
            String proIdSell = sc.nextLine();
            boolean foundSell = false;

            for (int i = 0; i < proCount; i++) {
                if (pro[i].getProId().equalsIgnoreCase(proIdSell)) {
                    foundSell = true;

                    System.out.println("Thông tin sản phẩm:");
                    pro[i].displayData();

                    if (pro[i].getProStatus() == 1) {
                        System.out.println("Sản phẩm hiện đã hết hàng, không thể bán.");
                        break;
                    }

                    System.out.print("Nhập số lượng cần bán: ");
                    int quantitySell = Integer.parseInt(sc.nextLine());

                    if (quantitySell <= 0) {
                        System.out.println("Số lượng bán phải lớn hơn 0.");
                    } else if (quantitySell > pro[i].getProStock()) {
                        System.out.println("Số lượng trong kho không đủ để bán.");
                    } else {
                        int newStock = pro[i].getProStock() - quantitySell;
                        pro[i].setProStock(newStock);

                        if (newStock == 0) {
                            pro[i].setProStatus(1); // cập nhật trạng thái: Hết hàng
                            System.out.println("Sản phẩm đã được bán hết. Trạng thái cập nhật thành 'Hết hàng'.");
                        }

                        float totalPrice = quantitySell * pro[i].getExportPrice();
                        System.out.println("Bán thành công! Tổng tiền thu được: " + totalPrice);
                        System.out.println("Số lượng còn lại trong kho: " + newStock);
                    }

                    break;
                }
            }

            if (!foundSell) {
                System.out.println("Không tìm thấy sản phẩm có mã: " + proIdSell);
            }
        }
    }

    public static void statisticStockProductByCatName (Scanner sc, Product[] pro, Category[] cats, int proCount, int catCount) {
        if (proCount == 0 || catCount == 0) {
            System.out.println("Chưa có đủ dữ liệu sản phẩm hoặc danh mục để thống kê.");
        } else {
            System.out.println("===== Thống kê số lượng sản phẩm theo danh mục =====");
            for (int i = 0; i < catCount; i++) {
                int count = 0;
                for (int j = 0; j < proCount; j++) {
                    if (pro[j].getProCategory() == cats[i].getCatId()) {
                        count++;
                    }
                }
                System.out.println("Danh mục: " + cats[i].getCatName() + " | Số lượng sản phẩm: " + count);
            }
        }

    }
}

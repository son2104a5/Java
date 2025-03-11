import java.util.Scanner;

public class B10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startIndex, endIndex;
        System.out.print("Nhập chuỗi: ");
        StringBuilder str = new StringBuilder(sc.nextLine());
        do {
            System.out.println("=========== MENU QUẢN LÍ CHUỖI ===========");
            System.out.println("1. Đảo ngược chuỗi");
            System.out.println("2. Chèn chuỗi vào vị trí bất kì");
            System.out.println("3. Xóa 1 đoạn trong chuỗi");
            System.out.println("4. Thay thế 1 đoạn trong chuỗi");
            System.out.println("5. Chuyển đổi toàn bộ thành chữ hoa/ thường");
            System.out.print("Chọn chức năng 1-6: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    str.reverse();
                    System.out.println("Chuỗi đã đảo ngược: " + str.toString());
                    break;
                case 2:
                    System.out.print("Chọn vị trí cần chèn: ");
                    int insertIndex = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Chuỗi muốn chèn: ");
                    String insertStr = sc.nextLine();
                    str.insert(insertIndex, insertStr);
                    System.out.println("Chuỗi sau khi chèn: " + str.toString());
                    break;
                case 3:
                    System.out.print("Chọn vị trí bắt đầu: ");
                    startIndex = sc.nextInt();
                    System.out.print("Chọn vị trí kết thúc: ");
                    endIndex = sc.nextInt();
                    str.delete(startIndex, endIndex);
                    System.out.println("Chuỗi sau khi xóa: " + str.toString());
                    break;
                case 4:
                    System.out.print("Chọn vị trí bắt đầu: ");
                    startIndex = sc.nextInt();
                    System.out.print("Chọn vị trí kết thúc: ");
                    endIndex = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Chuỗi muốn thay thế: ");
                    String replaceStr = sc.nextLine();
                    str.replace(startIndex, endIndex, replaceStr);
                    System.out.println("Chuỗi sau khi thay đổi: " + str.toString());
                    break;
                case 5:
                    System.out.println("===== CHỌN FORM CHỮ MUỐN ĐỔI =====");
                    System.out.println("1. Chữ hoa");
                    System.out.println("2. Chữ thường");
                    int textForm = sc.nextInt();
                    switch (textForm) {
                        case 1:
                            String newUpperStr = str.toString().toUpperCase();
                            System.out.println(newUpperStr);
                            break;
                        case 2:
                            String newLowerStr = str.toString().toLowerCase();
                            System.out.println(newLowerStr);
                            break;
                        default:
                            System.out.println("Chức năng không tồn tại");
                            break;
                    }
                    break;
                default:
                    System.out.println("Vui lòng chọn lại.");

            }
        } while (true);
    }
}

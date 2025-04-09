import java.sql.*;
import java.time.LocalDate;

public class B5 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "snd21804@";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false);

            try {
                String insertOrderSQL = "INSERT INTO Orders (order_id, customer_name, order_date) VALUES (?, ?, ?)";
                try (PreparedStatement orderStmt = conn.prepareStatement(insertOrderSQL)) {
                    orderStmt.setInt(1, 1001);
                    orderStmt.setString(2, "Nguyen Van A");
                    orderStmt.setDate(3, Date.valueOf(LocalDate.now()));
                    orderStmt.executeUpdate();
                }
                String insertDetailSQL = "INSERT INTO OrderDetails (detail_id, order_id, product_name, quantity) VALUES (?, ?, ?, ?)";
                try (PreparedStatement detailStmt = conn.prepareStatement(insertDetailSQL)) {
                    detailStmt.setInt(1, 2001);
                    detailStmt.setInt(2, 1001);
                    detailStmt.setString(3, "Bút bi");
                    detailStmt.setInt(4, 10);
                    detailStmt.executeUpdate();

                    detailStmt.setInt(1, 2002);
                    detailStmt.setInt(2, 1001);
                    detailStmt.setString(3, "Vở tập viết");
                    detailStmt.setInt(4, -5);
                    detailStmt.executeUpdate();
                }

                conn.commit();
                System.out.println("Thêm đơn hàng và chi tiết thành công.");

            } catch (SQLException ex) {
                System.out.println("Lỗi trong quá trình thêm chi tiết đơn hàng: " + ex.getMessage());
                conn.rollback();
                System.out.println("Đã rollback toàn bộ giao dịch.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

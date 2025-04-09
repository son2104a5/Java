import java.sql.*;

public class B2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "snd21804@";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false);

            try {
                String insert1 = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
                try (PreparedStatement stmt1 = conn.prepareStatement(insert1)) {
                    stmt1.setInt(1, 1);
                    stmt1.setString(2, "Le Van B");
                    stmt1.setString(3, "levanb@example.com");
                    stmt1.executeUpdate();
                }

                String insert2 = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
                try (PreparedStatement stmt2 = conn.prepareStatement(insert2)) {
                    stmt2.setInt(1, 1);
                    stmt2.setString(2, "Tran Van C");
                    stmt2.setString(3, "tranvanc@example.com");
                    stmt2.executeUpdate();
                }

                conn.commit();
                System.out.println("Đã commit thành công.");

            } catch (SQLException ex) {
                System.out.println("Lỗi xảy ra: " + ex.getMessage());
                System.out.println("Tiến hành rollback...");
                conn.rollback();
            }

            String query = "SELECT * FROM users WHERE id = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(query)) {
                checkStmt.setInt(1, 1);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("DỮ LIỆU VẪN CÒN (KHÔNG ROLLBACK ĐÚNG).");
                    } else {
                        System.out.println("ROLLBACK THÀNH CÔNG: Không có dữ liệu nào được thêm.");
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

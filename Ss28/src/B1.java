import java.sql.*;

public class B1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "snd21804@";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            boolean initialAutoCommit = conn.getAutoCommit();
            System.out.println("Auto-commit ban đầu: " + initialAutoCommit);

            conn.setAutoCommit(false);
            System.out.println("Auto-commit sau khi tắt: " + conn.getAutoCommit());

            String insertSQL = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                pstmt.setInt(1, 1);
                pstmt.setString(2, "Nguyen Van A");
                pstmt.setString(3, "nguyenvana@example.com");
                pstmt.executeUpdate();
            }

            conn.commit();
            System.out.println("Đã commit thay đổi.");

            String selectSQL = "SELECT * FROM users WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                pstmt.setInt(1, 1);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Dữ liệu đã được thêm:");
                        System.out.println("ID: " + rs.getInt("id"));
                        System.out.println("Name: " + rs.getString("name"));
                        System.out.println("Email: " + rs.getString("email"));
                    } else {
                        System.out.println("Không tìm thấy dữ liệu.");
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

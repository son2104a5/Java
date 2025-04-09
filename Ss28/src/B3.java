import java.sql.*;

public class B3 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "snd21804@";

        int fromAccountId = 1;
        int toAccountId = 2;
        double amount = 500.0;

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false);

            try {
                String checkBalanceSQL = "SELECT balance FROM accounts WHERE id = ?";
                double balance = 0;

                try (PreparedStatement checkStmt = conn.prepareStatement(checkBalanceSQL)) {
                    checkStmt.setInt(1, fromAccountId);
                    try (ResultSet rs = checkStmt.executeQuery()) {
                        if (rs.next()) {
                            balance = rs.getDouble("balance");
                        } else {
                            throw new SQLException("Không tìm thấy tài khoản nguồn");
                        }
                    }
                }

                if (balance < amount) {
                    throw new SQLException("Số dư không đủ để chuyển tiền");
                }
                String deductSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
                try (PreparedStatement deductStmt = conn.prepareStatement(deductSQL)) {
                    deductStmt.setDouble(1, amount);
                    deductStmt.setInt(2, fromAccountId);
                    deductStmt.executeUpdate();
                }
                String addSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
                try (PreparedStatement addStmt = conn.prepareStatement(addSQL)) {
                    addStmt.setDouble(1, amount);
                    addStmt.setInt(2, toAccountId);
                    addStmt.executeUpdate();
                }

                conn.commit();
                System.out.println("Chuyển tiền thành công. Đã commit thay đổi.");

            } catch (SQLException ex) {
                System.out.println("Lỗi xảy ra: " + ex.getMessage());
                conn.rollback();
                System.out.println("Rollback hoàn tất. Giao dịch không thành công.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

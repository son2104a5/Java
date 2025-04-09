import java.sql.*;

public class B4 {
    public static void main(String[] args) {
        String bankAUrl = "jdbc:mysql://localhost:3306/bank_a";
        String bankBUrl = "jdbc:mysql://localhost:3306/bank_b";
        String user = "root";
        String password = "snd21804@";

        int fromAccountId = 1;
        int toAccountId = 2;
        double amount = 1000.0;

        Connection connA = null;
        Connection connB = null;

        try {
            connA = DriverManager.getConnection(bankAUrl, user, password);
            connB = DriverManager.getConnection(bankBUrl, user, password);

            connA.setAutoCommit(false);
            connB.setAutoCommit(false);

            String deductSQL = "UPDATE bank_accounts SET balance = balance - ? WHERE account_id = ?";
            try (PreparedStatement stmtA = connA.prepareStatement(deductSQL)) {
                stmtA.setDouble(1, amount);
                stmtA.setInt(2, fromAccountId);
                int rowsAffected = stmtA.executeUpdate();
                if (rowsAffected == 0) throw new SQLException("Không tìm thấy tài khoản gửi ở ngân hàng A");
            }

            String addSQL = "UPDATE bank_accounts SET balance = balance + ? WHERE account_id = ?";
            try (PreparedStatement stmtB = connB.prepareStatement(addSQL)) {
                stmtB.setDouble(1, amount);
                stmtB.setInt(2, toAccountId);
                int rowsAffected = stmtB.executeUpdate();
                if (rowsAffected == 0) throw new SQLException("Không tìm thấy tài khoản nhận ở ngân hàng B");
            }

            connA.commit();
            connB.commit();
            System.out.println("Chuyển tiền liên ngân hàng thành công!");

        } catch (SQLException e) {
            System.out.println("Lỗi xảy ra: " + e.getMessage());
            try {
                if (connA != null) connA.rollback();
                if (connB != null) connB.rollback();
                System.out.println("Đã rollback cả hai ngân hàng.");
            } catch (SQLException ex) {
                System.out.println("Lỗi khi rollback: " + ex.getMessage());
            }
        } finally {
            try {
                if (connA != null) connA.close();
                if (connB != null) connB.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

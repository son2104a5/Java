import java.sql.*;

public class B7 {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "snd21804@";

        testIsolation(Connection.TRANSACTION_READ_UNCOMMITTED, "READ_UNCOMMITTED", url, user, password);
        testIsolation(Connection.TRANSACTION_READ_COMMITTED, "READ_COMMITTED", url, user, password);
        testIsolation(Connection.TRANSACTION_REPEATABLE_READ, "REPEATABLE_READ", url, user, password);
        testIsolation(Connection.TRANSACTION_SERIALIZABLE, "SERIALIZABLE", url, user, password);
    }

    public static void testIsolation(int isolationLevel, String levelName, String url, String user, String password) throws Exception {
        System.out.println("========== Isolation Level: " + levelName + " ==========");

        try (
                Connection conn1 = DriverManager.getConnection(url, user, password);
                Connection conn2 = DriverManager.getConnection(url, user, password)
        ) {
            conn1.setAutoCommit(false);
            conn2.setAutoCommit(false);

            conn1.setTransactionIsolation(isolationLevel);

            String insertSQL = "INSERT INTO orders (order_id, customer_name, status) VALUES (?, ?, ?)";
            try (PreparedStatement stmt2 = conn2.prepareStatement(insertSQL)) {
                stmt2.setInt(1, 1001);
                stmt2.setString(2, "Nguyen Van A");
                stmt2.setString(3, "Pending");
                stmt2.executeUpdate();
                System.out.println("[Connection2] Đã chèn dữ liệu (chưa commit).");
            }

            String selectSQL = "SELECT * FROM orders WHERE order_id = 1001";
            try (PreparedStatement stmt1 = conn1.prepareStatement(selectSQL)) {
                ResultSet rs = stmt1.executeQuery();
                System.out.print("[Connection1] Kết quả SELECT: ");
                if (rs.next()) {
                    System.out.println("Thấy order_id = 1001 → Dirty Read xảy ra");
                } else {
                    System.out.println("Không thấy dữ liệu → Không có Dirty Read");
                }
            }

            conn2.rollback();
            conn1.rollback();
        }

        System.out.println();
    }
}

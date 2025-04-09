import java.sql.*;

public class B9 {

    public static void main(String[] args) {
        placeBid(1, 1001, 1200);
        placeBid(2, 1001, 100);
        placeBid(3, 1001, 10000);
    }

    public static void placeBid(int userId, int auctionId, double bidAmount) {
        String url = "jdbc:mysql://localhost:3306/aution_db";
        String user = "root";
        String password = "snd21804@";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            if (!hasEnoughBalance(conn, userId, bidAmount)) {
                logFailedBid(conn, userId, auctionId, bidAmount, "Số dư không đủ");
                conn.rollback();
                return;
            }

            if (!isBidHigher(conn, auctionId, bidAmount)) {
                logFailedBid(conn, userId, auctionId, bidAmount, "Giá trị đấu giá phải cao hơn giá trị ban đầu");
                conn.rollback();
                return;
            }

            String updateAuction = "UPDATE auctions SET highest_bid = ? WHERE auction_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(updateAuction)) {
                stmt.setDouble(1, bidAmount);
                stmt.setInt(2, auctionId);
                stmt.executeUpdate();
            }

            String insertBid = "INSERT INTO bids (auction_id, user_id, bid_amount) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertBid)) {
                stmt.setInt(1, auctionId);
                stmt.setInt(2, userId);
                stmt.setDouble(3, bidAmount);
                stmt.executeUpdate();
            }

            conn.commit();
            System.out.println("Đấu giá thành công!");

        } catch (SQLException e) {
            System.err.println("Transaction lỗi: " + e.getMessage());
        }
    }

    private static boolean hasEnoughBalance(Connection conn, int userId, double bidAmount) throws SQLException {
        String sql = "SELECT balance FROM users WHERE user_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getDouble("balance") >= bidAmount;
        }
    }

    private static boolean isBidHigher(Connection conn, int auctionId, double bidAmount) throws SQLException {
        String sql = "SELECT highest_bid FROM auctions WHERE auction_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, auctionId);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && bidAmount > rs.getDouble("highest_bid");
        }
    }

    private static void logFailedBid(Connection conn, int userId, int auctionId, double bidAmount, String reason) throws SQLException {
        String sql = "INSERT INTO failed_bids (user_id, auction_id, bid_amount, reason) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, auctionId);
            stmt.setDouble(3, bidAmount);
            stmt.setString(4, reason);
            stmt.executeUpdate();
            System.err.println("Đấu giá thất bại: " + reason);
        }
    }
}

import java.sql.*;
import java.time.LocalDate;

public class B8 {

    public static void main(String[] args) {
        bookRoom(1, 101);
        bookRoom(99, 101);
        bookRoom(1, 101);
    }

    public static void bookRoom(int customerId, int roomId) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "snd21804@";

        try (
                Connection conn = DriverManager.getConnection(url, user, password)
        ) {
            conn.setAutoCommit(false);

            if (!customerExists(conn, customerId)) {
                logFailedBooking(conn, customerId, roomId, "Customer does not exist");
                conn.rollback();
                return;
            }

            if (!isRoomAvailable(conn, roomId)) {
                logFailedBooking(conn, customerId, roomId, "Room is not available");
                conn.rollback();
                return;
            }

            String updateRoom = "UPDATE rooms SET availability = FALSE WHERE room_id = ?";
            try (PreparedStatement stmt1 = conn.prepareStatement(updateRoom)) {
                stmt1.setInt(1, roomId);
                stmt1.executeUpdate();
            }

            String insertBooking = "INSERT INTO bookings (customer_id, room_id, booking_date, status) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt2 = conn.prepareStatement(insertBooking)) {
                stmt2.setInt(1, customerId);
                stmt2.setInt(2, roomId);
                stmt2.setDate(3, Date.valueOf(LocalDate.now()));
                stmt2.setString(4, "Confirmed");
                stmt2.executeUpdate();
            }

            conn.commit();
            System.out.println("Booking successful for customer_id=" + customerId + ", room_id=" + roomId);

        } catch (SQLException e) {
            System.err.println("Transaction failed: " + e.getMessage());
        }
    }

    private static boolean customerExists(Connection conn, int customerId) throws SQLException {
        String sql = "SELECT 1 FROM customers WHERE customer_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }

    private static boolean isRoomAvailable(Connection conn, int roomId) throws SQLException {
        String sql = "SELECT availability FROM rooms WHERE room_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, roomId);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getBoolean("availability");
        }
    }

    private static void logFailedBooking(Connection conn, int customerId, int roomId, String reason) throws SQLException {
        String sql = "INSERT INTO failed_bookings (customer_id, room_id, error_message) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            stmt.setInt(2, roomId);
            stmt.setString(3, reason);
            stmt.executeUpdate();
            System.err.println("Booking failed: " + reason);
        }
    }
}

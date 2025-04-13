package business.config;

import java.sql.*;

public class ConnectionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/EmployeeManagement";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "snd21804@";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Lỗi : " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi không xác định: " + e.getMessage());
        }
        return conn;
    }

    public static void close(Connection conn, CallableStatement cs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (cs != null) {
            try {
                cs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

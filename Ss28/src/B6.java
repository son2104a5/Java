import java.sql.*;

public class B6 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "snd21804@";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false);

            try {
                String insertDeptSQL = "INSERT INTO departments (id, name) VALUES (?, ?)";
                try (PreparedStatement deptStmt = conn.prepareStatement(insertDeptSQL)) {
                    deptStmt.setInt(1, 1);
                    deptStmt.setString(2, "Phòng Kỹ Thuật");
                    deptStmt.executeUpdate();
                }

                String insertEmpSQL = "INSERT INTO employees (id, name, department_id) VALUES (?, ?, ?)";
                try (PreparedStatement empStmt = conn.prepareStatement(insertEmpSQL)) {
                    empStmt.setInt(1, 1001);
                    empStmt.setString(2, "Nguyen Van A");
                    empStmt.setInt(3, 1);
                    empStmt.executeUpdate();

                    empStmt.setInt(1, 1002);
                    empStmt.setString(2, null);
                    empStmt.setInt(3, 1);
                    empStmt.executeUpdate();
                }

                conn.commit();
                System.out.println("Thêm phòng ban và nhân viên thành công.");

            } catch (SQLException ex) {
                System.out.println("Lỗi khi thêm nhân viên: " + ex.getMessage());
                conn.rollback();
                System.out.println("Đã rollback toàn bộ giao dịch.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

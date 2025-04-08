package JDBC.business.dao.student;

import JDBC.business.config.ConnectionDB;
import JDBC.business.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImp implements StudentDAO {
    @Override
    public int getCountStudentByStatus(boolean status) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = ConnectionDB.getConnection();
            cstmt = conn.prepareCall("{call get_count_by_status(?, ?)}");
            cstmt.setBoolean(1, status);
            cstmt.registerOutParameter(2, Types.INTEGER);
            cstmt.execute();
            return cstmt.getInt(2);
        } catch (SQLException e) {
            e.fillInStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.close(conn, cstmt);
        }
        return 0;
    }

    @Override
    public Student findById(int id) {
        Connection conn = null;
        CallableStatement cstmt = null;
        Student student = null;
        try {
            conn = ConnectionDB.getConnection();
            cstmt = conn.prepareCall("{call get_student_by_id(?)}");
            cstmt.setInt(1, id);
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("student_id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setStatus(rs.getBoolean("status"));
            } else {
                System.out.println("Không tìm thấy sinh viên trong CSDL.");
            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.close(conn, cstmt);
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        Connection conn = null;
        CallableStatement cstmt = null;
        List<Student> students = null;
        try {
            conn = ConnectionDB.getConnection();
            cstmt = conn.prepareCall("{call find_all_student()}");
            ResultSet rs = cstmt.executeQuery();
            students = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("student_id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setStatus(rs.getBoolean("status"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.close(conn, cstmt);
        }
        return students;
    }

    @Override
    public boolean save(Student student) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = ConnectionDB.getConnection();
            cstmt = conn.prepareCall("{call create_student(?,?,?)}");
            cstmt.setString(1, student.getName());
            cstmt.setInt(2, student.getAge());
            cstmt.setBoolean(3, student.getStatus());
            cstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.fillInStackTrace();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.close(conn, cstmt);
        }
        return false;
    }

    @Override
    public boolean update(Student student) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = ConnectionDB.getConnection();
            cstmt = conn.prepareCall("{call update_student(?,?,?,?)}");
            cstmt.setInt(1, student.getId());
            cstmt.setString(2, student.getName());
            cstmt.setInt(3, student.getAge());
            cstmt.setBoolean(4, student.getStatus());
            cstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.fillInStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.close(conn, cstmt);
        }
        return false;
    }

    @Override
    public boolean delete(Student student) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = ConnectionDB.getConnection();
            cstmt = conn.prepareCall("{call delete_student(?)}");
            cstmt.setInt(1, student.getId());
            cstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.fillInStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.close(conn, cstmt);
        }
        return false;
    }
}

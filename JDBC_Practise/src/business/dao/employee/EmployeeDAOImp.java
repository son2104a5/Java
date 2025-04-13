package business.dao.employee;

import business.config.ConnectionDB;
import business.model.Employee;
import datatype.EmployeeStatus;
import datatype.Gender;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImp implements EmployeeDAO {
    @Override
    public Employee getEmployeeById(String id) {
        return null;
    }

    @Override
    public List<Employee> findAllByPage(int page) {
        Connection conn = null;
        CallableStatement cs = null;
        List<Employee> employees = null;
        int itemPerPage = 10;
        try {
            conn = ConnectionDB.getConnection();
            cs = conn.prepareCall("{call display_employee_per_page(?)}");
            cs.setInt(1, itemPerPage * (page - 1));
            ResultSet rs = cs.executeQuery();
            employees = new ArrayList<Employee>();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmp_id(rs.getString("emp_id"));
                employee.setEmp_name(rs.getString("emp_name"));
                employee.setEmail(rs.getString("emp_email"));
                employee.setPhoneNumber(rs.getString("emp_phone"));
                employee.setGender(Gender.valueOf(rs.getString("gender")));
                employee.setSalaryLevel(rs.getInt("salary_level"));
                employee.setSalary(rs.getFloat("salary"));
                employee.setDateOfBirth(rs.getDate("emp_dob").toLocalDate());
                employee.setAddress(rs.getString("address"));
                employee.setStatus(EmployeeStatus.valueOf(rs.getString("emp_status")));
                employee.setDp_id(rs.getInt("department"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.close(conn, cs);
        }
        return employees;
    }

    @Override
    public boolean save(Employee employee) {
        return false;
    }

    @Override
    public boolean update(Employee employee) {
        return false;
    }

    @Override
    public boolean delete(Employee employee) {
        return false;
    }
}

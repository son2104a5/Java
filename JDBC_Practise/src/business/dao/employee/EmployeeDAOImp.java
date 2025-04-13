package business.dao.employee;

import business.config.ConnectionDB;
import business.model.Employee;
import datatype.EmployeeStatus;
import datatype.Gender;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImp implements EmployeeDAO {
    @Override
    public Employee getEmployeeById(String id) {
        Connection conn = null;
        CallableStatement cs = null;
        Employee employee = null;
        try {
            conn = ConnectionDB.getConnection();
            cs = conn.prepareCall("{call find_employee_by_id(?)}");
            cs.setString(1, id);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                employee = new Employee();
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
                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.close(conn, cs);
        }
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
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = ConnectionDB.getConnection();
            cs = conn.prepareCall("{call add_employee(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cs.setString(1, employee.getEmp_id());
            cs.setString(2, employee.getEmp_name());
            cs.setString(3, employee.getEmail());
            cs.setString(4, employee.getPhoneNumber());
            cs.setString(5, employee.getGender().name());
            cs.setInt(6, employee.getSalaryLevel());
            cs.setDouble(7, employee.getSalary());
            cs.setString(8, employee.getDateOfBirth().toString());
            cs.setString(9, employee.getAddress());
            cs.setString(10, employee.getStatus().name());
            cs.setInt(11, employee.getDp_id());
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.close(conn, cs);
        }
        return false;
    }

    @Override
    public boolean update(Employee employee) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = ConnectionDB.getConnection();

            if (employee.getEmp_name() != null) {
                cs = conn.prepareCall("{call update_employee_name(?, ?)}");
                cs.setString(1, employee.getEmp_id());
                cs.setString(2, employee.getEmp_name());
            } else if (employee.getEmail() != null) {
                cs = conn.prepareCall("{call update_employee_email(?, ?)}");
                cs.setString(1, employee.getEmp_id());
                cs.setString(2, employee.getEmail());
            } else if (employee.getPhoneNumber() != null) {
                cs = conn.prepareCall("{call update_employee_phone(?, ?)}");
                cs.setString(1, employee.getEmp_id());
                cs.setString(2, employee.getPhoneNumber());
            } else if (employee.getGender() != null) {
                cs = conn.prepareCall("{call update_employee_gender(?, ?)}");
                cs.setString(1, employee.getEmp_id());
                cs.setString(2, String.valueOf(employee.getGender()));
            } else if (employee.getSalaryLevel() != 0) {
                cs = conn.prepareCall("{call update_employee_salary_level(?, ?)}");
                cs.setString(1, employee.getEmp_id());
                cs.setInt(2, employee.getSalaryLevel());
            } else if (employee.getDateOfBirth() != null) {
                cs = conn.prepareCall("{call update_employee_dob(?, ?)}");
                cs.setString(1, employee.getEmp_id());
                cs.setDate(2, Date.valueOf(employee.getDateOfBirth()));
            } else if (employee.getAddress() != null) {
                cs = conn.prepareCall("{call update_employee_address(?, ?)}");
                cs.setString(1, employee.getEmp_id());
                cs.setString(2, employee.getAddress());
            } else if (employee.getStatus() != null) {
                cs = conn.prepareCall("{call update_employee_status(?, ?)}");
                cs.setString(1, employee.getEmp_id());
                cs.setString(2, String.valueOf(employee.getStatus()));
            } else if (employee.getDp_id() != 0) {
                cs = conn.prepareCall("{call update_employee_department(?, ?)}");
                cs.setString(1, employee.getEmp_id());
                cs.setInt(2, employee.getDp_id());
            } else {
                return false;
            }
            cs.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.close(conn, cs);
        }
        return false;
    }


    @Override
    public boolean delete(Employee employee) {
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = ConnectionDB.getConnection();
            cs = conn.prepareCall("{call delete_employee(?)}");
            cs.setString(1, employee.getEmp_id());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.close(conn, cs);
        }
        return false;
    }
}

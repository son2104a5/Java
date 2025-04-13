package business.dao.employee;

import business.dao.AppDAO;
import business.model.Employee;

public interface EmployeeDAO extends AppDAO<Employee> {
    Employee getEmployeeById(String id);
}

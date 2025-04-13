package business.dao.department;

import business.dao.AppDAO;
import business.model.Department;

public interface DepartmentDAO extends AppDAO<Department> {
    Department getDepartmentById(int id);

}

package business.dao.department;

import business.model.Department;

import java.util.List;

public class DepartmentDAOImp implements DepartmentDAO {
    @Override
    public Department getDepartmentById(int id) {
        return null;
    }

    @Override
    public List<Department> findAllByPage(int page) {
        return List.of();
    }

    @Override
    public boolean save(Department department) {
        return false;
    }

    @Override
    public boolean update(Department department) {
        return false;
    }

    @Override
    public boolean delete(Department department) {
        return false;
    }
}

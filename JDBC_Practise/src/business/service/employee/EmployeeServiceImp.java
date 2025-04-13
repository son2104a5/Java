package business.service.employee;

import business.dao.employee.EmployeeDAO;
import business.dao.employee.EmployeeDAOImp;

import java.util.List;

public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImp() {
        employeeDAO = new EmployeeDAOImp();
    }

    @Override
    public List findAllByPage(int page) {
        return employeeDAO.findAllByPage(page);
    }

    @Override
    public boolean save(Object o) {
        return false;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }
}

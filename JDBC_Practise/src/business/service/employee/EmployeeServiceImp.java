package business.service.employee;

import business.dao.employee.EmployeeDAO;
import business.dao.employee.EmployeeDAOImp;
import business.model.Employee;

import java.util.List;

public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImp() {
        employeeDAO = new EmployeeDAOImp();
    }

    @Override
    public List<Employee> findAllByPage(int page) {
        return employeeDAO.findAllByPage(page);
    }

    @Override
    public boolean save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public boolean update(Employee employee) {
        return employeeDAO.update(employee);
    }

    @Override
    public boolean delete(Employee employee) {
        return employeeDAO.delete(employee);
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeDAO.getEmployeeById(id);
    }
}

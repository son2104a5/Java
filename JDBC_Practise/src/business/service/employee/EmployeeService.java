package business.service.employee;

import business.model.Employee;
import business.service.AppService;

public interface EmployeeService extends AppService<Employee> {
    Employee getEmployeeById(String id);
}

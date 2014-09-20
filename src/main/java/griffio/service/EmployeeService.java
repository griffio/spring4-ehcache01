package griffio.service;

import griffio.domain.Employee;

public interface EmployeeService {

    Employee getEmployee(Long id);

    Employee saveEmployee(Employee employee);

}

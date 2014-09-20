package griffio.service;

import griffio.domain.Employee;
import griffio.persistence.EmployeeDao;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class EmployeeDaoService implements EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeDaoService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeDao.selectById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

}

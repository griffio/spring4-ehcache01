package griffio.persistence;

import griffio.domain.Employee;

/**
 *
 */
public interface EmployeeDao {

    Employee selectById(Long id);

    Employee save(Employee employee);

}

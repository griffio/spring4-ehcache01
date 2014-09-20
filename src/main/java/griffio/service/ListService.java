package griffio.service;

import griffio.domain.ListEmployeeSpecification;

import java.util.List;

/**
 *
 */
public interface ListService {

    List<String> getEmployees(ListEmployeeSpecification employeeSpecification);

}

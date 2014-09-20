package griffio.service;

import griffio.domain.ListEmployeeSpecification;
import griffio.persistence.ListDao;

import java.util.List;

public class ListDaoService implements ListService {

    private ListDao listDao;

    public ListDaoService(ListDao listDao) {
        this.listDao = listDao;
    }

    @Override
    public List<String> getEmployees(ListEmployeeSpecification employeeSpecification) {
        return listDao.selectEmployees(employeeSpecification);
    }
}

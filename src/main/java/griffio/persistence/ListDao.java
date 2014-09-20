package griffio.persistence;

import griffio.domain.ListEmployeeSpecification;

import java.util.List;

/**
 *
 */
public interface ListDao {

    List<String> selectEmployees(ListEmployeeSpecification specification);

}

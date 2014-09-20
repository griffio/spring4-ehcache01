package griffio.persistence.mybatty;

import griffio.annotation.EmployeesCache;
import griffio.domain.ListEmployeeSpecification;
import griffio.persistence.ListDao;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 *
 */
public class ListMapper implements ListDao {

    private SqlSession sqlSession;

    public ListMapper(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    @EmployeesCache
    public List<String> selectEmployees(ListEmployeeSpecification employeeSpecification) {
        return this.sqlSession.selectList("griffio.persistence.mybatty.ListMapper.listEmployees", employeeSpecification.getEmployer().getId());
    }

}

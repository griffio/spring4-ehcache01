package griffio.persistence.mybatty;

import griffio.annotation.EmployeesEvictionCache;
import griffio.domain.Employee;
import griffio.persistence.EmployeeDao;
import org.apache.ibatis.session.SqlSession;

import java.util.Random;

/**
 *
 */
public class EmployeeMapper implements EmployeeDao {

    private SqlSession sqlSession;

    public EmployeeMapper(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Employee selectById(Long id) {
        return (Employee) sqlSession.selectOne("griffio.persistence.mybatty.EmployeeMapper.selectEmployee", id);
    }

    @Override
    @EmployeesEvictionCache
    public Employee save(Employee employee) {
        if (employee.isNew()) {
            employee.setId((long) Math.abs(new Random().nextInt(999999)));
            sqlSession.insert("griffio.persistence.mybatty.EmployeeMapper.insertEmployee", employee);
        } else {
            sqlSession.update("griffio.persistence.mybatty.EmployeeMapper.updateEmployee", employee);
        }
        return employee;
    }
}
package griffio.service;

import griffio.domain.Employee;
import griffio.domain.Employer;
import griffio.domain.ListEmployeeSpecification;
import net.sf.ehcache.Ehcache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.assertEquals;

@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration(locations = "classpath*:/application.xml")
public class EmployeeListCacheTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ListService listService;

    @Autowired
    private CacheManager cacheManager;

    private Employee employee;

    @BeforeTransaction
    public void setupCache() {
        employeesEhCache().setStatisticsEnabled(true);
        employeesEhCache().clearStatistics();
    }

    @Test
    public void testNewEmployee() throws Exception {
        employee = employeeService.saveEmployee(new Employee(null, "Bobert", "Smith", new Date(), new Employer(1L)));
        employeeService.saveEmployee(new Employee(null, "Bain", "Cat", new Date(), new Employer(2L)));
    }

    @Test(dependsOnMethods = "testPutEmployeesInCache")
    public void testRemoveEmployeesFromCache() throws Exception {
        employee.setFirstname("Changed");
        employeeService.saveEmployee(employee);
        assertEquals(employeesEhCache().getLiveCacheStatistics().getRemovedCount(), 1);
    }

    @Test(dependsOnMethods = "testNewEmployee")
    public void testPutEmployeesInCache() throws Exception {
        listService.getEmployees(new ListEmployeeSpecification(new Employer(1L)));
        assertEquals(employeesEhCache().getLiveCacheStatistics().getPutCount(), 1);
    }

    @Test(dependsOnMethods = "testRemoveEmployeesFromCache")
    public void testMissedEmployeesInCache() throws Exception {
        listService.getEmployees(new ListEmployeeSpecification(new Employer(1L)));
        assertEquals(employeesEhCache().getLiveCacheStatistics().getCacheMissCount(), 1);
    }

    private Ehcache employeesEhCache() {
        Cache cache = cacheManager.getCache("employees");
        return (Ehcache) cache.getNativeCache();
    }

}
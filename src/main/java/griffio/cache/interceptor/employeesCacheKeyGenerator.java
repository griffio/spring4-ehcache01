package griffio.cache.interceptor;

import griffio.domain.Employee;
import griffio.domain.ListEmployeeSpecification;
import org.springframework.cache.interceptor.SimpleKeyGenerator;

import java.lang.reflect.Method;

public class employeesCacheKeyGenerator extends SimpleKeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {

        Object result = super.generate(target, method, params);

        if (result instanceof Employee) {
            return ((Employee) result).getEmployer().getId();
        }

        if (result instanceof ListEmployeeSpecification) {
            return ((ListEmployeeSpecification) result).getEmployer().getId();
        }

        return result;

    }

}

package griffio.domain;

import java.io.Serializable;

public class ListEmployeeSpecification implements Specification<Employee>, Serializable {

    private Employer employer;

    private static final long serialVersionUID = 1L;

    public ListEmployeeSpecification(Employer employer) {
        this.employer = employer;
    }

    @Override
    public boolean matches(Employee employee) {
        return employer.getId().equals(employee.getEmployer().getId());
    }

    public Employer getEmployer() {
        return employer;
    }

    @Override
    public String toString() {
        return "employerId:" + employer.getId();
    }
}

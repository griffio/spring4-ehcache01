package griffio.domain;

import griffio.persistence.Entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class Employee implements Entity, Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstname;
    private String lastname;
    private Date dob;
    private Employer employer;

    protected Employee() {
    }

    public Employee(Long id, String firstname, String lastname, Date dob, Employer employer) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.employer = employer;
    }

    @Override
    public boolean isNew() {
        return id == null;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
}

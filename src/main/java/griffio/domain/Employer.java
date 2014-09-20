package griffio.domain;

import griffio.persistence.Entity;

import java.io.Serializable;

public class Employer implements Entity, Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    protected Employer() {
    }

    public Employer(Long id) {
        this.id = id;
    }

    @Override
    public boolean isNew() {
        return id == null;
    }

    @Override
    public Long getId() {
        return id;
    }
}
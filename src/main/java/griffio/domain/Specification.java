package griffio.domain;

/**
 *
 */
public interface Specification<T> {

    boolean matches(T t);

}

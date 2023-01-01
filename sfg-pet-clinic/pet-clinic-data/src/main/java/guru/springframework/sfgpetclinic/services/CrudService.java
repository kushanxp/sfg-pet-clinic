package guru.springframework.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();
    T save(T t);
    T findById(ID id);
    void delete(T t);
    void deleteById(ID id);
}

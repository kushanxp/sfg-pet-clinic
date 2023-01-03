package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<Long, T>();

    Set<T> findAll() {
        return new HashSet<T>(map.values());
    }

    T findByID(Long id) {
        return map.get(id);
    }

    T save(T t) {
        if(t != null) {
            t.setId(getNextId());
        }
        map.put(t.getId(), t);
        return t;
    }

    void deleteById(Long id) {
        map.remove(id);
    }

    void delete(T t) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(t));
    }

    private Long getNextId() {
        Long id = null;
        try {
            id = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            id = 1L;
        }

        return id;
    }
}

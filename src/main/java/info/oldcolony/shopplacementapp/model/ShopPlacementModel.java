package info.oldcolony.shopplacementapp.model;

import info.oldcolony.shopplacementapp.model.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
abstract public class ShopPlacementModel<T> {

    protected abstract CrudRepository<T, Integer> getRepo();

    public List<T> getAll() {
        List<T> all = new ArrayList<>();
        Iterable<T> queriedItems = getRepo().findAll();
        queriedItems.forEach(all::add);
        return all;
    }
    public Optional<T> getElementById(Integer id) {
        return getRepo().findById(id);
    }

    public List<T> getElementsByIds(List<Integer> ids) {
        List<T> elements = new ArrayList<>();
        ids.forEach(id -> getElementById(id).ifPresent(elements::add));
        return elements;
    }

    public void add(T entity) {
        getRepo().save(entity);
    }

    public void add(List<T> entities) {
        getRepo().saveAll(entities);
    }


    public void remove(Integer id) {
        getRepo().deleteById(id);
    }

    public void remove(List<Integer> ids) {
        ids.forEach(this::remove);
    }

    public void removeAll() {
        getRepo().deleteAll();
    }
}


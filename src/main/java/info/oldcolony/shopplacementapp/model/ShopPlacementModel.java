package info.oldcolony.shopplacementapp.model;

import info.oldcolony.shopplacementapp.RepositoryElement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Abstract, generic helper class for facilitating two-way communication between a CRUD repository and the rest of the
 * application. Concrete subclasses must define the generic type to match the {@code RepositoryElement} in the {@code
 * CrudRepository}. Generic type must be a concrete subclass of {@code RepositoryElement}
 * @param <T extends RepositoryElement>
 */
@Component
abstract public class ShopPlacementModel<T extends RepositoryElement> {

    /**
     * Abstract method used for getting concrete subclass's class-specific repository.(Because repositories are
     * {@code @Autowired} by Spring, they cannot be a generic {@code CrudRepository}. This method allows this
     * abstract class to use the concrete subclass's repository in its methods.)
     * @return the concrete subclass's class-specific repository
     */
    protected abstract CrudRepository<T, Integer> getRepo();

    /**
     * Abstract method that takes a list of elements (that match the generic type), and updates the matching items in
     * the repository.
     * @param elements List of {@code RepositoryElement}s that need their information updated in the repository.
     */
    public abstract void update(List<T> elements);

    /**
     * Fetches and returns all elements in the repository.
     * @return List of all items in the repository
     */
    public List<T> getAll() {
        List<T> all = new ArrayList<>();
        Iterable<T> queriedItems = getRepo().findAll();
        System.out.println(queriedItems);
        queriedItems.forEach(all::add);
        return all;
    }
    /**
     * Fetches and returns the element with the provided {@code id}.
     * @param id The {@code id} of the element to be fetched
     * @return The element with the matching provided {@code id}
     */
    public Optional<T> getElementById(Integer id) {
        return getRepo().findById(id);
    }

    /**
     * Fetches and returns the elements with the provided ids
     * @param ids List of {@code ids} of the elements to be fetched
     * @return List of elements with the matching provided {@code ids}
     */
    public List<T> getElementsByIds(List<Integer> ids) {
        List<T> elements = new ArrayList<>();
        ids.forEach(id -> getElementById(id).ifPresent(elements::add));
        return elements;
    }

    /**
     * Add the provided {@code RepositoryEntity} to the repository
     * @param entity The {@code RepositoryEntity} entity to be added to the repository
     * @return The newly added entity
     */
    public T add(T entity) {
        return getRepo().save(entity);
    }

    /**
     * Add the provided {@code RepositoryEntity}s to the repository.
     * @param entities A list of {@code RepositoryEntity}s to be added to the repository
     * @return A list of the newly added entities
     */
    public Iterable<T> add(List<T> entities) {
        return getRepo().saveAll(entities);
    }

    /**
     * Remove the {@code RepositoryEntity} from repository that has an {@code id} that matches the provided {@code id}
     * @param id Id of the {@code RepositoryEntity} to be removed from the repository
     */
    public void remove(Integer id) {
        getRepo().deleteById(id);
    }

    /**
     * Remove the {@code RepositoryEntity}s from repository that have {@code id}s that matches the provided {@code
     * ids}
     * @param ids List of ids for the {@code RepositoryEntity} items that will be removed from the repository
     */
    public void remove(List<Integer> ids) {
        ids.forEach(this::remove);
    }

    /**
     * Removes all {@code RepositoryEntity}s from the repository
     */
    public void removeAll() {
        getRepo().deleteAll();
    }
}


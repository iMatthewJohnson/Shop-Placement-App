package info.oldcolony.shopplacementapp.model.shop;

import org.springframework.data.repository.CrudRepository;
/**
 * CRUD repository that stores {@code Shop} entities.
 */
public interface ShopRepository extends CrudRepository<Shop, Integer> {

}

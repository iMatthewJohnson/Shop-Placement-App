package info.oldcolony.shopplacementapp.cruds;

import info.oldcolony.shopplacementapp.SyncableRepo;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<ShopEntity, Integer>, SyncableRepo {

}

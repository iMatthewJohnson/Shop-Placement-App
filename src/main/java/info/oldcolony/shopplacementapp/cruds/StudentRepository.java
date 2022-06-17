package info.oldcolony.shopplacementapp.cruds;

import info.oldcolony.shopplacementapp.SyncableRepo;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called studentRepository
// CRUD refers Create, Read, Update, Delete

public interface StudentRepository extends CrudRepository<StudentEntity, Integer>, SyncableRepo {

}
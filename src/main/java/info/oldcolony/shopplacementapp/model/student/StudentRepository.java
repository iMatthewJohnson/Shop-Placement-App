package info.oldcolony.shopplacementapp.model.student;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

// This will be AUTO IMPLEMENTED by Spring into a Bean called studentRepository
// CRUD refers Create, Read, Update, Delete

public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.exploratoryGrade IS NULL")
    Collection<Student> findAllUsersWithoutExploratoryGrade();

    @Query(value = "SELECT * FROM Student ORDER BY exploratoryGrade DESC", nativeQuery = true)
    Collection<Student> getStudentsOrderedByExploratoryGrade();
}
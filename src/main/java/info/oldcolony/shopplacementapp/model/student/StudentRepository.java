package info.oldcolony.shopplacementapp.model.student;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

// This will be AUTO IMPLEMENTED by Spring into a Bean called studentRepository
// CRUD refers Create, Read, Update, Delete

/**
 * CRUD repository that stores {@code Student} entities.
 */
public interface StudentRepository extends CrudRepository<Student, Integer> {

    /**
     * Query for finding all students without exploratory grades
     * @return List of all students without exploratory grade
     */
    @Query("SELECT s FROM Student s WHERE s.exploratoryGrade IS NULL")
    Collection<Student> findAllUsersWithoutExploratoryGrade();

    /**
     * Get a list of all students ordered by exploratory grade, in descending order (highest grade first)
     * @return List of students ordered by exploratory grade, in descending order.
     */
    @Query(value = "SELECT * FROM Student ORDER BY exploratoryGrade DESC", nativeQuery = true)
    Collection<Student> getStudentsOrderedByExploratoryGrade();
}
package info.oldcolony.shopplacementapp.model.student;

import info.oldcolony.shopplacementapp.model.ShopPlacementModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Helper class for facilitating two-way communication between a {@code StudentRepository} and the rest of the
 * application.
 */
@Component
public class StudentDataModel extends ShopPlacementModel<Student> {

    @Autowired
    StudentRepository studentRepository;

    /**
     * Update a {@code Student} in the {@code StudentRepository}. The {@code Student} with the provided {@code id}
     * will the item updated. Any non {@code null} fields will overwrite the value of the respective field in the
     * repository. Any {@code null} fields will be ignored and not updated.
     * @param id REQUIRED Student ID of the student being updated
     * @param firstName OPTIONAL Student's updated first name
     * @param lastName OPTIONAL Student's updated last name
     * @param idOfEnrolledShop OPTIONAL Student's updated enrolled shop
     * @param exploratoryGrade OPTIONAL Student's updated exploratory grade
     * @param idsOfShopChoices OPTIONAL Student's updated list of IDs of the student's shop choices
     */
    public void update(@NonNull Integer id,
                       @Nullable String firstName,
                       @Nullable String lastName,
                       @Nullable Integer idOfEnrolledShop,
                       @Nullable Double exploratoryGrade,
                       @Nullable List<Integer> idsOfShopChoices) {
        Optional<Student> studentQuery = studentRepository.findById(id);
        if (studentQuery.isPresent()) {
            Student student = studentQuery.get();
            if (firstName != null) student.setFirstName(firstName);
            if (lastName != null)student.setLastName(lastName);
            if (idOfEnrolledShop != null) student.setIdOfEnrolledShop(idOfEnrolledShop);
            if (idsOfShopChoices != null) student.setIdsOfShopChoices(idsOfShopChoices);
            if (exploratoryGrade != null) student.setExploratoryGrade(exploratoryGrade);
            studentRepository.save(student);
        }
    }

    /**
     * Update a list of {@code Student}s in the {@code StudentRepository}.Any non {@code null} fields of each {@code Student}
     * will overwrite the value of the respective field in the repository. Any {@code null} fields will be ignored
     * and not updated.
     * @param students List of {@code RepositoryElement}s that need their information updated in the repository.
     */
    @Override
    public void update(List<Student> students) {
        students.forEach(student ->
                update(student.getStudentId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getStudentId(),
                        student.getExploratoryGrade(),
                        student.getIdsOfShopChoices()));
    }

    /**
     * Returns the {@code Student} repository. This is used so abstract superclass has access to {@code @Autowired}
     * repository
     */
    @Override
    protected StudentRepository getRepo() {
        return studentRepository;
    }
}

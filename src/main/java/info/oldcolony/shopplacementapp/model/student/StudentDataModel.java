package info.oldcolony.shopplacementapp.model.student;

import info.oldcolony.shopplacementapp.model.ShopPlacementModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentDataModel extends ShopPlacementModel<Student> {

    @Autowired
    StudentRepository studentRepository;

    public void updateStudentWithId(@NonNull Integer id,
                                    @Nullable String firstName,
                                    @Nullable String lastName,
                                    @Nullable Integer idOfEnrolledShop,
                                    @Nullable Double exploratoryGrade,
                                    @Nullable List<Integer> idsOfShopChoices) {
        Optional<Student> studentQuery = studentRepository.findById(id);
        if (studentQuery.isPresent()) {
            Student student = studentQuery.get();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setIdOfEnrolledShop(idOfEnrolledShop);
            student.setIdsOfShopChoices(idsOfShopChoices);
            student.setExploratoryGrade(exploratoryGrade);
            studentRepository.save(student);
        }
    }

    @Override
    public void update(List<Student> students) {
        students.forEach(student ->
                updateStudentWithId(student.getStudentId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getStudentId(),
                        student.getExploratoryGrade(),
                        student.getIdsOfShopChoices()));
    }

    @Override
    protected StudentRepository getRepo() {
        return studentRepository;
    }
}

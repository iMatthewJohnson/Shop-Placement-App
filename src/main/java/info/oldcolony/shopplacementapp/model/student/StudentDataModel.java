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

    public void updateStudents(List<Student> students) {
        students.forEach(student ->
                updateStudentWithId(student.getStudentId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getStudentId(),
                        student.getExploratoryGrade(),
                        student.getIdsOfShopChoices()));
    }


    //    /**
    //     * Enroll students into their shops and returns an array of all the {@code Student} objects. All students must
    //     * have an exploratory grade in order to run this method
    //     *
    //     */
    //    public Collection<Student> placeStudentsInShops() {
    //        if (studentRepository.findAllUsersWithoutExploratoryGrade().size() > 0) throw new IllegalStateException("Not " +
    //                "all students have exploratory " +
    //                "grades. All students must have an exploratory grade in order to run method");
    //        Collection<Student> studentList = studentRepository.getStudentsOrderedByExploratoryGrade();
    //        for (Student student : studentList) {
    //            student.setIdOfEnrolledShop(null);
    //            int choice = 0;
    //            Integer highestChoiceId = student.getIdOfShopChoiceAtIndex(choice);
    //            Optional<Shop> highestChoiceShop = shopRepository.findById(highestChoiceId.intValue());
    //            while (highestChoiceShop.isPresent() && highestChoiceShop.get().enrollStudentWithId(student.getStudentId())) {
    //                highestChoiceId = student.getIdOfShopChoiceAtIndex(++choice);
    //                highestChoiceShop =  shopRepository.findById(highestChoiceId.intValue());
    //            }
    //        }
    //        return studentList;
    //    }

    @Override
    protected StudentRepository getRepo() {
        return studentRepository;
    }
}

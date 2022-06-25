package info.oldcolony.shopplacementapp.model;

import info.oldcolony.shopplacementapp.model.cruds.Shop;
import info.oldcolony.shopplacementapp.model.cruds.ShopRepository;
import info.oldcolony.shopplacementapp.model.cruds.Student;
import info.oldcolony.shopplacementapp.model.cruds.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ShopPlacementModel {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    ShopRepository shopRepository;

    /**
     * Adds a new student to the model
     * @param student The student to be added to the model
     */
    public void add(Student student) {
        studentRepository.save(student);
    }

    public void add(List<Student> students) {
        studentRepository.saveAll(students);
    }

    /**
     * Enroll students into their shops and returns an array of all the {@code Student} objects. All students must
     * have an exploratory grade in order to run this method
     *
     */
    public Collection<Student> placeStudentsInShops() {
        if (studentRepository.findAllUsersWithoutExploratoryGrade().size() > 0) throw new IllegalStateException("Not " +
                "all students have exploratory " +
                "grades. All students must have an exploratory grade in order to run method");
        Collection<Student> studentList = studentRepository.getStudentsOrderedByExploratoryGrade();
        for (Student student : studentList) {
            student.setIdOfEnrolledShop(null);
            int choice = 0;
            Integer highestChoiceId = student.getIdOfShopChoiceAtIndex(choice);
            Optional<Shop> highestChoiceShop = shopRepository.findById(highestChoiceId.intValue());
            while (highestChoiceShop.isPresent() && highestChoiceShop.get().enrollStudentWithId(student.getStudentId())) {
                highestChoiceId = student.getIdOfShopChoiceAtIndex(++choice);
                highestChoiceShop =  shopRepository.findById(highestChoiceId.intValue());
            }
        }
        return studentList;
    }

    public List<Student> getAllStudents() {
        List<Student> allStudents = new ArrayList<>();
        Iterable<Student> queriedStudents = studentRepository.findAll();
        queriedStudents.forEach(allStudents::add);
        return allStudents;
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public void removeStudent(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        // If student exists, remove student from their enrolled shop, and delete student
        if (student.isPresent()) {
            Integer enrolledShopId = student.get().getIdOfEnrolledShop();
            if (enrolledShopId != null) {
                Optional<Shop> enrolledShop = shopRepository.findById(enrolledShopId);
                enrolledShop.ifPresent(shop -> shop.unenrollStudentWithId(id));
            }
            studentRepository.delete(student.get());
        }
    }

    public void removeStudents(List<Integer> ids) {
        ids.forEach(this::removeStudent);
    }

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

    public void removeAllStudents() {
        studentRepository.deleteAll();
    }

    public List<Student> getStudentsByIds(List<Integer> ids) {
        List<Student> studentList = new ArrayList<>();
        ids.forEach(id -> getStudentById(id).ifPresent(studentList::add));
        return studentList;
    }
}

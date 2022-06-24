package info.oldcolony.shopplacementapp.model;

import info.oldcolony.shopplacementapp.model.cruds.Shop;
import info.oldcolony.shopplacementapp.model.cruds.ShopRepository;
import info.oldcolony.shopplacementapp.model.cruds.Student;
import info.oldcolony.shopplacementapp.model.cruds.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

}

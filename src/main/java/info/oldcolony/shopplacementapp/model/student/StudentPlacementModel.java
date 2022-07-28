package info.oldcolony.shopplacementapp.model.student;

import info.oldcolony.shopplacementapp.model.shop.Shop;
import info.oldcolony.shopplacementapp.model.shop.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
//TODO: Add documentation

@Component
public class StudentPlacementModel {

        @Autowired
        StudentRepository studentRepository;
        @Autowired
        ShopRepository shopRepository;

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
                Optional<Shop> highestChoiceShop = shopRepository.findById(highestChoiceId);
                while (highestChoiceShop.isPresent() && highestChoiceShop.get().enrollStudentWithId(student.getStudentId())) {
                    highestChoiceId = student.getIdOfShopChoiceAtIndex(++choice);
                    highestChoiceShop =  shopRepository.findById(highestChoiceId);
                }
            }
            return studentList;
        }
}

package info.oldcolony.shopplacementapp.controllers;

import info.oldcolony.shopplacementapp.model.cruds.Student;
import info.oldcolony.test.testdatageneration.TestDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="test_students")
public class TestStudent extends Student implements TestablePerson {

    private static Integer nextStudentId = 0;
    @Transient
    @Autowired
    private static TestStudentRepository testStudentRepository;

    public TestStudent() {
        super(nextStudentId++, TestablePerson.randomFirstName(), TestablePerson.randomLastName());
    }

    public static Integer getNextStudentId() {
        return nextStudentId++;
    }

    public static void generateTestStudents(int numberOfStudents) {
        testStudentRepository.deleteAll();
        List<TestShop> allShops = TestShop.getAllShops();
        List<TestStudent> allStudents = new ArrayList<>(); // Create a list of students, and the make one "save" call at
        // the end
        for (int i = 0; i < numberOfStudents; i++) {
            TestStudent testStudent = new TestStudent();
            testStudent.setExploratoryGrade(TestDataGenerator.getRandomDouble(100));
            Integer[] randomIndices = TestDataGenerator.getRandomArrayOfIntegers(0, allShops.size());
            for (int j = 0; j < randomIndices.length; j++) {
                int index = randomIndices[j];
                testStudent.setIdOfShopChoiceAtIndex(j, allShops.get(index).getId());
                allStudents.add(testStudent);
            }
        }
        testStudentRepository.saveAll(allStudents);
    }

}

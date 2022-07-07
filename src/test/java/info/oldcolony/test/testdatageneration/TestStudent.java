package info.oldcolony.test.testdatageneration;

import info.oldcolony.shopplacementapp.controllers.TestStudentRepository;
import info.oldcolony.shopplacementapp.model.student.Student;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TestStudent extends Student implements TestablePerson {

    private static Integer nextStudentId = 1000000000; //high enough number to not interfere with actual students' ids
    @Transient
    @Autowired
    private static TestStudentRepository testStudentRepository;

    public TestStudent() {
        super(nextStudentId++, TestablePerson.randomFirstName(), TestablePerson.randomLastName(), null, null
        , null);
    }

    public static Integer getNextStudentId() {
        return nextStudentId++;
    }

    public static List<TestStudent> generateTestStudents(int numberOfStudents) {
        final int NUMBER_OF_SHOPS = 13;
        List<TestStudent> allStudents = new ArrayList<>();
        for (int i = 0; i < numberOfStudents; i++) {
            TestStudent testStudent = new TestStudent();
            testStudent.setExploratoryGrade(TestDataGenerator.getRandomDouble(100));
            List<Integer> randomIndices = TestDataGenerator.getRandomArrayOfIntegers(0, NUMBER_OF_SHOPS);
            for (int j = 0; j < randomIndices.size(); j++) {
                testStudent.setIdOfShopChoiceAtIndex(j, randomIndices.get(j));
            }
            allStudents.add(testStudent);
        }
        return allStudents;
    }

}

package info.oldcolony.shopplacementapp.model.student;

import info.oldcolony.test.testdatageneration.TestDataGenerator;
import info.oldcolony.test.testdatageneration.TestablePerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


class StudentTest {

    private static final String FIRST_NAME = TestablePerson.randomFirstName();
    private static final String LAST_NAME = TestablePerson.randomLastName();
    private static final Integer STUDENT_ID = TestDataGenerator.getRandomInt();
    private static final Integer ID_OF_ENROLLED_SHOP = TestDataGenerator.getRandomInt(13);
    private static final Double EXPLORATORY_GRADE = TestDataGenerator.getRandomDouble(100);
    private static final List<Integer> IDS_OF_CHOICES = TestDataGenerator.getRandomArrayOfIntegers(1, 13);
    private Student testStudent;

    @BeforeEach
    void setUp() {
        testStudent = new Student(STUDENT_ID, FIRST_NAME, LAST_NAME, ID_OF_ENROLLED_SHOP, EXPLORATORY_GRADE,
                IDS_OF_CHOICES);
    }

    @Test
    void getFirstName() {
        assertEquals(FIRST_NAME, testStudent.getFirstName());
    }

    @Test
    void setFirstName() {
        String newFirstName = TestablePerson.randomFirstName();
        testStudent.setFirstName(newFirstName);
        assertEquals(newFirstName, testStudent.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals(LAST_NAME, testStudent.getLastName());
    }

    @Test
    void setLastName() {
        String newLastName = TestablePerson.randomLastName();
        testStudent.setLastName(newLastName);
        assertEquals(newLastName, testStudent.getLastName());
    }

    @Test
    void getStudentId() {
        assertEquals(STUDENT_ID, testStudent.getStudentId());
    }

    @Test
    void setStudentId() {
        ArrayList<Integer> excludedNumbers = new ArrayList<>();
        excludedNumbers.add(STUDENT_ID);
        int newStudentId = TestDataGenerator.getRandomInt(excludedNumbers);
        testStudent.setStudentId(newStudentId);
        assertEquals(newStudentId, testStudent.getStudentId());
    }

    @Test
    void getIdOfEnrolledShop() {
        assertEquals(ID_OF_ENROLLED_SHOP, testStudent.getIdOfEnrolledShop());
    }

    @Test
    void setIdOfEnrolledShop() {
        ArrayList<Integer> excludedNumbers = new ArrayList<>();
        excludedNumbers.add(testStudent.getIdOfEnrolledShop());
        int newIdOfEnrolledShop = TestDataGenerator.getRandomInt(excludedNumbers);
        testStudent.setIdOfEnrolledShop(newIdOfEnrolledShop);
        assertEquals(newIdOfEnrolledShop, testStudent.getIdOfEnrolledShop());
    }

    @Test
    void getExploratoryGrade() {
        assertEquals(EXPLORATORY_GRADE, testStudent.getExploratoryGrade());
    }

    @Test
    void setExploratoryGrade() {
        double newExploratoryGrade = TestDataGenerator.getRandomDouble(100);
        testStudent.setExploratoryGrade(newExploratoryGrade);
        assertEquals(newExploratoryGrade, testStudent.getExploratoryGrade());
    }

    @Test
    void getIdsOfShopChoices() {
        assertEquals(IDS_OF_CHOICES, testStudent.getIdsOfShopChoices());
    }

    @Test
    void setIdsOfShopChoices() {
        List<Integer> newIdsOfShopChoices = TestDataGenerator.getRandomArrayOfIntegers(1, 13);
        testStudent.setIdsOfShopChoices(newIdsOfShopChoices);
        assertEquals(newIdsOfShopChoices, testStudent.getIdsOfShopChoices());
    }

    @Test
    void setIdOfShopChoiceAtIndex() {
        List<Integer> newIdsOfShopChoices = TestDataGenerator.getRandomArrayOfIntegers(1, 13);
        for (int i = 0; i < newIdsOfShopChoices.size(); i++) {
            testStudent.setIdOfShopChoiceAtIndex(i, newIdsOfShopChoices.get(i));
        }
        assertEquals(newIdsOfShopChoices, testStudent.getIdsOfShopChoices());
    }

    @Test
    void getIdOfShopChoiceAtIndex() {
        for (int i = 0; i < IDS_OF_CHOICES.size(); i++) {
            assertEquals(IDS_OF_CHOICES.get(i), testStudent.getIdOfShopChoiceAtIndex(i));
        }
    }

    @Test
    void testToString() {
        String testStudentString =
                "{\"studentId\":" + STUDENT_ID + "," +
                        "\"firstName\":\"" + FIRST_NAME + "\"," +
                        "\"lastName\":\"" + LAST_NAME + "\"," +
                        "\"idOfEnrolledShop\":" + ID_OF_ENROLLED_SHOP + "," +
                        "\"exploratoryGrade\":" + EXPLORATORY_GRADE + "," +
                        "\"idsOfShopChoices\":" + "[" + IDS_OF_CHOICES + "]}";
        testStudentString = testStudentString.replaceAll("\\s+","");
        assertEquals(testStudentString, testStudent.toString());
    }

    @Test
    void testEquals() {
        Student newTestStudent = new Student(STUDENT_ID, FIRST_NAME, LAST_NAME, ID_OF_ENROLLED_SHOP, EXPLORATORY_GRADE,
                IDS_OF_CHOICES);
        assertEquals(newTestStudent, testStudent);
    }
}
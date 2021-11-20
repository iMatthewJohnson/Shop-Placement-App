package info.oldcolony.shopplacementapp;

import info.oldcolony.test.testdatageneration.TestDataGenerator;
import info.oldcolony.test.testdatageneration.TestablePerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    String firstNane;
    String lastName;
    Integer studentId;
    Student testStudent;

    @BeforeEach
    void setUp() {
        firstNane = TestablePerson.randomFirstName();
        lastName = TestablePerson.randomLastName();
        studentId = TestDataGenerator.getRandomInt();
        testStudent = new Student(studentId, firstNane, lastName);
    }

    @Test
    void getFirstName() {
        assertEquals(firstNane, testStudent.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals(lastName, testStudent.getLastName());
    }

    @Test
    void getFullName() {
        assertEquals(firstNane + " " + lastName, testStudent.getFullName());
    }

    @Test
    void getStudentId() {
        assertEquals(studentId, testStudent.getStudentId());
    }

    @Test
    void getShopChoiceAtIndex() {
    }

    @Test
    void setShopChoiceAtIndex() {
    }

    @Test
    void getExploratoryGrade() {
    }

    @Test
    void setExploratoryGrade() {
    }

    @Test
    void setEnrolledShop() {
    }

    @Test
    void getEnrolledShop() {
    }

    @Test
    void compareTo() {
    }
}
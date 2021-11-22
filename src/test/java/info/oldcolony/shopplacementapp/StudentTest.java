package info.oldcolony.shopplacementapp;

import info.oldcolony.test.testdatageneration.TestDataGenerator;
import info.oldcolony.test.testdatageneration.TestShop;
import info.oldcolony.test.testdatageneration.TestStudent;
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
        Shop[] testShops = new Shop[5];
        for (int i = 0; i < testShops.length; i++) {
            testShops[i] = new TestShop();
        }
        Student student = new Student(studentId, firstNane, lastName, testShops, 100, null);
        for (int i = 0; i < testShops.length; i++) {
            assertEquals(testShops[i], student.getShopChoiceAtIndex(i));
        }
    }

    @Test
    void setShopChoiceAtIndex() {
        Shop[] testShops = new Shop[5];
        for (int i = 0; i < testShops.length; i++) {
            Shop testShop = new TestShop();
            testStudent.setShopChoiceAtIndex(i, testShop);
            assertEquals(testShop, testStudent.getShopChoiceAtIndex(i));
        }
    }

    @Test
    void getExploratoryGrade() {
        double exploratoryGrade = TestDataGenerator.getRandomDouble(100);
        Student testStudent = new Student(studentId, firstNane, lastName, null, exploratoryGrade, null);
        assertEquals(exploratoryGrade, testStudent.getExploratoryGrade());
    }

    @Test
    void setExploratoryGrade() {
        double exploratoryGrade = TestDataGenerator.getRandomDouble(100);
        testStudent.setExploratoryGrade(exploratoryGrade);
        assertEquals(exploratoryGrade, testStudent.getExploratoryGrade());
    }

    @Test
    void setEnrolledShop() {
        Shop testShop = new TestShop();
        testStudent.setEnrolledShop(testShop);
        assertEquals(testShop, testStudent.getEnrolledShop());
    }

    @Test
    void getEnrolledShop() {
        Shop testShop = new TestShop();
        Student testStudent = new Student(studentId, firstNane, lastName, null, 100, testShop);
        assertEquals(testShop, testStudent.getEnrolledShop());
    }

    @Test
    void compareTo() {
        Student otherTestStudent = new TestStudent();
        testStudent.setExploratoryGrade(TestDataGenerator.getRandomDouble(100));
        otherTestStudent.setExploratoryGrade(TestDataGenerator.getRandomDouble(100));
        int compareTo = 0;
        if (testStudent.getExploratoryGrade() > otherTestStudent.getExploratoryGrade()) {
            compareTo = -1;
        } else if (testStudent.getExploratoryGrade() < otherTestStudent.getExploratoryGrade()) {
            compareTo = 1;
        }
        assertEquals(testStudent.compareTo(otherTestStudent), compareTo);
    }
}
package info.oldcolony.shopplacementapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import info.oldcolony.test.testdatageneration.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    private Shop testShop;
    private Student testStudent;

    @BeforeEach
    void setUp() {
        testShop = new TestShop();
        testStudent = new TestStudent();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addNewStudent() {

        testShop.addStudent(testStudent);
        Student[] students = testShop.getStudentsEnrolled();
        assertSame(students[0], testStudent);
    }

    @Test
    void addStudentWhenFull() {

        for (int i = 0; i < testShop.getCapacity(); i++) {
            TestStudent testStudent = new TestStudent();
            assertTrue(testShop.addStudent(testStudent));
        }
        TestStudent testStudent = new TestStudent();
        assertFalse(testShop.addStudent(testStudent));
        ArrayList<Student> enrolledStudents = new ArrayList<>(List.of(testShop.getStudentsEnrolled()));
        assertFalse(enrolledStudents.contains(testStudent));
    }

    @Test
    void removeStudentWithStudentObject() {
    }

    @Test
    void removeStudentWithStudentId() {
    }

    @Test
    void isFull() {
    }

    @Test
    void getName() {
    }

    @Test
    void getCapacity() {
    }

    @Test
    void getStudentsEnrolled() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }
}
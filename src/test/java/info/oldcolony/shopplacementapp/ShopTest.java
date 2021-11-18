package info.oldcolony.shopplacementapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import info.oldcolony.test.testdatageneration.*;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    private Shop testShop;
    private Student testStudent;

    @BeforeEach
    void setUp() {
        testShop = new Shop("Automotive", 12);
        testStudent = new Student()
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addNewStudent() {
        Student newStudent = new Student(500,
        try {
            shop.addStudent(newStudent);
        } catch (DuplicateEntryException e) {
            e.printStackTrace();
            fail("Failed to add a student");
        }
        Student[] students = shop.getStudentsEnrolled();
        for (Student student : students) {

        }
    }

    @Test
    void addStudentWhenFull() {

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
package info.oldcolony.shopplacementapp.model_controller;

import info.oldcolony.shopplacementapp.model_controller.Student;
import info.oldcolony.test.testdatageneration.TestStudent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ShopPlacementModelTest {
    private static Student[] testStudents;
    private static final int NO_OF_STUDENTS = 170;

    @BeforeAll
    static void setUp() {
        testStudents = TestStudent.generateTestStudents(NO_OF_STUDENTS);
    }

    @Test
    void placeStudents() {

    }

    @Test
    void getStudents() {

    }
}
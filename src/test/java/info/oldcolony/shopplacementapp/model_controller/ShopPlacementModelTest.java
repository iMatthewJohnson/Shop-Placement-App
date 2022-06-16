package info.oldcolony.shopplacementapp.model_controller;

import info.oldcolony.test.testdatageneration.TestStudent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
class ShopPlacementModelTest {

    private Student[] testStudents;
    private static final int NO_OF_STUDENTS = 170;

    @BeforeEach
    void setUp() {
        testStudents = TestStudent.generateTestStudents(NO_OF_STUDENTS);
    }
    @Test
    void add() {
        ShopPlacementModel shopPlacementModel = new ShopPlacementModel(testStudents);
        Student newStudent = new TestStudent();
        shopPlacementModel.add(newStudent);
        HashMap<Integer, Student> students = shopPlacementModel.getAllStudents();
        assertTrue(students.containsValue(newStudent));
    }

    @Test
    void placeStudentsInShops() {
    }

    @Test
    void getStudents() {
        ShopPlacementModel shopPlacementModel = new ShopPlacementModel(testStudents);
        Object[] modelsStudents = shopPlacementModel.getAllStudents().values().toArray();
        assertTrue(Arrays.equals(testStudents, modelsStudents));
    }
}
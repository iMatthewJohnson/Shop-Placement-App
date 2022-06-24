package info.oldcolony.shopplacementapp.controllers;

import info.oldcolony.shopplacementapp.ShopPlacementAppApplication;
import info.oldcolony.shopplacementapp.model.ShopPlacementModel;
import info.oldcolony.shopplacementapp.model.cruds.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ShopPlacementModelTest {

    @Autowired
    private static TestStudentRepository testStudentRepository;

    @BeforeAll
    static void beforeAll() {
        ShopPlacementAppApplication.main(new String[0]);
        int numberOfStudents = 170;
        TestStudent.generateTestStudents(numberOfStudents);
    }

    @Test
    void add() {
        ShopPlacementModel model = new ShopPlacementModel();
        Student newStudent = new TestStudent();
        model.add(newStudent);
        assertTrue(testStudentRepository.existsById(newStudent.getStudentId()));
    }

    @Test
    void placeStudentsInShops() {
    }

    @Test
    void getAllStudents() {
    }
}
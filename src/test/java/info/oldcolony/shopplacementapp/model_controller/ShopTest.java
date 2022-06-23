//package info.oldcolony.shopplacementapp.model_controller;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import info.oldcolony.test.testdatageneration.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ShopTest {
//    private ShopModel testShop;
//    private StudentModel testStudent;
//
//    @BeforeEach
//    void setUp() {
//        testShop = new TestShop();
//        testStudent = new TestStudent();
//    }
//
//
//    @Test
//    void addNewStudent() {
//        testShop.addStudent(testStudent);
//        StudentModel[] students = testShop.getStudentsEnrolled();
//        assertSame(students[0], testStudent);
//    }
//
//    @Test
//    void addStudentWhenFull() {
//        for (int i = 0; i < testShop.getCapacity(); i++) {
//            TestStudent testStudent = new TestStudent();
//            assertTrue(testShop.addStudent(testStudent));
//        }
//        TestStudent testStudent = new TestStudent();
//        assertFalse(testShop.addStudent(testStudent));
//        ArrayList<StudentModel> enrolledStudents = new ArrayList<>(List.of(testShop.getStudentsEnrolled()));
//        assertFalse(enrolledStudents.contains(testStudent));
//    }
//
//    @Test
//    void isFull() {
//        for (int i = 0; i < testShop.getCapacity() - 1; i++) {
//            testShop.addStudent(new TestStudent());
//            assertFalse(testShop.isFull());
//        }
//        testShop.addStudent(new TestStudent());
//        assertTrue(testShop.isFull());
//    }
//    @Test
//    void removeStudentWithStudentObject() {
//        testShop.addStudent(testStudent);
//        testShop.removeStudent(testStudent);
//        ArrayList<StudentModel> enrolledStudents = new ArrayList<>(List.of(testShop.getStudentsEnrolled()));
//        assertFalse(enrolledStudents.contains(testStudent));
//    }
//
//    @Test
//    void removeStudentWithStudentId() {
//        testShop.addStudent(testStudent);
//        testShop.removeStudent(testStudent.getStudentId());
//        ArrayList<StudentModel> enrolledStudents = new ArrayList<>(List.of(testShop.getStudentsEnrolled()));
//        assertFalse(enrolledStudents.contains(testStudent));
//    }
//
//    @Test
//    void getName() {
//        String shopName = "Test Shop";
//        int shopCapacity = 12; // arbitrary value
//        ShopModel testShop = new ShopModel(shopName, shopCapacity);
//        assertEquals(testShop.getName(), shopName);
//    }
//
//    @Test
//    void getCapacity() {
//        Integer randomCapacity = (int) (Math.random() * 20);
//        String shopName = "Test Shop";
//        ShopModel testShop = new ShopModel(shopName, randomCapacity);
//        assertEquals(randomCapacity, testShop.getCapacity());
//    }
//
//    @Test
//    void getStudentsEnrolled() {
//        // 8 is the lowest value for capacity. This ensures that the number of students don't exceed any shop's
//        // capacity.
//        int numberOfStudents = 8;
//        StudentModel[] testStudents = TestStudent.generateTestStudents(numberOfStudents);
//        for (StudentModel student : testStudents) {
//            testShop.addStudent(student);
//        }
//        assertArrayEquals(testStudents, testShop.getStudentsEnrolled());
//    }
//}
//package info.oldcolony.shopplacementapp.model_controller;
//
//import info.oldcolony.test.testdatageneration.TestDataGenerator;
//import info.oldcolony.test.testdatageneration.TestShop;
//import info.oldcolony.test.testdatageneration.TestablePerson;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class StudentTest {
//
//    String firstNane;
//    String lastName;
//    Integer studentId;
//    StudentModel testStudent;
//
//    @BeforeEach
//    void setUp() {
//        firstNane = TestablePerson.randomFirstName();
//        lastName = TestablePerson.randomLastName();
//        studentId = TestDataGenerator.getRandomInt();
//        testStudent = new StudentModel(studentId, firstNane, lastName);
//    }
//
//    @Test
//    void getFirstName() {
//        assertEquals(firstNane, testStudent.getFirstName());
//    }
//
//    @Test
//    void setFirstNane() {
//        //TODO
//    }
//
//    @Test
//    void getLastName() {
//        assertEquals(lastName, testStudent.getLastName());
//    }
//
//    @Test
//    void setLastName() {
//        //TODO
//    }
//
//    @Test
//    void getFullName() {
//        assertEquals(firstNane + " " + lastName, testStudent.getFullName());
//    }
//
//    @Test
//    void getStudentId() {
//        assertEquals(studentId, testStudent.getStudentId());
//    }
//
//    @Test
//    void getShopChoiceAtIndex() {
//        ShopModel[] testShops = new ShopModel[5];
//        for (int i = 0; i < testShops.length; i++) {
//            testShops[i] = new TestShop();
//        }
//        StudentModel student = new StudentModel(studentId, firstNane, lastName, testShops, null, null);
//        for (int i = 0; i < testShops.length; i++) {
//            assertEquals(testShops[i], student.getShopChoiceAtIndex(i));
//        }
//    }
//
//    @Test
//    void setShopChoiceAtIndex() {
//        ShopModel[] testShops = new ShopModel[5];
//        for (int i = 0; i < testShops.length; i++) {
//            ShopModel testShop = new TestShop();
//            testStudent.setShopChoiceAtIndex(i, testShop);
//            assertEquals(testShop, testStudent.getShopChoiceAtIndex(i));
//        }
//    }
//
//    @Test
//    void getExploratoryGrade() {
//        double exploratoryGrade = TestDataGenerator.getRandomDouble(100);
//        StudentModel testStudent = new StudentModel(studentId, firstNane, lastName, null, exploratoryGrade, null);
//        assertEquals(exploratoryGrade, testStudent.getExploratoryGrade());
//    }
//
//    @Test
//    void setExploratoryGrade() {
//        double exploratoryGrade = TestDataGenerator.getRandomDouble(100);
//        testStudent.setExploratoryGrade(exploratoryGrade);
//        assertEquals(exploratoryGrade, testStudent.getExploratoryGrade());
//    }
//
//    @Test
//    void setEnrolledShop() {
//        ShopModel testShop = new TestShop();
//        testStudent.setEnrolledShop(testShop);
//        assertEquals(testShop, testStudent.getEnrolledShop());
//    }
//
//    @Test
//    void getEnrolledShop() {
//        ShopModel testShop = new TestShop();
//        StudentModel testStudent = new StudentModel(studentId, firstNane, lastName, null, null, testShop);
//        assertEquals(testShop, testStudent.getEnrolledShop());
//    }
//}
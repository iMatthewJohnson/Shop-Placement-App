//package info.oldcolony.test.testdatageneration;
//
//import info.oldcolony.shopplacementapp.model_controller.ShopModel;
//import info.oldcolony.shopplacementapp.model_controller.StudentModel;
//
//public class TestStudent extends StudentModel implements TestablePerson {
//
//    private static Integer nextStudentId = 0;
//
//
//    public TestStudent() {
//        super(nextStudentId++, TestablePerson.randomFirstName(), TestablePerson.randomLastName());
//    }
//
//    public static StudentModel[] generateTestStudents(int numberOfStudents) {
//        StudentModel[] testStudents = new StudentModel[numberOfStudents];
//        // Ensure all generated students are referring to the same instances of Shop.
//        // Generate array of Shop instances of all the shops. This array will be used
//        // as a "master list" that the generated students will use
//        ShopModel[] allShops = TestShop.getAllShops();
//        for (int i = 0; i < numberOfStudents; i++) {
//            StudentModel testStudent = new TestStudent();
//            testStudent.setExploratoryGrade(TestDataGenerator.getRandomDouble(100));
//            // Randomly select 5 shop choices.
//            // Use a shuffled list of numbers that contain numbers from 0 through the number of shops.
//            // Use first 5 numbers as the random indices used for the shop selection.
//            Integer[] randomIndices = TestDataGenerator.getRandomArrayOfIntegers(0, allShops.length);
//            for (int j = 0; j < 5; j++) {
//                testStudent.setShopChoiceAtIndex(j, allShops[randomIndices[j]]);
//            }
//            testStudents[i] = testStudent;
//        }
//        return testStudents;
//    }
//
//}

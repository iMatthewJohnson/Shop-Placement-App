package info.oldcolony.test.testdatageneration;

import info.oldcolony.shopplacementapp.model_controller.Shop;
import info.oldcolony.shopplacementapp.model_controller.Student;

public class TestStudent extends Student implements TestablePerson {

    private static Integer nextStudentId = 0;


    public TestStudent() {
        super(nextStudentId++, TestablePerson.randomFirstName(), TestablePerson.randomLastName());
    }

    public static Student[] generateTestStudents(int n) {
        Student[] testStudents = new Student[n];
        // Ensure all generated students are referring to the same instances of Shop.
        // Generate array of Shop instances of all the shops. This array will be used
        // as a "master list" that the generated students will use
        Shop[] allShops = TestShop.getAllShops();
        for (int i = 0; i < n; i++) {
            Student testStudent = new TestStudent();
            testStudent.setExploratoryGrade(TestDataGenerator.getRandomDouble(100));
            // Randomly select 5 shop choices.
            // Use a shuffled list of numbers that contain numbers from 0 through the number of shops.
            // Use first 5 numbers as the random indices used for the shop selection.
            Integer[] randomIndices = TestDataGenerator.getRandomArrayOfIntegers(0, allShops.length);
            for (int j = 0; j < 5; j++) {
                testStudent.setShopChoiceAtIndex(j, allShops[randomIndices[j]]);
            }

        }
        return testStudents;
    }

}

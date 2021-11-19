package info.oldcolony.test.testdatageneration;

import info.oldcolony.shopplacementapp.Student;

public class TestStudent extends Student implements TestablePerson {

    private static Integer nextStudentId = 0;


    public TestStudent() {
        super(nextStudentId++, TestablePerson.randomFirstName(), TestablePerson.randomLastName());
    }

    public static Student[] generateTestStudents(int n) {
        Student[] testStudents = new Student[n];
        for (int i = 0; i < n; i++) {
            testStudents[i] = new TestStudent();
        }
        return testStudents;
    }

}

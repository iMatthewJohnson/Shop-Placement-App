package info.oldcolony.test.testdatageneration;

import info.oldcolony.shopplacementapp.Student;

public class TestStudent extends Student implements TestablePerson {

    private static Integer nextStudentId = 0;


    public TestStudent() {
        super(nextStudentId++, TestablePerson.randomFirstName(), TestablePerson.randomLastName());
    }

}

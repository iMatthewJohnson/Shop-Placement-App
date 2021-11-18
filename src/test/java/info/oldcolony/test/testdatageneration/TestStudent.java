package info.oldcolony.test.testdatageneration;

public class TestStudent {

    private static Integer nextStudentId = 0;
    private Integer studentId;

    TestStudent() {
        super();
        studentId = nextStudentId++;
    }
}

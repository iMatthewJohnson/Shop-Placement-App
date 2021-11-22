package info.oldcolony.shopplacementapp;

import java.util.Objects;

public class Student implements Comparable {
    private String firstName;
    private String lastName;
    private Integer studentId;
    private Shop[] shopChoices;
    private Shop enrolledShop = null;
    private double exploratoryGrade;

    private static final double INIT_GRADE = 100.0;

    public Student(Integer studentId, String firstName, String lastName, Shop[] shopChoices, double exploratoryGrade, Shop enrolledShop) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.shopChoices = shopChoices;
        this.exploratoryGrade = exploratoryGrade;
        this.enrolledShop = enrolledShop;
    }

    public Student(Integer studentId, String firstName, String lastName) {
        this(studentId, firstName, lastName, null, INIT_GRADE, null);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Shop getShopChoiceAtIndex(int index) {
        return shopChoices[index];
    }

    public void setShopChoiceAtIndex(int index, Shop shopChoice) {
        // Lazy instantiation
        if (shopChoices == null) shopChoices = new Shop[5];
        shopChoices[index] = shopChoice;
    }

    public double getExploratoryGrade() {
        return exploratoryGrade;
    }

    public void setExploratoryGrade(double exploratoryGrade) {
        this.exploratoryGrade = exploratoryGrade;
    }

    public void setEnrolledShop(Shop shop) {
        this.enrolledShop = shop;
    }

    public Shop getEnrolledShop() {
        return this.enrolledShop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return firstName.equals(student.firstName) && lastName.equals(student.lastName) && studentId.equals(student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, studentId);
    }

    @Override
    public int compareTo(Object o) {
        Student otherStudent = (Student) o;
        if (exploratoryGrade > otherStudent.getExploratoryGrade()) return -1;
        if (exploratoryGrade < otherStudent.getExploratoryGrade()) return 1;
        return 0;
    }

}

package info.oldcolony.shopplacementapp.model_controller;

import com.sun.istack.NotNull;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    private final Integer studentId;
    private Shop[] shopChoices;
    private Shop enrolledShop;
    // Grade is Double instead of double, so object can be nullable (and checks can be run to check if null or not).
    private Double exploratoryGrade;

    /**
     * Creates new {@code Student} object with provided student ID, first name, last name, a {@code Shop} array of
     * student's shop choices, exploratory grade, and current enrolled shop.
     * @param studentId @NotNull student's student ID
     * @param firstName @NotNull student's first name
     * @param lastName @NotNull student's last name
     * @param shopChoices @Nullable student's shop choices
     * @param exploratoryGrade @Nullable student's exploratory grade
     * @param enrolledShop @Nullable student's enrolled shop
     */
    public Student(@NotNull Integer studentId,
                   @NotNull String firstName,
                   @NotNull String lastName,
                   @Nullable Shop[] shopChoices,
                   @Nullable Double exploratoryGrade,
                   @Nullable Shop enrolledShop) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.shopChoices = shopChoices;
        this.exploratoryGrade = exploratoryGrade;
        this.enrolledShop = enrolledShop;
    }

    /**
     * Creates new {@code Student} object using a provided student ID, first name, and last name
     * @param studentId @NotNull student's student ID
     * @param firstName @NotNull student's first name
     * @param lastName @NotNull student's last name
     */
    public Student(@NotNull Integer studentId,
                   @NotNull String firstName,
                   @NotNull String lastName) {
        this(studentId, firstName, lastName, null, null, null);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    /**
     * Returns the student's shop choice at a specific index. The student's xth shop choice, where x is index + 1.
     */
    public Shop getShopChoiceAtIndex(int index) {
        if (index >= shopChoices.length || index < 0)
            throw new IllegalArgumentException("Index must be greater than or equal to 0, or be less than the maximum" +
                    " number of shop choices - 1.");
        return shopChoices[index];
    }

    /**
     * Sets a specified shop at a specified index. The student's xth shop choice, where x is index + 1.
     * @param index The index to place in student's shop choices
     * @param shopChoice A {@code Shop} instance that the student is choosing.
     */
    public void setShopChoiceAtIndex(int index, Shop shopChoice) {
        // Lazy instantiation
        if (shopChoices == null) shopChoices = new Shop[5];
        shopChoices[index] = shopChoice;
    }

    public Double getExploratoryGrade() {
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

    // Overwritten Object's methods (equals, hashcode, and toString)
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
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId=" + studentId +
                ", shopChoices=" + Arrays.toString(shopChoices) +
                ", enrolledShop=" + enrolledShop +
                ", exploratoryGrade=" + exploratoryGrade +
                '}';
    }

    // Comparable classes used for sorting Student objects in different ways. Presumably, we could add more Comparators
    // to sort students by last name, first name, etc.
    static class ExploratoryGradeCompare implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return Double.compare(o1.getExploratoryGrade(), o2.getExploratoryGrade());
        }
    }

}
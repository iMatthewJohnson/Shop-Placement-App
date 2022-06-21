package info.oldcolony.shopplacementapp.cruds;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity // This tells Hibernate to make a table out of this class
public class StudentEntity {
    @Id
    private Integer studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String choice1 = null;
    private String choice2 = null;
    private String choice3 = null;
    private String choice4 = null;
    private String choice5 = null;
    private String enrolledShop = null;
    private double exploratoryGrade;

    public StudentEntity() {
        super();
    }

    public StudentEntity(Integer studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getEnrolledShop() {
        return enrolledShop;
    }

    public void setEnrolledShop(String enrolledShop) {
        this.enrolledShop = enrolledShop;
    }

    public double getExploratoryGrade() {
        return exploratoryGrade;
    }

    public void setExploratoryGrade(double exploratoryGrade) {
        this.exploratoryGrade = exploratoryGrade;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

    public String getChoice5() {
        return choice5;
    }

    public void setChoice5(String choice5) {
        this.choice5 = choice5;
    }
}

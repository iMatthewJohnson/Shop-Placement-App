package info.oldcolony.shopplacementapp.cruds;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="students")
public class Student {
    @Id
    private Long studentId;
    private String firstName;
    private String lastName;
    private Long idOfEnrolledShop = null;
    private Double exploratoryGrade;
    @ElementCollection
    private List<Long> idsOfShopChoices;

    public Student() {
        super();
    }

    public Student(Long studentId, String firstName, String lastName) {
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getIdOfEnrolledShop() {
        return idOfEnrolledShop;
    }

    public void setIdOfEnrolledShop(Long enrolledShopId) {
        this.idOfEnrolledShop = enrolledShopId;
    }

    public double getExploratoryGrade() {
        return exploratoryGrade;
    }

    public void setExploratoryGrade(double exploratoryGrade) {
        this.exploratoryGrade = exploratoryGrade;
    }

    public List<Long> getIdsOfShopChoices() {
        return new ArrayList<Long>(this.idsOfShopChoices);
    }

    public void setIdsOfShopChoices(List<Long> idsOfShopChoices) {
        this.idsOfShopChoices = idsOfShopChoices;
    }

    public void setIdOfShopChoiceAtIndex(int index,  Long idOfShopChoice) {
        idsOfShopChoices.set(index, idOfShopChoice);
    }

    public Long getIdOfShopChoiceAtIndex(int index) {
        return idsOfShopChoices.get(index);
    }
}
